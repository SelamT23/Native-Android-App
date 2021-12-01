package com.example.finalProj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_underconstruction.*

class UnderConstruction: AppCompatActivity() {
    private var uName: String = "" // Variable used to store user name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_underconstruction)

        backButtonClicked()
    }

    /**
     *  This function will redirect a user to the dashboard page if he/she
     *  presses the "back to home" button. This method fires
     *  up an intent that would redirect the user to the dashboard.
     */
    private fun backButtonClicked(){

        backBtn.setOnClickListener{

            setName()
            val intent = Intent(this@UnderConstruction, Dashboard::class.java)
            intent.putExtra("userU", uName);
            startActivity(intent)
        }
    }

    /**
     *  This function will set the "uName" variable to the one that
     *  has been set by the user which was sent from the dashboard
     *  for future use (if the user goes back, he/she will get their
     *  name back)
     */
    private fun setName(){

        uName = intent.getStringExtra("userU").toString()
    }
}