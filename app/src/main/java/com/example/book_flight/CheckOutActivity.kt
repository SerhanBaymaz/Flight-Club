package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.book_flight.databinding.ActivityCheckOutBinding
import com.example.book_flight.databinding.ActivityMainBinding

class CheckOutActivity : AppCompatActivity() {

    lateinit var binding: ActivityCheckOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityCheckOutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonPay.setOnClickListener {
            val intent = Intent(this, TicketSummaryActivity::class.java)
            startActivity(intent)
        }

    }//onCreate method



}