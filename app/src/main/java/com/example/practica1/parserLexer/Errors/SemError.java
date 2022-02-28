/*
 * Welcome
 */
package com.example.practica1.parserLexer.Errors;

/**
 *
 * @author achess
 */
public class SemError {
    private String description;
    private int line;

    public SemError(String description, int line) {
        this.description = description;
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "SemError{" + "description=" + description + ", line=" + line + '}';
    }
    
    
    
}
