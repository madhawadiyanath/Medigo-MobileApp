package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var homeTab: LinearLayout
    private lateinit var cartTab: LinearLayout
    private lateinit var profileTab: LinearLayout
    private lateinit var searchBar: EditText

    // Category Views
    private lateinit var vitaminsCategory: TextView
    private lateinit var prescriptionCategory: TextView
    private lateinit var personalCategory: TextView
    private lateinit var babyMotherCategory: TextView
    private lateinit var petCareCategory: TextView
    private lateinit var diabeticsCategory: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        homeTab = findViewById(R.id.home_tab)
        cartTab = findViewById(R.id.cart_tab)
        profileTab = findViewById(R.id.profile_tab)
        searchBar = findViewById(R.id.search_bar)

        // Categories
        vitaminsCategory = findViewById(R.id.vitamins_category)
        prescriptionCategory = findViewById(R.id.prescription_category)
        personalCategory = findViewById(R.id.personal_category)
        babyMotherCategory = findViewById(R.id.baby_mother_category)
        petCareCategory = findViewById(R.id.pet_care_category)
        diabeticsCategory = findViewById(R.id.diabetics_category)
    }

    private fun setupClickListeners() {
        homeTab.setOnClickListener {
            // Already on home, maybe refresh or scroll to top
        }

        cartTab.setOnClickListener {
            // Navigate to cart
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        profileTab.setOnClickListener {
            // Navigate to profile
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        // Example: handle search bar clicks
        searchBar.setOnClickListener {
            // Open search activity or expand search
        }

        // Category click listeners
        setupCategoryClickListeners()
    }

    private fun setupCategoryClickListeners() {
        vitaminsCategory.setOnClickListener {
            // Navigate to vitamins category
        }

        prescriptionCategory.setOnClickListener {
            // Navigate to prescription category
        }

        personalCategory.setOnClickListener {
            // Navigate to personal category
        }

        babyMotherCategory.setOnClickListener {
            // Navigate to baby & mother category
        }

        petCareCategory.setOnClickListener {
            // Navigate to pet care category
        }

        diabeticsCategory.setOnClickListener {
            // Navigate to diabetics category
        }
    }
}
