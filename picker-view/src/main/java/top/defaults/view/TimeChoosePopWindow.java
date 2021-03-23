package top.defaults.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Calendar;

public class TimeChoosePopWindow extends PopupWindow implements View.OnClickListener {
    View view;
    Context context;
    TextView tv_title;
    DateTimePickerView pv_timer;
    TextView tv_cancel, tv_ok;
    OnActionListener onActionListener;

    public TimeChoosePopWindow(Context context, OnActionListener onActionListener) {
        super(context);
        this.context = context;
        initView();
        this.onActionListener = onActionListener;
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.popwindow_time_choose, null);
        tv_title = view.findViewById(R.id.tv_title);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
        tv_ok = view.findViewById(R.id.tv_ok);
        pv_timer = view.findViewById(R.id.pv_timer);
        pv_timer.setOnSelectedDateChangedListener(new DateTimePickerView.OnSelectedDateChangedListener() {
            @Override
            public void onSelectedDateChanged(Calendar date) {
                refreshTitle();
            }
        });

        this.setContentView(view);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        refreshTitle();
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                if (onActionListener != null) {
                    onActionListener.onDismiss(TimeChoosePopWindow.this);
                }
            }
        });
    }

    public void refreshTitle() {
        Calendar date = pv_timer.getSelectedDate();
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
        int hour = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);
        tv_title.setText(year + "年" + month + "月" + dayOfMonth + "日");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cancel) {
            dismiss();
            onActionListener.onDismiss(TimeChoosePopWindow.this);
        }
        if (view.getId() == R.id.tv_ok) {
            onActionListener.onConfirm(this,pv_timer.getSelectedDate());
        }
    }

    public interface OnActionListener {
        public void onDismiss(TimeChoosePopWindow pop);

        public void onCancel(TimeChoosePopWindow pop);

        public void onConfirm(TimeChoosePopWindow pop,Calendar date);
    }
}
