/*
 * Welcome
 */
package com.example.practica1.parserLexer;

import java.util.ArrayList;

/**
 *
 * @author achess
 */
public abstract class ChartCode {
    protected String title;
    protected ArrayList<Double> values;
    protected ArrayList<String> labels;
    protected ArrayList<Integer[]> union;    

    public ChartCode(String title, ArrayList<Double> values, ArrayList<String> labels, ArrayList<Integer[]> coords) {
        this.title = title;
        this.values = values;
        this.labels = labels;
        this.union = coords;        
    }

    @Override
    public String toString() {
        StringBuilder ts = new StringBuilder();
        ts.append("title: " + title + "\n");
        String v = "";        
        ts.append("labels:\n" + labels+ "\n");        
        ts.append("values:\n" + values+ "\n");
        v = "";
        for(Integer[] val : union){
            v += "{" + val[0]+ "," + val[1]+ "}\n";
        }
        ts.append("coords: " + v);
        return ts.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<Integer[]> getUnion() {
        return union;
    }

    public void setUnion(ArrayList<Integer[]> union) {
        this.union = union;
    }
    
}
