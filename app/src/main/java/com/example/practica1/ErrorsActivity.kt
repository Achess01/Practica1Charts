package com.example.practica1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.annotation.RequiresApi
import com.example.practica1.parserLexer.Errors.Errors
import com.example.practica1.reports.Table

class ErrorsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_errors)

        var tableErrors = findViewById<TableLayout>(R.id.tlTableErrors);
        createSemReports(tableErrors)
        var tableLSErrors = findViewById<TableLayout>(R.id.tlTableErrorsSintax)
        createLSReports(tableLSErrors)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createSemReports(tableLayout: TableLayout){
        var table = Table(this, tableLayout)
        table.addHeader(R.array.header_sem)
        var errors = Errors.getErrors().semErrors
        for(error in errors){
            var elements = ArrayList<String>()
            elements.add(error.line.toString())
            elements.add(error.description)
            table.addRowTable(elements)
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createLSReports(tableLayout: TableLayout){
        var table = Table(this, tableLayout)
        table.addHeader(R.array.header_errors)
        var errors = Errors.getErrors().lsErrors
        for(error in errors){
            var elements = ArrayList<String>()
            elements.add(error.lexeme)
            elements.add(error.line.toString())
            if(error.column == 0){
                elements.add("-")
            }
            else{
                elements.add(error.column.toString())
            }

            elements.add(error.type)
            elements.add(error.description)
            table.addRowTable(elements)
        }

    }
}