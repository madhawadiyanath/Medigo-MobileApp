package com.example.mwdigo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentDetailsActivity : AppCompatActivity() {
    
    private lateinit var backArrow: ImageView
    private lateinit var mastercardRadio: RadioButton
    private lateinit var visaRadio: RadioButton
    private lateinit var cardNumberEditText: EditText
    private lateinit var monthEditText: EditText
    private lateinit var yearEditText: EditText
    private lateinit var cvnEditText: EditText
    private lateinit var totalAmountText: TextView
    private lateinit var cancelButton: Button
    private lateinit var payButton: Button
    // These views don't have IDs in the layout
    // private lateinit var paymentTitle: TextView
    // private lateinit var logoImage: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_details)
        
        Log.d("PaymentDetailsActivity", "PaymentDetailsActivity created successfully")
        Toast.makeText(this, "Payment details screen loaded", Toast.LENGTH_SHORT).show()
        
        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        backArrow = findViewById(R.id.backArrow)
        mastercardRadio = findViewById(R.id.mastercardRadio)
        visaRadio = findViewById(R.id.visaRadio)
        cardNumberEditText = findViewById(R.id.cardNumberEdit)
        monthEditText = findViewById(R.id.expMonthEdit)
        yearEditText = findViewById(R.id.expYearEdit)
        cvnEditText = findViewById(R.id.cvnEdit)
        totalAmountText = findViewById(R.id.totalAmountText)
        cancelButton = findViewById(R.id.cancelButton)
        payButton = findViewById(R.id.payButton)
        // These views don't have IDs in the layout
        // paymentTitle = findViewById(R.id.payment_title) - title is static TextView without ID
        // logoImage = findViewById(R.id.logo_image) - logo doesn't have ID
    }
    
    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }
        
        mastercardRadio.setOnClickListener {
            visaRadio.isChecked = false
            Toast.makeText(this, "MasterCard selected", Toast.LENGTH_SHORT).show()
        }
        
        visaRadio.setOnClickListener {
            mastercardRadio.isChecked = false
            Toast.makeText(this, "Visa selected", Toast.LENGTH_SHORT).show()
        }
        
        cancelButton.setOnClickListener {
            finish()
        }
        
        payButton.setOnClickListener {
            processPayment()
        }
    }
    
    private fun processPayment() {
        val cardNumber = cardNumberEditText.text.toString().trim()
        val month = monthEditText.text.toString().trim()
        val year = yearEditText.text.toString().trim()
        val cvn = cvnEditText.text.toString().trim()
        
        if (!mastercardRadio.isChecked && !visaRadio.isChecked) {
            Toast.makeText(this, "Please select a card type", Toast.LENGTH_SHORT).show()
            return
        }
        
        if (cardNumber.isEmpty() || month.isEmpty() || year.isEmpty() || cvn.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        
        Toast.makeText(this, "Payment processed successfully!", Toast.LENGTH_SHORT).show()
        
        // Navigate to order success activity
        val intent = Intent(this, OrderSuccessActivity::class.java)
        startActivity(intent)
        finish()
    }
}



