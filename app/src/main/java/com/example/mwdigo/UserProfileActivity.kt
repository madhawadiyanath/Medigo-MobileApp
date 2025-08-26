package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var logoutButton: Button
    private lateinit var profileImage: ImageView
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var contactEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var editButton: Button
    private lateinit var saveButton: Button
    private lateinit var viewOrdersButton: Button
    // Bottom navigation views - commented out until IDs are added to layout
    // private lateinit var homeNav: ImageView
    // private lateinit var cartNav: ImageView
    // private lateinit var profileNav: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        
        Log.d("UserProfileActivity", "UserProfileActivity created successfully")
        
        initializeViews()
        setupClickListeners()
        loadUserData()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.backArrow)
        logoutButton = findViewById(R.id.logoutButton)
        profileImage = findViewById(R.id.profileImage)
        usernameEditText = findViewById(R.id.userNameEdit)
        emailEditText = findViewById(R.id.emailEdit)
        contactEditText = findViewById(R.id.contactEdit)
        addressEditText = findViewById(R.id.addressEdit)
        editButton = findViewById(R.id.editButton)
        saveButton = findViewById(R.id.saveButton)
        viewOrdersButton = findViewById(R.id.viewOrdersButton)
        // Bottom navigation - these don't have IDs in the layout, so we'll comment them out for now
        // homeNav = findViewById(R.id.home_button)
        // cartNav = findViewById(R.id.cart_button)
        // profileNav = findViewById(R.id.profile_button)
    }
    
    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }
        
        logoutButton.setOnClickListener {
            performLogout()
        }
        
        editButton.setOnClickListener {
            enableEditing()
        }
        
        saveButton.setOnClickListener {
            saveUserData()
        }
        
        viewOrdersButton.setOnClickListener {
            // Navigate to orders activity
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
        
        // Bottom navigation click listeners - commented out until IDs are added to layout
        // homeNav.setOnClickListener {
        //     val intent = Intent(this, MainActivity::class.java)
        //     startActivity(intent)
        //     finish()
        // }
        // 
        // cartNav.setOnClickListener {
        //     val intent = Intent(this, CartActivity::class.java)
        //     startActivity(intent)
        // }
        // 
        // profileNav.setOnClickListener {
        //     Toast.makeText(this, "Already on profile page", Toast.LENGTH_SHORT).show()
        // }
    }
    
    private fun loadUserData() {
        // Load user data from SharedPreferences or database
        // For now, we'll set some sample data
        usernameEditText.setText("John Doe")
        emailEditText.setText("john.doe@example.com")
        contactEditText.setText("075-1234567")
        addressEditText.setText("123 Main Street, Colombo, Sri Lanka")
        
        // Disable editing initially
        disableEditing()
    }
    
    private fun enableEditing() {
        usernameEditText.isEnabled = true
        emailEditText.isEnabled = true
        contactEditText.isEnabled = true
        addressEditText.isEnabled = true
        
        editButton.visibility = android.view.View.GONE
        saveButton.visibility = android.view.View.VISIBLE
        
        Toast.makeText(this, "Edit mode enabled", Toast.LENGTH_SHORT).show()
    }
    
    private fun disableEditing() {
        usernameEditText.isEnabled = false
        emailEditText.isEnabled = false
        contactEditText.isEnabled = false
        addressEditText.isEnabled = false
        
        editButton.visibility = android.view.View.VISIBLE
        saveButton.visibility = android.view.View.GONE
    }
    
    private fun saveUserData() {
        val username = usernameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val contact = contactEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()
        
        if (username.isEmpty() || email.isEmpty() || contact.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Here you would typically save to SharedPreferences or database
        Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
        Log.d("UserProfileActivity", "User data saved: $username, $email")
        
        disableEditing()
    }
    
    private fun performLogout() {
        // Clear user session data
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        Log.d("UserProfileActivity", "User logged out")
        
        // Navigate to login activity
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}



