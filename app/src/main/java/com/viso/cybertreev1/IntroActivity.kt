package com.viso.cybertreev1

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intro.*

// TODO (Step 1: Add the Intro Activity.)
// START
class IntroActivity : AppCompatActivity() {

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_intro)

        // This is used to hide the status bar and make the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

       /**val typeface: Typeface =
            Typeface.createFromAsset(assets, "carbon bl.ttf")
        tv_app_name_intro.typeface = typeface*/

        btn_sign_up_intro.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btn_sign_in_intro.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
// END