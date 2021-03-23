package top.defaults.pickerviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import top.defaults.view.DateChoosePopWindow;
import top.defaults.view.SingleChoosePopWindow;
import top.defaults.view.TimeChoosePopWindow;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.defaultPicker)
    void defaultPicker() {

//        TimeChoosePopWindow pop=new TimeChoosePopWindow(this, new TimeChoosePopWindow.OnActionListener() {
//            @Override
//            public void onDismiss(TimeChoosePopWindow pop) {
//                bgAlpha(1.0f);
//            }
//            @Override
//            public void onCancel(TimeChoosePopWindow pop) {
//            }
//            @Override
//            public void onConfirm(Calendar date) {
//            }
//        });
//
//        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM,0,0);
//        bgAlpha(0.6f);

//        DateChoosePopWindow pop=new DateChoosePopWindow(this, new DateChoosePopWindow.OnActionListener() {
//            @Override
//            public void onDismiss(DateChoosePopWindow pop) {
//                bgAlpha(1.0f);
//            }
//            @Override
//            public void onCancel(DateChoosePopWindow pop) {
//            }
//            @Override
//            public void onConfirm(Calendar date) {
//                Log.i("asd",date.toString());
//            }
//        });
//
//        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM,0,0);
//        bgAlpha(0.6f);

        List<String> items=new ArrayList<>();
        items.add("ABCASASD");
        items.add("BBCASASD");
        items.add("CBCASASD");
        items.add("DCASASD");
        SingleChoosePopWindow pop = new SingleChoosePopWindow(this,items, new SingleChoosePopWindow.OnActionListener() {
            @Override
            public void onDismiss(SingleChoosePopWindow pop) {
                bgAlpha(1.0f);
            }
            @Override
            public void onCancel(SingleChoosePopWindow pop) {
            }
            @Override
            public void onConfirm(int position, String value) {
                Log.i("asds",value);
            }
        });

        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
        bgAlpha(0.6f);
    }

    private void bgAlpha(float f) {
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
