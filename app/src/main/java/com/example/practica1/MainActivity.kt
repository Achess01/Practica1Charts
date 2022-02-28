package com.example.practica1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1.parserLexer.Errors.Errors
import com.example.practica1.parserLexer.Execute


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
            if(!Errors.getErrors().withErrors() && Execute.getExecute().readyToShow()){
                val intent = Intent(this, ShowCharts::class.java).apply {}
                startActivity(intent)
            }
            else{
                val toast = Toast.makeText(this, "No sé", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}
