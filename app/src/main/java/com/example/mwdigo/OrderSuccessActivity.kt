package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderSuccessActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var successIcon: ImageView
    private lateinit var orderMessage: TextView
    private lateinit var deliveryIllustration: ImageView
    private lateinit var footerMessage: TextView
    private lateinit var homeNav: ImageView
    private lateinit var cartNav: ImageView
    private lateinit var profileNav: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_success)
        
        Log.d("OrderSuccessActivity", "OrderSuccessActivity created successfully")
        Toast.makeText(this, "Order success screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.back_arrow)
        successIcon = findViewById(R.id.success_icon)
        orderMessage = findViewById(R.id.order_message)
        deliveryIllustration = findViewById(R.id.delivery_illustration)
        footerMessage = findViewById(R.id.footer_message)
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
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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
}



