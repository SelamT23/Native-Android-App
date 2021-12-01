package com.example.finalProj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.* // IMPORTING THE SYNTHETIC CLASS SO THAT WE WONT USE FINDVIEWBYID()
import kotlinx.android.synthetic.main.activity_splash.* // IMPORTING THE SYNTHETIC CLASS SO THAT WE WONT USE FINDVIEWBYID()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        started()
    }

    /**
     *  This method basically initializes/starts the intent to sign up
     *  a user that installed this application. if that user already has
     *  an account, he/she can access it after the sign up button
     */
    private fun started(){

        letsStartBtn.setOnClickListener{
            startActivity(
                Intent(
                    this@MainActivity,
                    SignUp::class.java
                )
            )
        }
    }
}