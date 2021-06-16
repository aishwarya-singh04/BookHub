package com.aishwarya.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class LogInActivity: AppCompatActivity(){
/*class LogInActivity: AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {                           //to use 'this' keyword for the implementation of OnClickListener
        Toast.makeText(this@LogInActivity, "We clicked on this button to see the toast",LENGTH_LONG).show()
    }*/

    lateinit var etMobileNumber: EditText                     //value will be initialised later on in onCreate
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber= "0123456789"
    //val validPassword= "thanos"


    val validPassword= arrayOf("steve","tony","bruce","thanos")                          //add different passwords for different users
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences= getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)

        val isLoggedIn= sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn)
        {
            val intent= Intent(this@LogInActivity, AvengersActivity:: class.java)
            startActivity(intent)
            finish()                                    //since onCreate fun need to be called everytime an activity runs
        }


        setContentView(R.layout.activity_login)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogIn)

        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)


        // btnLogin.setOnClickListener(this)                       //to add functionality to the button

        //Another lambda function to give functionality to the buttons or any text

        btnLogin.setOnClickListener {
            val MobileNumber = etMobileNumber.text.toString()
            val Password = etPassword.text.toString()
            var nameOfAvenger = "Avengers"
            val intent = Intent(this@LogInActivity, AvengersActivity::class.java)

            /*if((validMobileNumber==MobileNumber)&&(validPassword.contains(Password)))
            {
                //add a bridge between two activities (triggered whenever button is clicked)

                val intent= Intent(this@LogInActivity, AvengersActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(
                    this@LogInActivity,
                    "Incorrect Credentials.",
                    LENGTH_LONG
                ).show()
            }*/
            //adding functionality while using different password
            if (validMobileNumber == MobileNumber) {
                if (Password == validPassword[0]) {

                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
                    //intent.putExtra("Name", nameOfAvenger)                //commented b'coz we;re no longer using intent to provide title
                    startActivity(intent)
                } else if (Password == validPassword[1]) {

                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)
                    //intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (Password == validPassword[2]) {

                    nameOfAvenger = "The Hulk"
                    savePreferences(nameOfAvenger)
                    //intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (Password == validPassword[3]) {

                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
                    //intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LogInActivity, "Incorrect Credentials.", LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    //to allow the user to get back to the same screen, where he has left
    fun savePreferences(title: String)
    {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}
