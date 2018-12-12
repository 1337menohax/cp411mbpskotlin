package com.example.mbpsdownloadcalculator

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableDouble
import java.text.DecimalFormat



class MbpsMibTimeViewModel : ViewModel() {
    //Flag for checking for invalid user input
    //True: input valid. E.g integer
    //False: input invalid. E.g zeros, empty input
    var validMbps = false
    var validMib = false

    var mbps :Double = 0.0
    var mib :Double = 0.0
    val transferTime = ObservableDouble()

    /** FUNC: onMbps()
     * DESC: Call when theres a text change in Mbps editview
     * */
    fun onMbps(s:CharSequence){
        if (s.toString().isEmpty() || s.toString() == ".") {
            validMbps = false
            transferTime.set(0.0)
        }
        else {
            validMbps = true
            mbps = s.toString().toDouble()
            if (mbps == 0.0){
                validMbps = false
                transferTime.set(0.0)
            }
        }
        if (validMbps && validMib) {
            transferTime.set(calculate(mbps,mib))
        }

    }
    /** FUNC: onMib()
     * DESC: Call when theres a text change in Mib editview
     * */
    fun onMib(s:CharSequence){
        if (s.toString().isEmpty()|| s.toString() == ".") {
            validMib = false
            transferTime.set(0.0)
            }
        else {
            validMib = true
            mib = s.toString().toDouble()
            }
        if (validMbps && validMib) {
            transferTime.set(calculate(mbps,mib))
        }
    }

    private fun calculate(mbps:Double, mib:Double):Double{
        val result = (mib * 8.389 / mbps)
        val df = DecimalFormat("#.##")
        return java.lang.Double.valueOf(df.format(result))
    }
}

