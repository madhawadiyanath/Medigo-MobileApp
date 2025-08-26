package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {
    
    private lateinit var nextButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        
        Log.d("OnboardingActivity", "OnboardingActivity created successfully")
        Toast.makeText(this, "Onboarding screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        nextButton = findViewById(R.id.next_button)
    }
    
    private fun setupClickListeners() {
        nextButton.setOnClickListener {
            Log.d("OnboardingActivity", "Next button clicked")
            // Navigate to next onboarding screen
            try {
                val intent = Intent(this, Onboarding1Activity::class.java)
                startActivity(intent)
                // Don't finish this activity if you want users to be able to go back
                // finish()
            } catch (e: Exception) {
                Log.e("OnboardingActivity", "Error navigating to Onboarding1Activity: ${e.message}")
                Toast.makeText(this, "Navigation error occurred", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("OnboardingActivity", "OnboardingActivity resumed")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d("OnboardingActivity", "OnboardingActivity paused")
    }
}



