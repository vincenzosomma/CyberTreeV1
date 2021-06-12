package com.viso.cybertreev1.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.viso.cybertreev1.R
import kotlinx.android.synthetic.main.dialog_progress.*


// TODO (Step 4: Here we have created a BaseActivity Class in which we have added the progress dialog and SnackBar. Now all the activity will extend the BaseActivity instead of AppCompatActivity.)
open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressOnce = false
    /**
     * This is a progress dialog instance which we will initialize later on.
     */
    private lateinit var mProgressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
    }

    /**
     * This function is used to show the progress dialog with the title and message to user.
     */
    fun showProgressDialog(text: String) {
        mProgressDialog = Dialog(this)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.tv_progress_text.text = text

        //Start the dialog and display it on screen.
        mProgressDialog.show()
    }
    /**
     * This function is used to dismiss the progress dialog if it is visible to user.
     */
    fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }
    //Get the user ID
    fun getCurrentUserId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
    fun doubleBacktoExit(){
        if (doubleBackToExitPressOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressOnce = true
        Toast.makeText(this,
        resources.getString(R.string.please_click_back_again_to_exit), Toast.LENGTH_SHORT
        ).show()

        Handler().postDelayed({doubleBackToExitPressOnce = false}, 2500)
    }

    fun showErrorSnackBar(message: String){
        val snackBar = Snackbar.make(findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this,
            R.color.snackbar_error_color))
        snackBar.show()
    }
}