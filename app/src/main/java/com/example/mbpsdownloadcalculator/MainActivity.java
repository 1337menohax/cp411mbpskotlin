package com.example.mbpsdownloadcalculator;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_mbps, et_mib;
    TextView tv_result;
    Button calculate;

    double transferTime = 0;
    int mbps = 0;

    private Handler handler = new Handler();
//TODO find a better way to update textview when type in editview
    //fast clock for checking
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tv_result.setText(" "+mbps);

            handler.removeCallbacks(runnable);
            handler.postDelayed(this,500);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(runnable,500);
        tv_result =  findViewById(R.id.resultText);
        et_mbps =  findViewById(R.id.mbpsText);
        et_mib = findViewById(R.id.mibText);
        calculate = findViewById(R.id.button);

        //String temp_mbps = tv_mbps.getText().toString();
        //mbps = Integer.parseInt(temp_mbps);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbps = Integer.parseInt(et_mbps.getText().toString());
                tv_result.setText(" "+mbps);

            }
        });
    }



}

