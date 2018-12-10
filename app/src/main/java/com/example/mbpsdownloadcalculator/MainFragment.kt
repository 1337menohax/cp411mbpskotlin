package com.example.mbpsdownloadcalculator


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mbpsdownloadcalculator.databinding.FragmentMainBinding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    //Source: https://codelabs.developers.google.com/codelabs/android-databinding/#1
    //DESC: To obtain ViewModel from ViewModelProviders
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MbpsMibTimeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mbpsmibviewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Flag for checking for invalid user input
        //True: input valid. E.g integer
        //False: input invalid. E.g zeros, empty input
//        var validMbps = false
//        var validMib = false
//        mbpsText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                //To check if string is not empty
//                //DO: Set valid flag to true for later calculation
//                //ELSE: Display "invalid input" onto the screen
//                if (mbpsText.text.toString().isEmpty() || mbpsText.text.toString() == ".") {
//                    resultText.text = getString(R.string.default_Sec)
//                    validMbps = false
//                }
//                else {
//                    validMbps = true
//                    if (getMbps() == 0.0){
//                        resultText.text = getString(R.string.default_Invalid)
//                        validMbps = false
//                    }
//                }
//            }
//            //If mbps and mib flags are BOTH true, start calculating
//            //DO: call calculate()
//            override fun afterTextChanged(editable: Editable) {
//                if (validMbps && validMib) {
//                    resultText.setText(String.format("%.1f", calculate(getMbps(), getMib())))
//                }
//            }
//        })
//        mibText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                if (mibText.text.toString().isEmpty()|| mibText.text.toString() == ".") {
//                    validMib = false
//                    resultText.text = getString(R.string.default_Sec)
//                } else {
//                    validMib = true
//                }
//            }
//            //If both mbps and mib are both fill out, start calculation
//            override fun afterTextChanged(editable: Editable) {
//                if (validMbps && validMib) {
//                    resultText.setText(String.format("%.1f", calculate(getMbps(), getMib())))
//                }
//            }
//        })
    }
    companion object {
        fun newInstance() = MainFragment()
    }

/*    private fun getMbps():Double {
        //DESC: return user Mbps input
        return java.lang.Double.parseDouble(mbpsText.text.toString())
    }
    private fun getMib():Double {
        //DESC: return user Mib input
        return java.lang.Double.parseDouble(mibText.text.toString())
    }*/
}
