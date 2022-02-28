/*
 * Welcome
 */
package com.example.practica1.parserLexer.chartCode;

import java.util.ArrayList;

/**
 *
 * @author achess
 */
public class PieChartCode extends ChartCode{    
    private String type; 
    private Double total;
    private String extra;

    public PieChartCode(String title, ArrayList<String> labels, ArrayList<Double> values, ArrayList<Integer[]> union, String type, Double total, String extra) {
        super(title, values, labels, union);        
        this.type = type;
        this.total = total;
        this.extra = extra;
        getPercents();
    }
    
    public PieChartCode(String title, ArrayList<String> labels, ArrayList<Double> values, ArrayList<Integer[]> union, String type, String extra) {
        this(title, labels, values, union, type, 360.0, extra);
    }

    public String getType() {
        return type;
    }

    public Double getTotal() {
        return total;
    }

    public String getExtra() {
        return extra;
    }

    private void getPercents(){
        Double extr = 100.0;
        for(int i = 0; i < values.size(); i++){
            Double val = values.get(i);
            Double percent = (val*100)/total;
            values.set(i, percent);
            extr -= percent;
        }
        System.out.println(values);
        if(extr > 0){
            extraLabel = extra;
            extraValue = extr.floatValue();
        }
    }

     @Override
    public String toString() {
        StringBuilder ts = new StringBuilder();
        ts.append(super.toString());
        ts.append("type: " + type + "\n");
        ts.append("total: " + total + "\n");
        ts.append("extra: " + extra + "\n");
        return ts.toString();
    }    
    
}
