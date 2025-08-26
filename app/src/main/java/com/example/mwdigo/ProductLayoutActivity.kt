package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductLayoutActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var favoriteIcon: ImageView
    private lateinit var productImage: ImageView
    private lateinit var priceText: TextView
    private lateinit var ratingText: TextView
    private lateinit var productTitle: TextView
    private lateinit var addToCartButton: Button
    // These views don't exist in the layout or don't have IDs
    // private lateinit var logoImage: ImageView
    // private lateinit var productNameLabel: TextView
    // private lateinit var overviewLabel: TextView
    // private lateinit var homeNav: ImageView
    // private lateinit var cartNav: ImageView
    // private lateinit var profileNav: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        
        Log.d("ProductLayoutActivity", "ProductLayoutActivity created successfully")
        Toast.makeText(this, "Product details screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.backArrow)
        favoriteIcon = findViewById(R.id.favoriteIcon)
        productImage = findViewById(R.id.productImage)
        priceText = findViewById(R.id.priceText)
        ratingText = findViewById(R.id.ratingText)
        productTitle = findViewById(R.id.productTitle)
        addToCartButton = findViewById(R.id.addToCartButton)
        // These views don't exist in the layout or don't have IDs
        // logoImage = findViewById(R.id.logo_image)
        // productNameLabel = findViewById(R.id.product_name_label)
        // overviewLabel = findViewById(R.id.overview_label)
        // homeNav = findViewById(R.id.home_button)
        // cartNav = findViewById(R.id.cart_button)
        // profileNav = findViewById(R.id.profile_button)
    }
    
    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }
        
        favoriteIcon.setOnClickListener {
            Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show()
        }
        
        addToCartButton.setOnClickListener {
            Toast.makeText(this, "Product added to cart!", Toast.LENGTH_SHORT).show()
            // Navigate to cart
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
        
        // Bottom navigation click listeners - commented out as these views don't have IDs in layout
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
        //     val intent = Intent(this, UserProfileActivity::class.java)
        //     startActivity(intent)
        // }
    }
}



