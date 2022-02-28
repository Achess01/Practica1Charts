/*
 * Welcome
 */
package com.example.practica1.parserLexer.chartCode;

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
    protected ArrayList<String> x_labels;
    protected ArrayList<Float> y_values;
    protected String extraLabel;
    protected Float extraValue;

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

    public void makeMPAndroidCharts(){
        if(x_labels  == null|| y_values == null) {
            x_labels = new ArrayList<>();
            y_values = new ArrayList<>();
            for (Integer[] ints : union) {
                int x = ints[0];
                int y = ints[1];
                if (
                        x >= 0 && x < labels.size()
                        && y >= 0 && y < values.size()
                ) {
                    x_labels.add(labels.get(x));
                    Float y_val = values.get(y).floatValue();
                    y_values.add(y_val);
                }
            }
            if(extraLabel != null && extraValue != null){
                x_labels.add(extraLabel);
                y_values.add(extraValue);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getX_labels() {
        return x_labels;
    }

    public ArrayList<Float> getY_values() {
        return y_values;
    }
}
