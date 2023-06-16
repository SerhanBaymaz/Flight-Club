package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.book_flight.databinding.ActivityPassengerInputinfoBinding

class PassengerInputinfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityPassengerInputinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivityPassengerInputinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }//onCreate


}//class