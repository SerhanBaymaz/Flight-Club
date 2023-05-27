package com.example.book_flight

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        binding.textViewForgotPassword.setOnClickListener {
            forgotPassword()
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

    fun compareEmail(email: EditText) {
        if (email.text.toString().isEmpty()) {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            Toast.makeText(this, "Please enter an valid email address", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.sendPasswordResetEmail(email.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Recovery E-mail sended.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error: ${task.exception.toString()} ", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    fun forgotPassword() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_forgot_password, null)
        val userEmail = view.findViewById<EditText>(R.id.textInput_email_dialog)
        builder.setView(view)
        val dialog = builder.create()
        view.findViewById<Button>(R.id.btn_Reset).setOnClickListener {
            compareEmail(userEmail)
            dialog.dismiss()
        }
        view.findViewById<Button>(R.id.btn_Cancel).setOnClickListener {
            dialog.dismiss()
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.show()
    }


}//class ends