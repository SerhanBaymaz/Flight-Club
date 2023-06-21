package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.book_flight.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.textViewClickSignin.setOnClickListener {
            val intent = Intent(this, signInActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSignup.setOnClickListener {
            createUser()
        }



    }//onCreate method ends

    fun createUser() {
        val email = binding.textInputEmail.text.toString()
        val password = binding.textInputPassword.text.toString()
        val passAgain = binding.textInputPassword2.text.toString()


        if (email.isEmpty()){
            binding.textInputEmail.error = "E-mail cannot be empty"
        }

        if (password.isEmpty()){
            binding.textInputPassword.error = "Password cannot be empty"
        }

        if (passAgain.isEmpty()){
            binding.textInputPassword2.error = "Password cannot be empty"
        }


        if (email.isNotEmpty() && password.isNotEmpty() && passAgain.isNotEmpty()) {
            if (password == passAgain) {
                firebaseAuth = FirebaseAuth.getInstance()

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this, "You sign up Succesfuly :)", Toast.LENGTH_SHORT
                            ).show()

                            val intent = Intent(this, signInActivity::class.java)
                            startActivity(intent)


                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
            }


        } else {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        }


    }//createUser method ends


}//class ends