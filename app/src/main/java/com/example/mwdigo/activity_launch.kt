// LaunchActivity.kt
package com.yourpackage.name

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import com.example.mwdigo.Onboarding1Activity
import com.example.mwdigo.R

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val logoContainer: LinearLayout = findViewById(R.id.logo_container)

        logoContainer.setOnClickListener {
            val intent = Intent(this, Onboarding1Activity::class.java)
            startActivity(intent)
        }
    }
}
