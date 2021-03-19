package top.defaults.pickerviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import top.defaults.view.TimeChoosePopWindow;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.defaultPicker) void defaultPicker() {

        TimeChoosePopWindow pop=new TimeChoosePopWindow(this, new TimeChoosePopWindow.OnActionListener() {
            @Override
            public void onDismiss(TimeChoosePopWindow pop) {
                bgAlpha(1.0f);
            }
            @Override
            public void onCancel(TimeChoosePopWindow pop) {
            }
            @Override
            public void onConfirm(Calendar date) {
            }
        });

        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM,0,0);
        bgAlpha(0.6f);
    }

    private  void bgAlpha(float f){
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = f;
        getWindow().setAttributes(layoutParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
