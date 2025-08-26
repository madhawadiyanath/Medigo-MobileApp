package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginScreenActivity : AppCompatActivity() {
    
    private lateinit var loginTitle: TextView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupLink: TextView
    private lateinit var forgotPasswordLink: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        
        Log.d("LoginScreenActivity", "LoginScreenActivity created successfully")
        Toast.makeText(this, "Login screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        loginTitle = findViewById(R.id.login_title)
        emailEditText = findViewById(R.id.email_edittext)
        passwordEditText = findViewById(R.id.password_edittext)
        loginButton = findViewById(R.id.login_button)
        signupLink = findViewById(R.id.signup_link)
        forgotPasswordLink = findViewById(R.id.forgot_password)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            performLogin()
        }
        
        signupLink.setOnClickListener {
            // Navigate to signup screen
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        
        forgotPasswordLink.setOnClickListener {
            Toast.makeText(this, "Forgot password functionality", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun performLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
        // Navigate to main activity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}



