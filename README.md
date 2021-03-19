##TimePickerView
Useage:
```
implementation 'com.wangyunxiu.lib:picker-view:0.1'
```
And Code:
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
```
