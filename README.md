##TimePickerView
Useage:
```
implementation 'com.wangyunxiu.lib:picker-view:0.3'
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
            public void onConfirm(TimeChoosePopWindow pop,Calendar date) {
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
            public void onConfirm(DateChoosePopWindow pop,Calendar date) {
            }
        });
pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
```
单项选择器
```
SingleChoosePopWindow pop = new SingleChoosePopWindow(this,items, new SingleChoosePopWindow.OnActionListener() {
            @Override
            public void onDismiss(SingleChoosePopWindow pop) {
  
            }
            @Override
            public void onCancel(SingleChoosePopWindow pop) {
            }
            @Override
            public void onConfirm(SingleChoosePopWindow pop,int position, String value) {
            }
        });

pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
```


时间获取
```
Calendar date = pv_timer.getSelectedDate();
int year = date.get(Calendar.YEAR);
int month = date.get(Calendar.MONTH);
int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
int hour = date.get(Calendar.HOUR_OF_DAY);
int minute = date.get(Calendar.MINUTE);
tv_title.setText(year + "年" + month + "月" + dayOfMonth + "日");
```


