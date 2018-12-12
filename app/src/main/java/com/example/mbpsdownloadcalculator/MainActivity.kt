package com.example.mbpsdownloadcalculator

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Rect
import android.widget.EditText
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager



//Last Update: 11DEC2018
//DESC: Takes user input: Mbps and Mib, to then calculate the transfer time.
//BUG: back button close fragment
//0.01:  -Enable decimal
//      -Added fragment
//0.02:  -Added databinding
class MainActivity : AppCompatActivity() {

    var isFragmentDisplayed = false
    private val STATE_FRAGMENT = "state_of_fragment"

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save the state of the fragment (true=open, false=closed).
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed)
        super.onSaveInstanceState(savedInstanceState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) { //if bundle were saved successful
            isFragmentDisplayed =
                    savedInstanceState.getBoolean(STATE_FRAGMENT)
            if (isFragmentDisplayed) {
                // If the fragment is displayed, change button to "close".
                open_button.setText(R.string.close_button)
            }
        }
        // Set the click listener for the button.
        open_button.setOnClickListener {
            if (!isFragmentDisplayed) {
                displayFragment()
            } else {
                closeFragment()
            }
        }
    }
    //DESC: defocus when touch outside of editText
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
    private fun displayFragment() {
        var mainFragment = MainFragment.newInstance()

        //Get the FragmentManager and start a transaction.
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager
                .beginTransaction()

        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment_container,
                mainFragment).addToBackStack(null).commit()
        // Update the Button text.
                open_button.setText(R.string.close_button)
        // Set boolean flag to indicate fragment is open.
                isFragmentDisplayed = true
    }

    private fun closeFragment() {
        // Get the FragmentManager.
        val fragmentManager = supportFragmentManager
        // Check to see if the fragment is already showing.
        val mainFragment = fragmentManager
                .findFragmentById(R.id.fragment_container) as MainFragment
        if (mainFragment != null) {
            // Create and commit the transaction to remove the fragment.
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(mainFragment).commit()
        }
        // Update the Button text.
        open_button.setText(R.string.open_button)
        // Set boolean flag to indicate fragment is closed.
        isFragmentDisplayed = false
    }


}

