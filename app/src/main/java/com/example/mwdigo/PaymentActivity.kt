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

class PaymentActivity : AppCompatActivity() {

    // Declare all views
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_details)

        Log.d("PaymentActivity", "PaymentActivity created successfully")

        // Initialize and set up the views
        initializeViews()
        setupClickListeners()
        loadPaymentData()
    }

    private fun initializeViews() {
        backArrow = findViewById(R.id.back_arrow)
        mastercardRadio = findViewById(R.id.mastercard_radio)
        visaRadio = findViewById(R.id.visa_radio)
        cardNumberEditText = findViewById(R.id.card_number_edittext)
        monthEditText = findViewById(R.id.month_edittext)
        yearEditText = findViewById(R.id.year_edittext)
        cvnEditText = findViewById(R.id.cvn_edittext)
        totalAmountText = findViewById(R.id.total_amount_text)
        cancelButton = findViewById(R.id.cancel_button)
        payButton = findViewById(R.id.pay_button)
    }

    private fun setupClickListeners() {
        backArrow.setOnClickListener {
            finish()
        }

        // Use a listener to handle the radio button state
        mastercardRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                visaRadio.isChecked = false
                Toast.makeText(this, "MasterCard selected", Toast.LENGTH_SHORT).show()
            }
        }

        visaRadio.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mastercardRadio.isChecked = false
                Toast.makeText(this, "Visa selected", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }

        payButton.setOnClickListener {
            processPayment()
        }
    }

    private fun loadPaymentData() {
        // Load data from intent. For demonstration, we'll use a placeholder.
        val amount = intent.getStringExtra("TOTAL_AMOUNT") ?: "LKR 7800.00"
        totalAmountText.text = amount

        Toast.makeText(this, "Payment form loaded successfully", Toast.LENGTH_SHORT).show()
        Log.d("PaymentActivity", "Payment data loaded: $amount")
    }

    private fun processPayment() {
        val cardNumber = cardNumberEditText.text.toString().trim()
        val month = monthEditText.text.toString().trim()
        val year = yearEditText.text.toString().trim()
        val cvn = cvnEditText.text.toString().trim()

        // Validation checks
        if (!mastercardRadio.isChecked && !visaRadio.isChecked) {
            Toast.makeText(this, "Please select a card type", Toast.LENGTH_SHORT).show()
            return
        }

        if (cardNumber.length != 16) {
            cardNumberEditText.error = "Card number must be 16 digits"
            return
        }

        val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) % 100
        val monthInt = month.toIntOrNull()
        val yearInt = year.toIntOrNull()

        if (monthInt == null || monthInt !in 1..12) {
            monthEditText.error = "Invalid month (MM)"
            return
        }

        if (yearInt == null || yearInt < currentYear) {
            yearEditText.error = "Invalid year (YY)"
            return
        }

        if (cvn.length != 3 && cvn.length != 4) {
            cvnEditText.error = "CVN must be 3 or 4 digits"
            return
        }

        // Process the payment (simulated)
        Toast.makeText(this, "Payment processed successfully!", Toast.LENGTH_SHORT).show()
        Log.d("PaymentActivity", "Payment processed for card ending in ...${cardNumber.takeLast(4)}")

        // Navigate to the next activity
        val intent = Intent(this, MainActivity::class.java) // Replace with your target success activity
        startActivity(intent)
        finish()
    }
}