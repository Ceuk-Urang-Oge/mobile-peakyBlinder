package com.marqumil.peakyblinder.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.ActivityRegisterBinding
import com.marqumil.peakyblinder.ui.auth.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener {
            register()
        }


    }


    private fun register() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        // check if email and password is not empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Please enter text in email/pw",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        Log.d("RegisterActivityy", "debug: $email $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@RegisterActivity) { task ->
                if (task.isSuccessful) {
                    // Registration successful, navigate to the next activity
                    Toast.makeText(
                        this@RegisterActivity,
                        "Registration successful.",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // Registration failed, display an error message
                    Log.d("RegisterActivity", "onCreate: ${task.exception}")
                    // If the user already exists display a message to the user
                    if (task.exception?.message.toString() == "The email address is already in use by another account.") {
                        Toast.makeText(
                            this@RegisterActivity,
                            "User already exists.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Registration failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
    }
}