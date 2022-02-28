/*
 * Welcome
 */
package com.example.practica1.parserLexer;

/**
 *
 * @author achess
 */
public class Attribute<T> {
    public static final int TITULO = 1;
    public static final int EJEX = 2; 
    public static final int EJEY = 3;
    public static final int UNIR = 4;    
    public static final int ETIQUETAS = 5;
    public static final int VALORES = 6;
    public static final int TIPO = 7;
    public static final int TOTAL = 8;
    public static final int EXTRA = 9;    
    public static final String TYPES[] = {"titulo", "ejex", "ejey", "unir", "etiquetas",
    "valores", "tipo", "total", "extra"};
    private T attribute;
    private int type;
    private int line;

    public Attribute(T attribute, int type, int line) {
        this.attribute = attribute;
        this.type = type;
        this.line = line;
    }

    public T getAttribute() {
        return attribute;
    }

    public int getType() {
        return type;
    }               

    public int getLine() {
        return line;
    }

    
    
    @Override
    public String toString() {
        return "Attribute{" + "attribute=" + attribute + ", type=" + type + ", line=" + line + '}';
    }
    
    
}
