package com.example.ktratrenlop_tablayout.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


import com.example.ktratrenlop_tablayout.R;
import com.example.ktratrenlop_tablayout.database.SQLiteHelper;
import com.example.ktratrenlop_tablayout.model.CongViec;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText eTen, eND, eNgay;
    CheckBox cbTT, cbCT, cbTT_1, cbTT_2;
    Button btnAdd, btnCancel;
    RadioGroup eRadioGroup;
    RadioButton radio_button_1,radio_button_2,radio_button_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();

        btnAdd.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        eNgay.setOnClickListener(this);
    }

    private void initView() {
        eTen = findViewById(R.id.eTen);
        eND = findViewById(R.id.eND);
        eNgay = findViewById(R.id.eNgay);
        cbTT = findViewById(R.id.cbTT);
        cbCT = findViewById(R.id.cbCT);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        cbTT_1 = findViewById(R.id.cbTT_1);
        cbTT_2 = findViewById(R.id.cbTT_2);
        eRadioGroup = findViewById(R.id.eRadioGroup);
        radio_button_1 = findViewById(R.id.radio_button_1);
        radio_button_2 = findViewById(R.id.radio_button_2);
        radio_button_3 = findViewById(R.id.radio_button_3);
    }

    @Override
    public void onClick(View view) {
        if(view == eNgay){
            final Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date = "";
                    if(m>8){
                        date = y+"/"+(m+1)+"/"+d;
                    }else {
                        date = y+"/0"+(m+1)+"/"+d;
                    }
                    eNgay.setText(date);
                }
            }, y, m, d);
            dialog.show();
        }
        if (view == btnCancel){
            finish();
        }
        if(view == btnAdd){
            String ten = eTen.getText().toString();
            String nd = eND.getText().toString();
            String ngay = eNgay.getText().toString();
            String st1="";
            if(cbTT.isChecked()){
                st1+=cbTT.getText().toString() +",";
            }
            if(cbTT_1.isChecked()){
                st1+=cbTT_1.getText().toString() +",";
            }
            if(cbTT_2.isChecked()){
                st1+=cbTT_2.getText().toString() +",";
            }
            Boolean ct = cbCT.isChecked();
            int selectedId = eRadioGroup.getCheckedRadioButtonId();
            String textradio="";
            if (selectedId != -1) {
                RadioButton radioButton = findViewById(selectedId);
                textradio = radioButton.getText().toString();
            }
            SQLiteHelper db = new SQLiteHelper(this);
            db.addCv(new CongViec(ten, nd, ngay, st1, ct,textradio));
            finish();
        }
    }
}