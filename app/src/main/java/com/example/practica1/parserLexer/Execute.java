/*
 * Welcome
 */
package com.example.practica1.parserLexer;

import com.example.practica1.parserLexer.attributes.MathSymbol;
import com.example.practica1.parserLexer.chartCode.BarChartCode;
import com.example.practica1.parserLexer.chartCode.ChartCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author achess
 */
public class Execute {
    private ArrayList<String> chartsNames;
    private HashMap<String, ChartCode> charts;
    private ArrayList<ChartCode> chooseOnes;
    private static Execute execute;
    private int pieChartsCount;
    private int barChartsCount;
    private ArrayList<MathSymbol> mathSymbols;
    
    private Execute(){
        chartsNames = new ArrayList<>();
        charts = new HashMap<>();
        pieChartsCount = 0;
        barChartsCount = 0;
        mathSymbols = new ArrayList<>();
    }
    
    public static Execute getExecute(){
        if(execute == null){
            execute = new Execute();
        }
        return execute;
    }
    
    public void clear(){
        barChartsCount = 0;
        pieChartsCount = 0;
        charts.clear();
        chartsNames.clear();
        chooseOnes = null;
        mathSymbols.clear();
    }                

    public void addExecuteCall(String name){
        chartsNames.add(name);
    }
    
    public void addChart(ChartCode chart){
        if(chart instanceof BarChartCode) barChartsCount++;
        else pieChartsCount++;
        charts.put(chart.getTitle(), chart);
    }

    public int getPieChartsCount() {
        return pieChartsCount;
    }

    public int getBarChartsCount() {
        return barChartsCount;
    }

    public ArrayList<MathSymbol> getMathSymbols() {
        return mathSymbols;
    }

    public void addMathSymbol(int line, int column, int type){
        mathSymbols.add(new MathSymbol(line, column, type));
    }

    public ArrayList<ChartCode> theOnes(){
        if(chooseOnes == null){
            int index = chartsNames.size() - 1;
            chooseOnes = new ArrayList<>();

            for(int i = index; i >= 0; i--){
                ChartCode val = charts.get(chartsNames.get(i));
                if(val != null){
                    chooseOnes.add(val);
                }
            }
        }
        return chooseOnes;
    }

    public boolean readyToShow(){
        return chartsNames.size() > 0;
    }
}
