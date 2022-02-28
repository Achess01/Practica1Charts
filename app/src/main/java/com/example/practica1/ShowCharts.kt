package com.example.practica1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.practica1.parserLexer.chartCode.BarChartCode
import com.example.practica1.parserLexer.chartCode.ChartCode
import com.example.practica1.parserLexer.Execute
import com.example.practica1.parserLexer.chartCode.PieChartCode
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class ShowCharts : AppCompatActivity() {

    val colors = listOf(Color.CYAN, Color.RED, Color.GREEN, Color.BLUE, Color.LTGRAY)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_charts)

        val charts: ArrayList<ChartCode> = Execute.getExecute().theOnes();
        val wrapper = findViewById<LinearLayout>(R.id.wrapper);
        for (chart in charts){
            if(chart is BarChartCode){
                chart.makeMPAndroidCharts();
                val bchart = getBarChart(chart.title, chart.y_values, chart.x_labels);
                wrapper.addView(bchart);
            }
            else if(chart is PieChartCode){
                chart.makeMPAndroidCharts();
                val pchart = getPieChart(chart.title, chart.y_values, chart.x_labels);
                wrapper.addView(pchart);
            }
        }
    }

    private fun getBarChart(title: String, values: ArrayList<Float>, labels: ArrayList<String>): BarChart {
        val chart = BarChart(this);
        chart.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
        chart.setDrawGridBackground(true)
        chart.data = getBarData(values);
        chart.legend.isEnabled = false
        chart.invalidate()
        chart.description.text = title
        chart.description.textSize = 20f;
        chart.setBackgroundColor(Color.WHITE)
        chart.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
        axisX(chart.xAxis, labels)
        axisLeft(chart.axisLeft)
        axisRight(chart.axisRight)
        return chart;
    }

    private fun getPieChart(title: String, values: ArrayList<Float>, labels: ArrayList<String>): PieChart {
        val chart = PieChart(this);
        chart.description.text = title
        chart.description.textSize = 20f;
        chart.setBackgroundColor(Color.WHITE)
        chart.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
        chart.holeRadius = 10f
        chart.transparentCircleRadius = 12f
        chart.isDrawHoleEnabled = false
        chart.data = getPieData(values, labels)
        chart.legend.isEnabled = false
        chart.invalidate()
        return chart;
    }


    private fun getPieEntries(values: ArrayList<Float>, labels: ArrayList<String>): ArrayList<PieEntry> {
        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in values.indices) entries.add(PieEntry(values[i], labels[i]))
        return entries
    }

    private fun getPieData(values: ArrayList<Float>, labels: ArrayList<String>): PieData {
        val pieDataSet = PieDataSet(getPieEntries(values, labels), "")
        pieDataSet.colors = colors;
        pieDataSet.sliceSpace = 2f
        pieDataSet.valueTextSize = 12f
        pieDataSet.valueFormatter = PercentFormatter()
        return PieData(pieDataSet)
    }

    private fun getBarEntries(values: ArrayList<Float>): ArrayList<BarEntry> {
        val entries: ArrayList<BarEntry> = ArrayList()
        for (i in values.indices) entries.add(BarEntry(i.toFloat(), values[i]))
        return entries
    }

    private fun axisX(axis: XAxis, labels: ArrayList<String>){
        axis.isGranularityEnabled = true
        axis.position = XAxis.XAxisPosition.BOTTOM_INSIDE;
        axis.valueFormatter = IndexAxisValueFormatter(labels);
        axis.textSize = 15f
    }

    private fun axisLeft(axis: YAxis) {
        axis.spaceTop = 30f
        axis.axisMinimum = 0f
        axis.granularity = 20f
    }

    private fun axisRight(axis: YAxis) {
        axis.isEnabled = false
    }

    private fun getBarData(values: ArrayList<Float>): BarData {
        var barDataSet = BarDataSet(getBarEntries(values), "")
        barDataSet.barShadowColor = Color.GRAY
        barDataSet.colors = colors;
        barDataSet.valueTextSize = 15f
        val barData = BarData(barDataSet)
        barData.barWidth = 0.45f
        return barData
    }
}