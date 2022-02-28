/*
 * Welcome
 */
package com.example.practica1.parserLexer;

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
    }
    
    public PieChartCode(String title, ArrayList<String> labels, ArrayList<Double> values, ArrayList<Integer[]> union, String type, String extra) {
        super(title, values, labels, union);          
        this.type = type;        
        this.extra = extra;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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
