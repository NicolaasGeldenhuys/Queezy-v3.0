package com.example.irobot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.irobot.databinding.ActivitySettingsBinding

class settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView41.setOnClickListener{
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NicolaasGeldenhuys/Queezy-v3.0"))
        startActivity(browserIntent)
        }

        binding.imageView35.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button5.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button6.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.hide()
    }
}