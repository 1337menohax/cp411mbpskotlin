package com.example.mbpsdownloadcalculator

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableDouble
import android.util.Log


class MbpsMibTimeViewModel : ViewModel() {

    var mbps = ObservableDouble()
    var mib = ObservableDouble()
    var transferTime: ObservableDouble = object : ObservableDouble(mbps,mib) {
        override fun get(): Double {
            return (mib.get()*8.389)/mbps.get()

        }
    }
    fun recompute():ObservableDouble{
        return transferTime //todo change to transfertime
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        var transferTime: ObservableDouble = object : ObservableDouble(mbps,mib) {
            override fun get(): Double {
                return (mib.get()*8.389)/mbps.get()

            }
        }
        Log.w("tag", "onTextChanged " + transferTime);
    }
}
