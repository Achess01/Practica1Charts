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
    private ArrayList<ChartCode> chooseOnes;
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
        chooseOnes = null;
    }                

    public ArrayList<String> getChartsNames() {
        return chartsNames;
    }

    public HashMap<String, ChartCode> getCharts() {
        return charts;
    }
    
    public void addExecuteCall(String name){
        chartsNames.add(name);
    }
    
    public void addChart(ChartCode chart){
        charts.put(chart.getTitle(), chart);
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
        System.out.println(chartsNames.size());
        return chartsNames.size() > 0;
    }
}
