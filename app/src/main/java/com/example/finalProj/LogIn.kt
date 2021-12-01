package com.example.finalProj

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*

class LogIn: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailLogIn.addTextChangedListener(checkerText)
        passwordLogIn.addTextChangedListener(checkerText)

        buttonClicked()
        signUpButton()
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

            nextPageInBtn.isEnabled = emailLogIn.text.toString().trim().isNotEmpty() && passwordLogIn.text.toString().trim().isNotEmpty()
        }
    }

    /**
     *  This function will redirect a user to the sign up page if he/she
     *  presses the "Have an account?" text. This method fires up an intent
     *  that would redirect the user.
     */
    private fun signUpButton(){

        signUpTxtBtn.setOnClickListener{
            startActivity(
                Intent(
                    this@LogIn,
                    SignUp::class.java
                )
            )
        }
    }

    /**
     *  This function is used to start an intent if the button is enabled and clicked.
     *  this function wont work if the button isn't activated.
     */
    private fun buttonClicked(){

        nextPageInBtn.setOnClickListener {

            /* This intent will pass the name to a caller method that was passed from a user */
            val intent = Intent(this@LogIn, Dashboard::class.java)
            intent.putExtra("userL", emailLogIn.text.toString());
            startActivity(intent)
        }
    }
}