package top.defaults.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SingleChoosePopWindow extends PopupWindow implements View.OnClickListener {
    View view;
    Context context;
    TextView tv_title;
    SinglePickerView pv_picker;
    TextView tv_cancel, tv_ok;
    OnActionListener onActionListener;
    List<String> items=new ArrayList<>();

    public SingleChoosePopWindow(Context context, List<String> items, OnActionListener onActionListener) {
        super(context);
        this.context = context;
        this.onActionListener = onActionListener;
        this.items = items;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.popwindow_single_choose, null);
        tv_title = view.findViewById(R.id.tv_title);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
        tv_ok = view.findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(this);
        pv_picker = view.findViewById(R.id.pv_picker);
        pv_picker.setItems(this.items);

        pv_picker.setOnSelectedChangedListener(new SinglePickerView.OnSelectedChangedListener() {
            @Override
            public void OnSelectedChanged(SinglePickerView view, int position, String value) {

            }
        });
        this.setContentView(view);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                if (onActionListener != null) {
                    onActionListener.onDismiss(SingleChoosePopWindow.this);
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cancel) {
            dismiss();
            onActionListener.onDismiss(SingleChoosePopWindow.this);
        }
        if (view.getId() == R.id.tv_ok) {
            onActionListener.onConfirm(pv_picker.getSelected_position(), pv_picker.getSelected_value());
        }
    }

    public interface OnActionListener {
        public void onDismiss(SingleChoosePopWindow pop);
        public void onCancel(SingleChoosePopWindow pop);
        public void onConfirm(int position, String value);
    }
}
