package com.ashique.vocabblyapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class VocabblySpalshScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_vocabbly_spalsh_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        }, 1000)

    }
    private fun navigateToHome() {
        val intent = Intent(this, VocabblyHome::class.java)
        startActivity(intent)
        finish()
    }
}