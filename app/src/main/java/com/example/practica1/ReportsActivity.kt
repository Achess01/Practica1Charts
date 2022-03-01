package com.example.practica1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.annotation.RequiresApi
import com.example.practica1.parserLexer.Errors.Errors
import com.example.practica1.parserLexer.Execute
import com.example.practica1.table.Table

class ReportsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)
        val tableMath = findViewById<TableLayout>(R.id.tlTableMaths)
        createMathReports(tableMath)
        val tableCount = findViewById<TableLayout>(R.id.tlTableCount)
        createCountReports(tableCount)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createMathReports(tableLayout: TableLayout){
        var table = Table(this, tableLayout)
        table.addHeader(R.array.header_maths)
        var symbols = Execute.getExecute().mathSymbols
        for(symbol in symbols){
            var elements = ArrayList<String>()
            elements.add(symbol.type)
            elements.add(symbol.line.toString())
            elements.add(symbol.column.toString())
            table.addRowTable(elements)
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createCountReports(tableLayout: TableLayout){
        var table = Table(this, tableLayout)
        table.addHeader(R.array.header_count)
        var errors = Errors.getErrors().lsErrors
        var elements = ArrayList<String>()
        elements.add("Barras");
        elements.add(Execute.getExecute().barChartsCount.toString())
        table.addRowTable(elements)
        elements = ArrayList<String>()
        elements.add("Pie");
        elements.add(Execute.getExecute().pieChartsCount.toString())
        table.addRowTable(elements)
    }
}