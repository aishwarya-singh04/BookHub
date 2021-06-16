package com.aishwarya.myapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {
    var titleName: String? ="Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {                    //auto-rotate

        super.onCreate(savedInstanceState)

        sharedPreferences= getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)                         //extracts the method from layout directory & sets in the main_activity.ky file
        //println("onCreate called")

        /*if(intent!= null)                                                 //commented b'coz intent is not used for extracting title, now sharedPreferences is being used.
        {
            titleName= intent.getStringExtra("Name")
        }*/
        title= titleName



    }

    /*override fun onStart() {
        super.onStart()
        println("onStart called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause called")
    }

    override fun onStop() {
        super.onStop()
        println("onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy called")
    }*/


}
