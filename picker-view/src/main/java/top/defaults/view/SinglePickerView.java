package top.defaults.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SinglePickerView extends PickerViewGroup {

    private PickerView picker;
    private List<String> items = new ArrayList<>();
    private Context context;

    private OnSelectedChangedListener onSelectedChangedListener;


    public void setOnSelectedChangedListener(OnSelectedChangedListener onSelectedChangedListener) {
        this.onSelectedChangedListener = onSelectedChangedListener;
    }

    public SinglePickerView(Context context) {
        this(context, null);
    }

    public SinglePickerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public SinglePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setItems(List<String> items) {
        this.items = items;
        buildViews();
    }

    private void buildViews() {
        removeAllViews();
        picker = new PickerView(context);
        picker.setOnSelectedItemChangedListener(new PickerView.OnSelectedItemChangedListener() {
            @Override
            public void onSelectedItemChanged(PickerView pickerView, int previousPosition, int selectedItemPosition) {
                if(onSelectedChangedListener!=null)
                    onSelectedChangedListener.OnSelectedChanged(SinglePickerView.this,selectedItemPosition,items.get(selectedItemPosition));
            }
        });
        picker.setAdapter(new PickerView.Adapter<SigleFileld>() {
            @Override
            public int getItemCount() {
                return items.size();
            }
            @Override
            public SigleFileld getItem(int index) {
                return new SigleFileld(items.get(index));
            }
        });
        addPickerView(picker,false);
    }

    protected void addPickerView(PickerView pickerView, boolean narrow) {
        LinearLayout.LayoutParams layoutParams = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, narrow ? 1 : 2);
        addView(pickerView, layoutParams);
    }


    public int getSelected_position() {
        return picker.getSelectedItemPosition();
    }

    public String getSelected_value() {
        return items.get(picker.getSelectedItemPosition());
    }

    private static class SigleFileld implements PickerView.PickerItem {
        protected String value;

        SigleFileld(String value) {
            this.value = value;
        }

        @Override
        public String getText() {
            return value;
        }
    }


    public interface OnSelectedChangedListener{
        public void OnSelectedChanged(SinglePickerView view,int position,String value);
    }
}
