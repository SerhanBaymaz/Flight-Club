package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.book_flight.databinding.ActivitySignInBinding

class signInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignIn.setOnClickListener{
            val intent = Intent(this,Home_activity::class.java)
            startActivity(intent)
        }

        binding.textViewClickSignup.setOnClickListener{
            finish() //it will go back to main activity.
        }



    }


}