package com.viso.cybertreev1.activities

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.Toast
import com.viso.cybertreev1.R
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : BaseActivity() {

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_sign_up)

        setupActionBar()

        // Click event for sign-up button.
        btn_sign_up.setOnClickListener{
            registerUser()
        }
    }

    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        }

        toolbar_sign_up_activity.setNavigationOnClickListener { onBackPressed() }
    }

    // TODO (Step 9: A function to register a new user to the app.)
    // START
    /**
     * A function to register a user to our app using the Firebase.
     * For more details visit: https://firebase.google.com/docs/auth/android/custom-auth
     */
    private fun registerUser(){
        val name: String = et_name.text.toString().trim { it <= ' ' }
        val email: String = et_email.text.toString().trim { it <= ' ' }
        val password: String = et_password.text.toString().trim { it <= ' ' }
        val confirmPassword: String = et_password_confirm.text.toString().trim { it <= ' ' }

        if (password == confirmPassword){
            if (validateForm(name, email, password, confirmPassword)) {

                Toast.makeText(
                    this@SignUpActivity,
                    "Now we can register a new user.",
                    Toast.LENGTH_SHORT
                ).show()
            }
       }else{
            showErrorSnackBar("Passwords do not match, please enter the password.")
          /*  Toast.makeText(
                this@SignUpActivity,
                "Passwords do not match, please enter the password.",
                Toast.LENGTH_SHORT
            ).show()*/
        }
    }
    // END


    /**
     * A function to validate the entries of a new user.
     */
    private fun validateForm(name: String, email: String, password: String, confirmPassword: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            TextUtils.isEmpty(confirmPassword) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            else -> {
                true
            }
        }
    }
}