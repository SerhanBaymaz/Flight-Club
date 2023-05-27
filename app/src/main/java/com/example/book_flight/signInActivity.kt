package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.book_flight.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class signInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSignIn.setOnClickListener {
            userLogin()
        }
        binding.textViewClickSignup.setOnClickListener {
            finish() //it will go back to main activity.
        }


    }//createUser method ends

    fun userLogin() {
        val email = binding.textInputEmail.text.toString()
        val password = binding.textInputPassword.text.toString()


        if (email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth = FirebaseAuth.getInstance()

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Home_activity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }//userLogin method ends

}//class ends