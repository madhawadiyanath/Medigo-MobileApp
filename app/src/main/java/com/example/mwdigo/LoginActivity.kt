package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupLink: TextView
    private lateinit var forgotPasswordLink: TextView
    private lateinit var googleLoginButton: Button
    private lateinit var facebookLoginButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        emailEditText = findViewById(R.id.email_edittext)
        passwordEditText = findViewById(R.id.password_edittext)
        loginButton = findViewById(R.id.login_button)
        signupLink = findViewById(R.id.signup_link)
        forgotPasswordLink = findViewById(R.id.forgot_password)
        googleLoginButton = findViewById(R.id.google_login)
        facebookLoginButton = findViewById(R.id.facebook_login)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            performLogin()
        }
        
        signupLink.setOnClickListener {
            // Navigate to signup activity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        
        forgotPasswordLink.setOnClickListener {
            // Handle forgot password
            Toast.makeText(this, "Forgot password functionality", Toast.LENGTH_SHORT).show()
        }
        
        googleLoginButton.setOnClickListener {
            // Handle Google login
            Toast.makeText(this, "Google login functionality", Toast.LENGTH_SHORT).show()
        }
        
        facebookLoginButton.setOnClickListener {
            // Handle Facebook login
            Toast.makeText(this, "Facebook login functionality", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun performLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        
        if (email.isEmpty()) {
            emailEditText.error = "Please enter email or username"
            return
        }
        
        if (password.isEmpty()) {
            passwordEditText.error = "Please enter password"
            return
        }
        
        // Here you would typically validate credentials with your backend
        // For now, we'll just show a success message and navigate to dashboard
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
        
        // Navigate to dashboard
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}