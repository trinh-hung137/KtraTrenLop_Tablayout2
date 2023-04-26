package com.example.ktratrenlop_tablayout.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ktratrenlop_tablayout.R;
import com.example.ktratrenlop_tablayout.database.SQLiteHelper;
import com.example.ktratrenlop_tablayout.model.CongViec;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText eTen, eND, eNgay;
    CheckBox cbTT, cbCT, cbTT_1, cbTT_2;
    Button btnUpdate, btnDelete, btnCancel;
    LinearLayout linearLayoutcheckbox;
    RadioGroup eRadioGroup;
    RadioButton radio_button_1,radio_button_2,radio_button_3;
    CongViec cv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        initView();

        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        eNgay.setOnClickListener(this);

        Intent intent = getIntent();
        cv = (CongViec) intent.getSerializableExtra("cv");
        eTen.setText(cv.getTen());
        eND.setText(cv.getNoidung());
        eNgay.setText(cv.getNgay());
        String textViewValue = cv.getTinhtrang().toString();
        String[] checkboxValues = textViewValue.split(",");
        for (String item : checkboxValues) {
            if (item.equals("Hoan thanh")) {
                cbTT.setChecked(true);
                cbTT_1.setChecked(false);
                cbTT_2.setChecked(false);
            } else if (item.equals("Chua thuc hien")) {
                cbTT.setChecked(false);
                cbTT_1.setChecked(true);
                cbTT_2.setChecked(false);
            } else if(item.equals("Dang thuc hien")){
                cbTT.setChecked(false);
                cbTT_1.setChecked(false);
                cbTT_2.setChecked(true);
            }
        }

        cbCT.setChecked(cv.isCongtac()?true:false);
        String text = cv.getRadiobutton().toString();
        for (int i = 0; i < eRadioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) eRadioGroup.getChildAt(i);
            if (radioButton.getText().toString().equals(text)) {
                radioButton.setChecked(true);
                break;
            }
        }
    }
    private void initView() {
        eTen = findViewById(R.id.eTen);
        eND = findViewById(R.id.eND);
        eNgay = findViewById(R.id.eNgay);
        cbTT = findViewById(R.id.cbTT);
        cbCT = findViewById(R.id.cbCT);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
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
            DatePickerDialog dialog = new DatePickerDialog(UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if(view == btnUpdate){

            String ten = eTen.getText().toString();
            String nd = eND.getText().toString();
            String ngay = eNgay.getText().toString();
//            Boolean tt = cbTT.isChecked();
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
            String textradio="";
            int selectedId = eRadioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton radioButton = findViewById(selectedId);
                textradio = radioButton.getText().toString();
            }
            SQLiteHelper db = new SQLiteHelper(this);
            db.update(new CongViec(cv.getId(), ten, nd, ngay, st1, ct,textradio));
            finish();
        }
        if(view == btnDelete){
            int id = cv.getId();
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Co chac xoa ko?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SQLiteHelper db = new SQLiteHelper(view.getContext());
                    db.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}