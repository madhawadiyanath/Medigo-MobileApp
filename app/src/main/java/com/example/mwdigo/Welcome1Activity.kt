package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Welcome1Activity : AppCompatActivity() {
    
    private lateinit var nextButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome1)
        
        Log.d("Welcome1Activity", "Welcome1Activity created successfully")
        
        initializeViews()
        setupClickListeners()
        setupPageIndicators()
    }
    
    private fun initializeViews() {
        nextButton = findViewById(R.id.next_button)
    }
    
    private fun setupClickListeners() {
        // Next button click listener
        nextButton.setOnClickListener {
            Log.d("Welcome1Activity", "Next button clicked")
            
            // Navigate to the next welcome/onboarding screen
            try {
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
                // Don't finish this activity if you want users to be able to go back
                // finish()
            } catch (e: Exception) {
                Log.e("Welcome1Activity", "Error navigating to OnboardingActivity: ${e.message}")
                Toast.makeText(this, "Navigation error occurred", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun setupPageIndicators() {
        // Set the first dot as active (current page)
        // The dots are already set up in the XML layout
        Log.d("Welcome1Activity", "Page indicators set up - Page 1 of 3")
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("Welcome1Activity", "Welcome1Activity resumed")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d("Welcome1Activity", "Welcome1Activity paused")
    }
}
