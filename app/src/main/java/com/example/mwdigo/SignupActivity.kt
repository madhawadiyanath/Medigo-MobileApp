package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var signupButton: Button
    private lateinit var loginLink: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        
        Log.d("SignupActivity", "SignupActivity created successfully")
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        usernameEditText = findViewById(R.id.username_edittext)
        emailEditText = findViewById(R.id.email_edittext)
        passwordEditText = findViewById(R.id.password_edittext)
        confirmPasswordEditText = findViewById(R.id.confirm_password_edittext)
        signupButton = findViewById(R.id.signup_button)
        loginLink = findViewById(R.id.login_link)
    }
    
    private fun setupClickListeners() {
        signupButton.setOnClickListener {
            performSignup()
        }
        
        loginLink.setOnClickListener {
            // Navigate to login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    
    private fun performSignup() {
        val username = usernameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val confirmPassword = confirmPasswordEditText.text.toString().trim()
        
        if (username.isEmpty()) {
            usernameEditText.error = "Please enter username"
            return
        }
        
        if (email.isEmpty()) {
            emailEditText.error = "Please enter email"
            return
        }
        
        if (password.isEmpty()) {
            passwordEditText.error = "Please enter password"
            return
        }
        
        if (confirmPassword.isEmpty()) {
            confirmPasswordEditText.error = "Please confirm password"
            return
        }
        
        if (password != confirmPassword) {
            confirmPasswordEditText.error = "Passwords do not match"
            return
        }
        
        // Here you would typically register the user with your backend
        Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
        Log.d("SignupActivity", "User signed up: $username, $email")
        
        // Navigate to main activity or dashboard
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}



