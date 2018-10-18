package com.example.mbpsdownloadcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

//Last Update: 18OCT2018
//DESC: Takes user input: Mbps and Mib, to then calculate the transfer time.
//WARNING: THIS PROGRAM DOES NOT WORK ON DECIMAL NUMBERS
//Note to self: allow decimal inputs in the future
class MainActivity : AppCompatActivity() {

    //Flag for checking for invalid user input
    //True: input valid. E.g integer
    //False: input invalid. E.g zeros, empty input
    internal var validMbps = false
    internal var validMib = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbpsText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //To check if string is not empty
                //DO: Set valid flag to true for later calculation
                //ELSE: Display "invalid input" onto the screen
                if (!mbpsText.text.toString().isEmpty()) {
                    validMbps = true
                    //invalid msg if input 0
                    if (getMbps() == 0) {
                        resultText.text = getString(R.string.default_Invalid)
                        validMbps = false
                    }
                } else {
                    resultText.text = getString(R.string.default_Sec)
                    validMbps = false
                }
            }
            //If mbps and mib editText are BOTH fill out, start calculating
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
        //DESC: convert mib ->megabit, then calculate the transfer time
        val megaBit = mib * 8.389
        return megaBit / mbps
    }
    private fun getMbps():Int {
        //DESC: return user Mbps input
        return Integer.parseInt(mbpsText.text.toString())
    }
    private fun getMib():Int {
        //DESC: return user Mib input
        return Integer.parseInt(mibText.text.toString())
    }
}

