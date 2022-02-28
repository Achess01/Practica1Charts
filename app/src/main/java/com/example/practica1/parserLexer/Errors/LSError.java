/*
 * Welcome
 */
package com.example.practica1.parserLexer.Errors;

/**
 *
 * @author achess
 */
public class LSError{          
        private int line;
        private int column;
        private String description;
        private String lexeme;
        private String type;

        public LSError(int line, int column, String description, String lexeme, int type) {
            this.line = line;
            this.column = column;
            this.description = description;
            this.lexeme = lexeme;
            if(type == Errors.LEXICAL){
                this.type = "Léxico";
            }else{
                this.type = "Sintáctico";
            }
        }                                

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        
        
    }
