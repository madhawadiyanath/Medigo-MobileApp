package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        
        // Start fade-in animation for the logo
        val logoContainer = findViewById<LinearLayout>(R.id.logo_container)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logoContainer.startAnimation(fadeInAnimation)
        
        // Navigate to MainActivity after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
