package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var orderTitle: TextView
    private lateinit var logoImage: ImageView
    private lateinit var homeNav: ImageView
    private lateinit var cartNav: ImageView
    private lateinit var profileNav: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_order)
        
        Log.d("OrderActivity", "OrderActivity created successfully")
        
        initializeViews()
        setupClickListeners()
        loadOrderData()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.back_arrow)
        orderTitle = findViewById(R.id.order_title)
        logoImage = findViewById(R.id.logo_image)
        homeNav = findViewById(R.id.home_button)
        cartNav = findViewById(R.id.cart_button)
        profileNav = findViewById(R.id.profile_button)
    }
    
    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }
        
        homeNav.setOnClickListener {
            // Navigate to home
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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
    
    private fun loadOrderData() {
        // Load order data from SharedPreferences or database
        // For now, we'll just show a message
        Toast.makeText(this, "Order history loaded successfully", Toast.LENGTH_SHORT).show()
        Log.d("OrderActivity", "Order data loaded")
    }
}



