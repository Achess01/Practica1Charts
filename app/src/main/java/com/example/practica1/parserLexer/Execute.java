/*
 * Welcome
 */
package com.example.practica1.parserLexer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author achess
 */
public class Execute {
    private ArrayList<String> chartsNames;
    private HashMap<String, ChartCode> charts;
    private static Execute execute;    
    
    private Execute(){
        chartsNames = new ArrayList<>();
        charts = new HashMap<>();
    }
    
    public static Execute getExecute(){
        if(execute == null){
            execute = new Execute();
        }
        return execute;
    }
    
    public void clear(){
        charts.clear();
        chartsNames.clear();
    }                

    public ArrayList<String> getChartsNames() {
        return chartsNames;
    }

    public HashMap<String, ChartCode> getCharts() {
        return charts;
    }
    
    public void addExecuteCall(String name){
        chartsNames.add(chartsNames.size(), name);
    }
    
    public void addChart(ChartCode chart){
        charts.put(chart.getTitle(), chart);
    }
    
}
