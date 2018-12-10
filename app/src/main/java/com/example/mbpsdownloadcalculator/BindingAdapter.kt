package com.example.mbpsdownloadcalculator

import android.databinding.BindingAdapter
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.content.res.Resources
import android.databinding.InverseBindingListener
import android.databinding.adapters.ListenerUtil
import com.android.databinding.library.baseAdapters.R


object BindingAdapter {
    var validMbps = false
    var validMib = false
    @BindingAdapter(value = ["android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "android:textAttrChanged"], requireAll = false)
    @JvmStatic
    fun setTextWatcher(view: TextView, before: BeforeTextChanged?,
                       on: OnTextChanged?, after: AfterTextChanged?,
                       textAttrChanged: InverseBindingListener?) {
        val newValue: TextWatcher?
        if (before == null && after == null && on == null && textAttrChanged == null) {
            newValue = null
        } else {
            newValue = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    before?.beforeTextChanged(s, start, count, after)
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    on?.onTextChanged(s, start, before, count)
                    textAttrChanged?.onChange()
                }

                override fun afterTextChanged(s: Editable) {
                    after?.afterTextChanged(s)
                }
            }
        }
        val oldValue = ListenerUtil.trackListener<TextWatcher>(view, newValue, R.id.textWatcher)
        if (oldValue != null) {
            view.removeTextChangedListener(oldValue)
        }
        if (newValue != null) {
            view.addTextChangedListener(newValue)
        }
    }

    interface AfterTextChanged {
        fun afterTextChanged(s: Editable)
    }

    interface BeforeTextChanged {
        fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int)
    }

    interface OnTextChanged {
        fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
    }
}
