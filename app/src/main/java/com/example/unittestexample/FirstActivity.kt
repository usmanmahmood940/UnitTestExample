package com.example.unittestexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unittestexample.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding:ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this@FirstActivity, SecondActivity::class.java)
            intent.putExtra("title", binding.etTitle.text.toString())
            startActivity(intent)
        }

    }
}