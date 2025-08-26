package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Onboarding1Activity : AppCompatActivity() {
    
    private lateinit var getStartedButton: Button
    private lateinit var skipButton: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding1)
        
        Log.d("Onboarding1Activity", "Onboarding1Activity created successfully")
        Toast.makeText(this, "Onboarding screen 2 loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        getStartedButton = findViewById(R.id.get_started_button)
        skipButton = findViewById(R.id.skip_button)
    }
    
    private fun setupClickListeners() {
        getStartedButton.setOnClickListener {
            Log.d("Onboarding1Activity", "Get Started button clicked")
            // Navigate to login screen
            try {
                val intent = Intent(this, LoginScreenActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Log.e("Onboarding1Activity", "Error navigating to LoginScreenActivity: ${e.message}")
                Toast.makeText(this, "Navigation error occurred", Toast.LENGTH_SHORT).show()
            }
        }
        
        skipButton.setOnClickListener {
            Log.d("Onboarding1Activity", "Skip button clicked")
            // Skip onboarding and go to login
            try {
                val intent = Intent(this, LoginScreenActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Log.e("Onboarding1Activity", "Error navigating to LoginScreenActivity: ${e.message}")
                Toast.makeText(this, "Navigation error occurred", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("Onboarding1Activity", "Onboarding1Activity resumed")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d("Onboarding1Activity", "Onboarding1Activity paused")
    }
}



