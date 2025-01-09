package com.ashique.vocabblyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ashique.vocabblyapp.databinding.ActivityVocabblyHomeBinding

class VocabblyHome : AppCompatActivity() {

    private lateinit var binding : ActivityVocabblyHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVocabblyHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.greCard.setOnClickListener() {
            val intent = android.content.Intent(this, GreActivity::class.java)
            startActivity(intent)
        }
    }
}