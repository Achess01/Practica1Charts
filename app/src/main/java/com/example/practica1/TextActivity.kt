package com.example.practica1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.practica1.parserLexer.Compile
import com.example.practica1.parserLexer.Errors.Errors
import com.example.practica1.parserLexer.Execute

class TextActivity : AppCompatActivity() {

    companion object {
        private var textCode: String = ""
        fun getTextCode(): String{
            return textCode
        }

        fun setTextCode(newText: String){
            textCode = newText
        }

        fun compare(compareText: String): Boolean{
            return textCode == compareText
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        val textContainer = findViewById<EditText>(R.id.editTextTextMultiLine);
        textContainer.setText(TextActivity.textCode, TextView.BufferType.EDITABLE)
        val buttonCompile = findViewById<Button>(R.id.button)
        val buttonDel = findViewById<Button>(R.id.buttonDel);

        buttonDel.setOnClickListener {
            TextActivity.setTextCode("")
            textContainer.setText(TextActivity.textCode, TextView.BufferType.EDITABLE)
        }
        buttonCompile.setOnClickListener {
            var text = textContainer.text.toString()
            var isSame = TextActivity.compare(text)
            if(text != ""){
                if(!isSame) {
                    TextActivity.setTextCode(text)
                    Compile.compile(text)
                }
                var err = Errors.getErrors().withErrors();
                if(!err){
                    val toast = Toast.makeText(this, "Sin errores", Toast.LENGTH_SHORT);
                    toast.show();
                    if(Execute.getExecute().readyToShow()){
                        val intent = Intent(this, ShowCharts::class.java).apply {}
                        startActivity(intent)
                    }
                    else{
                        val toast = Toast.makeText(this, "No hay gráficas para mostrar", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else{
                    val toast = Toast.makeText(this, "Con errores", Toast.LENGTH_SHORT);
                    toast.show();
                    val intent = Intent(this, ErrorsActivity::class.java).apply {}
                    startActivity(intent)
                }
            }
        }
    }
}
