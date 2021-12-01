package com.example.finalProj

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.* // IMPORTING THE SYNTHETIC CLASS SO THAT WE WONT USE FINDVIEWBYID()

/**
 *  This class is used to initialize as well as create the
 *  sign up activity and do some minor tasks.
 */
class SignUp: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameSignUp.addTextChangedListener(checkerText)
        emailSignUp.addTextChangedListener(checkerText)
        passwordSignUp.addTextChangedListener(checkerText)

        buttonClicked()
        logInClicked()
    }

    /**
     *  A TextWatcher Function used to check if the text boxes are empty or not.
     *  If any of the text boxes that use this method, it will make sure that the
     *  button wont be enabled if they are empty.
     */
    private val checkerText = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            nextPageUpBtn.isEnabled = nameSignUp.text.toString().trim().isNotEmpty() && emailSignUp.text.toString().trim().isNotEmpty() && passwordSignUp.text.toString().trim().isNotEmpty()
        }

    }

    /**
     *  This function is used to start an intent if the button is enabled and clicked.
     *  this function wont work if the button isn't activated.
     */
    private fun buttonClicked(){

        nextPageUpBtn.setOnClickListener {

            /* This intent will pass the name to a caller method that was passed from a user */
            val intent = Intent(this@SignUp, Dashboard::class.java)
            intent.putExtra("user", nameSignUp.text.toString());
            startActivity(intent)
        }
    }

    /**
     *  This function will redirect a user to the log up page if he/she
     *  presses the "Already have an account?" text. This method fires
     *  up an intent that would redirect the user to the log in page.
     */
    private fun logInClicked(){

        logInTxtBtn.setOnClickListener{

            startActivity(
                Intent(
                    this@SignUp,
                    LogIn::class.java
                )
            )
        }
    }
}