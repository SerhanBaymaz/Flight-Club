package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.book_flight.databinding.ActivityTicketSummaryBinding

class TicketSummaryActivity : AppCompatActivity() {

    lateinit var binding: ActivityTicketSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }


}