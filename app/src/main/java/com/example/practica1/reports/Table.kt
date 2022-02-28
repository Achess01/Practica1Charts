package com.example.practica1.reports

import android.app.Activity
import android.os.Build
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.TableRow;
import com.example.practica1.R


class Table {
    private var table: TableLayout? = null
    private var rows: ArrayList<TableRow>? = null
    private var activity: Activity? = null
    private var resources: Resources? = null
    private var row = 0
    private var col = 0

    constructor(activity: Activity, table: TableLayout) {
        this.activity = activity
        this.table = table
        resources = this.activity!!.resources
        row = 0
        this.col = 0
        rows = ArrayList()
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun addHeader(header: Int) {
        var layoutCell: TableRow.LayoutParams?
        val r = TableRow(activity)
        val layoutRow: TableRow.LayoutParams =
            TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT
            )
        r.layoutParams = layoutRow
        val arrayHeader = resources?.getStringArray(header)
        if (arrayHeader != null) {
            this.col = arrayHeader.size
        }
        for (i in 0 until this.col) {
            val text = TextView(activity)
            layoutCell =
                TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT
                )
            text.text = arrayHeader?.get(i) ?: null
            text.gravity = Gravity.CENTER_HORIZONTAL
            text.setTextAppearance(R.style.cell_style)
            text.setBackgroundResource(R.drawable.table_cell_header)
            text.layoutParams = layoutCell
            r.addView(text)
        }
        table!!.addView(r)
        rows!!.add(r)
        row++
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun addRowTable(elements: List<String>) {
        var layoutCell: TableRow.LayoutParams?
        val layoutRow: TableRow.LayoutParams =
            TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT
            )
        val r = TableRow(activity)
        r.layoutParams = layoutRow
        for (i in elements.indices) {
            val text = TextView(activity)
            text.text = elements[i]
            text.gravity = Gravity.CENTER_HORIZONTAL
            text.setTextAppearance(R.style.cell_style)
            text.setBackgroundResource(R.drawable.cell_style)
            layoutCell =
                TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT
                )
            text.layoutParams = layoutCell
            r.addView(text)
        }
        table!!.addView(r)
        rows!!.add(r)
        row++
    }

    private fun getWidthPx(text: String): Int {
        val paint = Paint()
        val bound = Rect()
        paint.textSize = 48f
        paint.getTextBounds(text, 0, text.length, bound)
        return bound.width()
    }
}