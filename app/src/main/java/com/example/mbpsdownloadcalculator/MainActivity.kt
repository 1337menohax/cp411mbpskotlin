package com.example.mbpsdownloadcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {



    /*internal val transferTime = 0.0
    internal val userMib = 0
    internal val flagMbps: Boolean = false
    internal val flagMib = false*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*tv_result = findViewById(R.id.resultText)
        et_mbps = findViewById(R.id.mbpsText)
        et_mib = findViewById(R.id.mibText)*/

        mbpsText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!mbpsText.text.toString().isEmpty()) {
                    val userMbps = Integer.parseInt(mbpsText.text.toString())
                    val flagMbps = true
                } else {
                    resultText.text = getString(R.string.default_Sec)
                    val flagMbps = false
                }
            }

            //If both mbps and mib editText are both fill out, start calculating
            override fun afterTextChanged(editable: Editable) {
                if (flagMbps && flagMib) {
                    transferTime = calculate(userMbps, userMib)
                    resultText.setText(String.format("%.1f", transferTime))
                }
            }
        })
        mibText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!mibText.text.toString().isEmpty()) {
                    userMib = Integer.parseInt(mibText.text.toString())
                    flagMib = true
                    //For invalid MiB value
                    if (userMib == 0) {
                        resultText.text = "Invalid file size"
                        flagMib = false
                    } else {
                        flagMib = true
                    }
                } else {
                    resultText.text = getString(R.string.default_Sec)
                    flagMib = false
                }//When EditText is empty, replace with default second
                //flag_mbps = false to avoid calculation
            }

            //If both mbps and mib are both fill out, start calculation
            override fun afterTextChanged(editable: Editable) {
                if (flagMbps && flagMib) {
                    transferTime = calculate(userMbps, userMib)
                    resultText.setText(String.format("%.1f", transferTime))

                }
            }
        })
    }

    private fun calculate(mbps: Int, mib: Int): Double {
        val megaBit = mib * 8.389
        return megaBit / mbps
    }
}

