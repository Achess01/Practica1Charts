package com.example.practica1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonText = findViewById<Button>(R.id.button4)
        buttonText.setOnClickListener {
            val intent = Intent(this, TextActivity::class.java).apply {}
            startActivity(intent)
        }

        val buttonCharts = findViewById<Button>(R.id.button3)
        buttonCharts.setOnClickListener {
            val intent = Intent(this, TextActivity::class.java).apply {}
            startActivity(intent)
        }

    }
}
