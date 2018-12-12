package com.example.mbpsdownloadcalculator

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableDouble



class MbpsMibTimeViewModel : ViewModel() {
    //Flag for checking for invalid user input
    //True: input valid. E.g integer
    //False: input invalid. E.g zeros, empty input
    var validMbps = false
    var validMib = false
    var mbps = 0.0
    var mib = 0.0
    val transferTime = ObservableDouble()
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
        return (mib * 8.389) / mbps
    }
}

//    fun recompute():Double{
//        return transferTime.get()
//    }

//    fun onTextChanged(s: CharSequence) {
//        mib.set(s.toString().toDouble())
//    }

//    fun onTitleTextChanged(): TextWatcher {
//        return object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//
//            }
//            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//
//            }
//
//            override fun afterTextChanged(editable: Editable) {
//
//            }
//        }
//    }



//class User : BaseObservable() {
//
//    @get:Bindable
//    var mbps: Double = 0.0
//        set(value) {
//            field = value
//            //notifyPropertyChanged(BR.mbps)
//        }
//
//    @get:Bindable
//    var mib: Double = 0.0
//        set(value) {
//            field = value
//            //notifyPropertyChanged(BR.mib)
//        }
//}
