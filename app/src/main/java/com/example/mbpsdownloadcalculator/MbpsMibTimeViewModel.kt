package com.example.mbpsdownloadcalculator

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableDouble
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.mbpsdownloadcalculator.R.id.mbpsText
import com.example.mbpsdownloadcalculator.R.id.mibText
import android.text.SpannableString





class MbpsMibTimeViewModel : ViewModel() {
//    var mbps = ObservableDouble()
//    var mib = ObservableDouble()
//    val transferTime: ObservableDouble = object : ObservableDouble(mbps, mib) {
//        override fun get(): Double {
//            return (mib.get() * 8.389) / mbps.get()
//        }
//    }
//
//    fun recompute():Double{
//        return transferTime.get()
//    }

//    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//        mbps= java.lang.Double.parseDouble(s.toString())
//
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

}

//    fun recompute(): ObservableDouble {
//        return transferTime //todo change to transfertime
//    }
//class User : BaseObservable() {
//
//    @get:Bindable
//    var mbps: Double = 0.0
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.mbps)
//        }
//
//    @get:Bindable
//    var mib: Double = 0.0
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.mib)
//        }
//}
