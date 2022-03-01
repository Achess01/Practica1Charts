package com.example.practica1.parserLexer.attributes;

import java.util.ArrayList;

public class MathSymbol {
    public static final int SUMA = 1;
    public static final int RESTA = 2;
    public static final int DIVISION = 3;
    public static final int MULTIPLICACION = 4;
    private int line;
    private int column;
    private String type;

    public MathSymbol(int line, int column, int type) {
        this.line = line;
        this.column = column;
        this.type="";
        switch (type){
            case 1: this.type="SUMA"; break;
            case 2: this.type="RESTA"; break;
            case 3: this.type="DIVISION"; break;
            case 4: this.type="MULTIPLICACION"; break;
        }
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getType() {
        return type;
    }
}
