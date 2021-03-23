##TimePickerView
Useage:
```
implementation 'com.wangyunxiu.lib:picker-view:0.1'
```
And Code:
时间选择器
```
TimeChoosePopWindow pop=new TimeChoosePopWindow(this, new TimeChoosePopWindow.OnActionListener() {
            @Override
            public void onDismiss(TimeChoosePopWindow pop) {
            }
            @Override
            public void onCancel(TimeChoosePopWindow pop) {
            }
            @Override
            public void onConfirm(Calendar date) {
            }
        });
pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
```
年月日选择器
```
DateChoosePopWindow pop=new DateChoosePopWindow(this, new DateChoosePopWindow.OnActionListener() {
            @Override
            public void onDismiss(DateChoosePopWindow pop) {
            }
            @Override
            public void onCancel(DateChoosePopWindow pop) {
            }
            @Override
            public void onConfirm(Calendar date) {
            }
        });
pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
```
单项选择器
```
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
```
