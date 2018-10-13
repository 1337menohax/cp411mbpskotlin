package com.example.mbpsdownloadcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    internal val et_mbps: EditText
    internal val et_mib: EditText
    internal val tv_result: TextView


    internal val transferTime = 0.0
    internal val userMbps: Int = 0
    internal val userMib = 0
    internal val flagMbps: Boolean = false
    internal val flagMib = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_result = findViewById(R.id.resultText)
        et_mbps = findViewById(R.id.mbpsText)
        et_mib = findViewById(R.id.mibText)

        et_mbps.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!et_mbps.text.toString().isEmpty()) {
                    userMbps = Integer.parseInt(et_mbps.text.toString())
                    flagMbps = true
                } else {
                    tv_result.text = getString(R.string.default_Sec)
                    flagMbps = false
                }
            }

            //If both mbps and mib editText are both fill out, start calculating
            override fun afterTextChanged(editable: Editable) {
                if (flagMbps && flagMib) {
                    transferTime = calculate(userMbps, userMib)
                    tv_result.setText(String.format("%.1f", transferTime))
                }
            }
        })
        et_mib.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!et_mib.text.toString().isEmpty()) {
                    userMib = Integer.parseInt(et_mib.text.toString())
                    flagMib = true
                    //For invalid MiB value
                    if (userMib == 0) {
                        tv_result.text = "Invalid file size"
                        flagMib = false
                    } else {
                        flagMib = true
                    }
                } else {
                    tv_result.text = getString(R.string.default_Sec)
                    flagMib = false
                }//When EditText is empty, replace with default second
                //flag_mbps = false to avoid calculation
            }

            //If both mbps and mib are both fill out, start calculation
            override fun afterTextChanged(editable: Editable) {
                if (flagMbps && flagMib) {
                    transferTime = calculate(userMbps, userMib)
                    tv_result.setText(String.format("%.1f", transferTime))

                }
            }
        })
    }

    private fun calculate(mbps: Int, mib: Int): Double {
        val megaBit = mib * 8.389
        return megaBit / mbps
    }
}

