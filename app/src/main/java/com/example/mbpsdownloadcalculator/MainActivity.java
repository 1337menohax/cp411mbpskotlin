package com.example.mbpsdownloadcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_mbps, et_mib;
    TextView tv_result;


    double transferTime = 0;
    int userMbps,userMib = 0;
    boolean flag_mbps,flag_mib = false;

    private double calculate(int mbps, int mib){
        double megaBit = mib * 8.389;
        return (megaBit/mbps);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result =  findViewById(R.id.resultText);
        et_mbps =  findViewById(R.id.mbpsText);
        et_mib = findViewById(R.id.mibText);

        et_mbps.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!et_mbps.getText().toString().isEmpty()){

                    userMbps = Integer.parseInt(et_mbps.getText().toString());
                    flag_mbps = true;
                }

                //TODO limit charsequence
                /*if(charSequence.length() >= 3){
                    et_mbps.setText("123");
                }
                Log.i("HIIII", String.valueOf(charSequence.length()));*/
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(flag_mbps && flag_mib){
                    transferTime = calculate(userMbps,userMib);
                    tv_result.setText(String.format("%.1f",transferTime));

                }
            }
        });
        et_mib.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!et_mib.getText().toString().isEmpty()){
                    userMib = Integer.parseInt(et_mib.getText().toString());
                    if(userMib == 0 ){
                        tv_result.setText("Invalid file size");
                        flag_mib = false;
                    }
                    else{
                        flag_mib = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(flag_mbps && flag_mib){
                    transferTime = calculate(userMbps,userMib);
                    tv_result.setText(String.format("%.1f",transferTime));

                }
            }
        });
    }



}

