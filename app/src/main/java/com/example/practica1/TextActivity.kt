package com.example.practica1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.practica1.parserLexer.Compile
import com.example.practica1.parserLexer.Errors.Errors

class TextActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val buttonCompile = findViewById<Button>(R.id.button)
        val textContainer = findViewById<EditText>(R.id.editTextTextMultiLine);
        buttonCompile.setOnClickListener {
            var text = textContainer.text.toString();
            if(text != ""){
                Compile.compile(text)
                var text = "Compilado "
                if(Errors.getErrors().withErrors()) text += "con errores"
                else text += "sin errores"
                val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
