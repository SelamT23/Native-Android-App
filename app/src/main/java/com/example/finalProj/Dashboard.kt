package com.example.finalProj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class Dashboard: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setName()
        firstButtonClicked()
        secondButtonClicked()
        thirdButtonClicked()
    }

    /**
     *  This function will set the greeting username to the one set
     *  by the user while he signs up or logs in. The name is passed
     *  from the sign up or log in intent.
     */
    private fun setName(){

        if(!intent.getStringExtra("user").isNullOrBlank()){

            usrName.text = intent.getStringExtra("user")
        }
        else if(!intent.getStringExtra("userL").isNullOrBlank()){

            usrName.text = intent.getStringExtra("userL")
        }
        else if(!intent.getStringExtra("userU").isNullOrBlank()){

            usrName.text = intent.getStringExtra("userU")
        }
        else{

            usrName.text = "Random User"
        }
    }

    /**
     *  This function will redirect a user to the under-construction
     *  page if he/she presses the "Reading" button. This method fires
     *  up an intent that would redirect the user to the under-construction page.
     */
    private fun firstButtonClicked(){

        firstButton.setOnClickListener{

            /* This intent will pass the name to a caller method that was passed from a user */
            val intent = Intent(this@Dashboard, UnderConstruction::class.java)
            intent.putExtra("userU", usrName.text.toString());
            startActivity(intent)
        }
    }

    /**
     *  This function will redirect a user to the under-construction
     *  page if he/she presses the "Speaking" text. This method fires
     *  up an intent that would redirect the user to the under-construction  page.
     */
    private fun secondButtonClicked(){

        secondButton.setOnClickListener{

            /* This intent will pass the name to a caller method that was passed from a user */
            val intent = Intent(this@Dashboard, UnderConstruction::class.java)
            intent.putExtra("userU", usrName.text.toString());
            startActivity(intent)
        }
    }

    /**
     *  This function will redirect a user to the under-construction
     *  page if he/she presses the "Writing" text. This method fires
     *  up an intent that would redirect the user to the under-construction page.
     */
    private fun thirdButtonClicked(){

        thirdButton.setOnClickListener{

            /* This intent will pass the name to a caller method that was passed from a user */
            val intent = Intent(this@Dashboard, UnderConstruction::class.java)
            intent.putExtra("userU", usrName.text.toString());
            startActivity(intent)
        }
    }


}