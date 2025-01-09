package com.ashique.vocabblyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ashique.vocabblyapp.databinding.ActivityGreBinding

class GreActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val greFragment =  WordQuizFragment.newInstance()
        fragmentTransaction.replace(binding.greFragmentContainer.id, greFragment)
        fragmentTransaction.commit()
    }
}