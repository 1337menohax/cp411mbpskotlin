package com.example.mbpsdownloadcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {


    //Flag for checking for invalid user input
    //True: input valid. E.g integer
    //False: input invalid. E.g zeros, empty input
    internal var validMbps = false
    internal var validMib = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*tv_result = findViewById(R.id.resultText)
        et_mbps = findViewById(R.id.mbpsText)
        et_mib = findViewById(R.id.mibText)*/

        mbpsText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //To check if string is not empty
                //DO:Convert user input into userMbps.
                //ELSE:display "invalid input" onto the screen
                //PROBLEM: val userMbps cannot be reassign
                if (!mbpsText.text.toString().isEmpty()) {
                    validMbps = true
                    if (getMib() == 0) {
                        resultText.text = getString(R.string.default_Invalid)
                        validMib = false
                    }
                } else {
                    resultText.text = getString(R.string.default_Sec)
                    validMbps = false
                }
            }
            //If both mbps and mib editText are BOTH fill out, start calculating
            //DO: call calculate()
            override fun afterTextChanged(editable: Editable) {
                if (validMbps && validMib) {
                    resultText.setText(String.format("%.1f", calculate(getMbps(), getMib())))
                }
            }
        })
        mibText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!mibText.text.toString().isEmpty()) {
                    validMib = true
                    //For invalid MiB value
                    //this is for in case where we divide by 0
                    if (getMib() == 0) {
                        resultText.text = getString(R.string.default_Invalid)
                        validMib = false
                    }
                } else {
                    resultText.text = getString(R.string.default_Sec)
                    validMib = false
                }
            }
            //If both mbps and mib are both fill out, start calculation
            override fun afterTextChanged(editable: Editable) {
                if (validMbps && validMib) {
                    resultText.setText(String.format("%.1f", calculate(getMbps(), getMib())))
                }
            }
        })
    }

    private fun calculate(mbps: Int, mib: Int): Double {
        val megaBit = mib * 8.389
        val tranferTime = megaBit / mbps
        return tranferTime
    }
    private fun getMbps():Int {
        val userMbps = Integer.parseInt(mbpsText.text.toString())
        return userMbps
    }
    private fun getMib():Int {
        val userMib = Integer.parseInt(mibText.text.toString())
        return userMib
    }
}

