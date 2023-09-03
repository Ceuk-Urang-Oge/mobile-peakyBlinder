package com.marqumil.peakyblinder.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.marqumil.peakyblinder.MainActivity
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.ActivitySplashScreenBinding
import com.marqumil.peakyblinder.ui.auth.login.LoginActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val time = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            sessionChecker()
        }, time)
    }

    private fun sessionChecker() {
        // sesion checeker using firebase and validation
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null){
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finishAffinity()
        } else {
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
            finishAffinity()
        }
    }

//    override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        updateUI(currentUser)
//    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}