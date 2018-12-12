/*SCRATCH

package com.example.mbpsdownloadcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_mbps, et_mib;
    TextView tv_result;


    double transferTime = 0;
    int userMbps,userMib = 0;
    boolean flagMbps,flagMib = false;
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
                    flagMbps = true;
                }
                else
                {
                    tv_result.setText(getString(R.string.default_Sec));
                    flagMbps = false;
                }
            }
            //If both mbps and mib editText are both fill out, start calculating
            @Override
            public void afterTextChanged(Editable editable) {
                if(flagMbps && flagMib){
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
                    flagMib = true;
                    //For invalid MiB value
                    if(userMib == 0 ){
                        tv_result.setText("Invalid file size");
                        flagMib = false;
                    }
                    else{
                        flagMib = true;
                    }
                }
                //When EditText is empty, replace with default second
                //flag_mbps = false to avoid calculation
                else
                {
                    tv_result.setText(getString(R.string.default_Sec));
                    flagMib = false;
                }
            }

            //If both mbps and mib are both fill out, start calculation
            @Override
            public void afterTextChanged(Editable editable) {
                if(flagMbps && flagMib){
                    transferTime = calculate(userMbps,userMib);
                    tv_result.setText(String.format("%.1f",transferTime));
                }
            }
        });
    }
    private double calculate(int mbps, int mib){
        double megaBit = mib * 8.389;
        return (megaBit/mbps);
    }
}

*/
