package com.viso.cybertreev1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.viso.cybertreev1.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setUpActionBar()
    }
    private fun setUpActionBar() {
        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        }
        toolbar_sign_in_activity.setNavigationOnClickListener {onBackPressed()}
    }
}