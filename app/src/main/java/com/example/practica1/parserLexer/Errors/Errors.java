/*
 * Welcome
 */
package com.example.practica1.parserLexer.Errors;

import com.example.practica1.parserLexer.Execute;

import java.util.ArrayList;

/**
 *
 * @author achess
 */
public class Errors {    
    public static int LEXICAL = 1;
    public static int SINTAX = 2;  
    private static Errors errors;    
    private ArrayList<LSError> lsErrors;
    private ArrayList<SemError> semErrors;
    
    private Errors(){
        semErrors = new ArrayList<>();
        lsErrors = new ArrayList<>();
    }
    
    public static Errors getErrors(){
        if(errors == null){
            errors = new Errors();
        }
        return errors;
    }
    
    public void clear(){
        lsErrors.clear();
        semErrors.clear();       
    }
    
    public void addLS(int line, int column, String description, String lexeme, int type){
        lsErrors.add(new LSError(line, column, description, lexeme, type));
    }
    
    public void addSemError(String description, int line){
        semErrors.add(new SemError(description, line));
    }

    public ArrayList<LSError> getLsErrors() {
        return lsErrors;
    }

    public ArrayList<SemError> getSemErrors() {
        return semErrors;
    }

    public boolean withErrors(){
        if(lsErrors.size() > 0) return true;
        if(semErrors.size() > 0) return true;
        return false;
    }
    
    
}
