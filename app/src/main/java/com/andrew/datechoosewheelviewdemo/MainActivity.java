package com.andrew.datechoosewheelviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mStartDateButton;
    private Button mEndDateButton;
    private Button mDateValidButton;
    private TextView mShowContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartDateButton = (Button) this.findViewById(R.id.start_date_btn);
        mEndDateButton = (Button) this.findViewById(R.id.end_date_btn);
        mDateValidButton = (Button) this.findViewById(R.id.date_valid_btn);
        mShowContentTextView = (TextView) this.findViewById(R.id.show_content_tv);

        mStartDateButton.setOnClickListener(this);
        mEndDateButton.setOnClickListener(this);
        mDateValidButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_date_btn://开始时间
                DateChooseWheelViewDialog startDateChooseDialog = new DateChooseWheelViewDialog(MainActivity.this, new DateChooseWheelViewDialog.DateChooseInterface() {
                    @Override
                    public void getDateTime(String time, boolean longTimeChecked) {
                        mShowContentTextView.setText(time);
                    }
                });
                startDateChooseDialog.setDateDialogTitle("开始时间");
                startDateChooseDialog.showDateChooseDialog();
                break;
            case R.id.end_date_btn://结束时间
                DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(MainActivity.this,
                        new DateChooseWheelViewDialog.DateChooseInterface() {
                            @Override
                            public void getDateTime(String time, boolean longTimeChecked) {
                                mShowContentTextView.setText(time);
                            }
                        });
                endDateChooseDialog.setTimePickerGone(true);
                endDateChooseDialog.setDateDialogTitle("结束时间");
                endDateChooseDialog.showDateChooseDialog();
                break;
            case R.id.date_valid_btn://身份证有效期
                DateChooseWheelViewDialog dateValidChooseDialog = new DateChooseWheelViewDialog(MainActivity.this,
                        new DateChooseWheelViewDialog.DateChooseInterface() {
                            @Override
                            public void getDateTime(String time, boolean longTimeChecked) {
                                if (longTimeChecked) {
                                    mShowContentTextView.setText("长期  ");
                                } else {
                                    mShowContentTextView.setText(time);
                                }
                            }
                        });
                dateValidChooseDialog.setTimePickerGone(true);
                dateValidChooseDialog.showLongTerm(true);
                dateValidChooseDialog.setDateDialogTitle("身份证到期时间");
                dateValidChooseDialog.showDateChooseDialog();
                break;
            default:
                break;
        }

    }
}
