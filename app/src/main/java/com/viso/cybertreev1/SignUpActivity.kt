package com.viso.cybertreev1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setUpActionBar()
    }
     private fun setUpActionBar(){
       setSupportActionBar(toolbar_sign_up_activity)

         val actionBar = supportActionBar
         if (actionBar != null){
             actionBar.setDisplayHomeAsUpEnabled(true)
             actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
         }
         toolbar_sign_up_activity.setNavigationOnClickListener {onBackPressed()}
    }
}