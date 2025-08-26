package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var searchEditText: EditText
    private lateinit var filterIcon: ImageView
    private lateinit var notificationIcon: ImageView
    private lateinit var seeAllText: TextView
    private lateinit var homeNav: LinearLayout
    private lateinit var cartNav: LinearLayout
    private lateinit var profileNav: LinearLayout
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        searchEditText = findViewById(R.id.search_edittext)
        filterIcon = findViewById(R.id.filter_icon)
        notificationIcon = findViewById(R.id.notification_icon)
        seeAllText = findViewById(R.id.see_all_text)
        homeNav = findViewById(R.id.home_nav)
        cartNav = findViewById(R.id.cart_nav)
        profileNav = findViewById(R.id.profile_nav)
    }
    
    private fun setupClickListeners() {
        filterIcon.setOnClickListener {
            // Handle filter functionality
        }
        
        notificationIcon.setOnClickListener {
            // Handle notifications
        }
        
        seeAllText.setOnClickListener {
            // Navigate to see all products
            val intent = Intent(this, MainActivity::class.java) // Replace with actual SeeAllActivity
            startActivity(intent)
        }
        
        homeNav.setOnClickListener {
            // Already on home, just refresh or highlight
        }
        
        cartNav.setOnClickListener {
            // Navigate to cart
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
        
        profileNav.setOnClickListener {
            // Navigate to profile
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}