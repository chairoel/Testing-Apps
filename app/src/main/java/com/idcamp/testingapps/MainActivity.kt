package com.idcamp.testingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idcamp.testingapps.databinding.ActivityMainBinding
import com.idcamp.testingapps.unittest.junit.MyUnitTestActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMyUnitTest.setOnClickListener {
            startActivity(Intent(this@MainActivity, MyUnitTestActivity::class.java))
        }
    }
}