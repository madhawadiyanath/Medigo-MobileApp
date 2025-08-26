package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SeeAllActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var logoImage: ImageView
    private lateinit var searchBar: EditText
    // Bottom navigation views don't exist in this layout
    // private lateinit var homeNav: ImageView
    // private lateinit var cartNav: ImageView
    // private lateinit var profileNav: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.see_all)
        
        Log.d("SeeAllActivity", "SeeAllActivity created successfully")
        Toast.makeText(this, "See all products screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.back_arrow)
        logoImage = findViewById(R.id.logo_image)
        searchBar = findViewById(R.id.search_bar)
        // Bottom navigation views don't exist in this layout
        // homeNav = findViewById(R.id.home_button)
        // cartNav = findViewById(R.id.cart_button)
        // profileNav = findViewById(R.id.profile_button)
    }
    
    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }
        
        searchBar.setOnClickListener {
            Toast.makeText(this, "Search functionality", Toast.LENGTH_SHORT).show()
        }
        
        // Bottom navigation click listeners - commented out as these views don't exist in layout
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



