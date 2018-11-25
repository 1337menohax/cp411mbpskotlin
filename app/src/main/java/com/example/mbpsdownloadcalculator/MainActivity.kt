package com.example.mbpsdownloadcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


//Last Update: 23NOV2018
//DESC: Takes user input: Mbps and Mib, to then calculate the transfer time.
//0.1:  -Enable decimal
//      -Added fragment
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
    fun displayFragment() {
        var mainFragment = MainFragment.newInstance()

        // TODO: Get the FragmentManager and start a transaction.
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager
                .beginTransaction()

        // TODO: Add the SimpleFragment.
        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment_container,
                mainFragment).addToBackStack(null).commit()
        // Update the Button text.
                open_button.setText(R.string.close_button)
        // Set boolean flag to indicate fragment is open.
                isFragmentDisplayed = true
    }

    fun closeFragment() {
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

