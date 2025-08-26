package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var homeNav: ImageView
    private lateinit var cartNav: ImageView
    private lateinit var profileNav: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_cart)

        Log.d("CartActivity", "CartActivity created successfully")

        initializeViews()
        setupClickListeners()
        loadCartData()
    }

    private fun initializeViews() {
        backArrow = findViewById(R.id.back_arrow)
        homeNav = findViewById(R.id.home_icon)
        cartNav = findViewById(R.id.cart_icon)
        profileNav = findViewById(R.id.profile_icon)
    }

    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }

        homeNav.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        cartNav.setOnClickListener {
            Toast.makeText(this, "Already on cart page", Toast.LENGTH_SHORT).show()
        }

        profileNav.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadCartData() {
        Toast.makeText(this, "Cart loaded successfully", Toast.LENGTH_SHORT).show()
        Log.d("CartActivity", "Cart data loaded")
    }
}


