package com.example.uikit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eddie.uikit.dialog.SimpleDialog
import com.example.uikit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvShow.setOnClickListener {
            SimpleDialog(this).show()
        }
    }
}