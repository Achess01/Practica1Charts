/*
 * Welcome
 */
package com.example.practica1.parserLexer;
/**
 *
 * @author achess
 */
public class Operation{
    private String type;
    private Double value;
    private Operation left;
    private Operation right;    

    public Operation(String type, Operation left, Operation right) {                
        this.type = type;
        this.left = left;
        this.right = right;        
    }
    
    public Operation(String type, Double value) {
        this.type = type;   
        this.value = value;
    }       

    public void setLeft(Operation left) {
        this.left = left;
    }

    public void setRight(Operation right) {
        this.right = right;
    }

    public String getType() {
        return type;
    }

    public Double getValueStr() {
        return value;
    }

    public Operation getLeft() {
        return left;
    }

    public Operation getRight() {
        return right;
    }
       
    public Double run() {        
        if(type.equals("n")){
            return value;
        }        
        else if(type.equals("*")){
            Double mul = left.run() * right.run();
            return mul;
        }
        else if(type.equals("/")){
            Double div = left.run() / right.run();
            return div;
        }
        else if(type.equals("-")){
            Double min = left.run() - right.run();
            return min;
        }
        else if(type.equals("+")){
            Double plus = left.run() + right.run();
            return plus;
        }
        else if(type.equals("minus")){
            Double negar = 0 - left.run();
            return negar;
        }        
        return 0.0;
    }

    @Override
    public String toString() {
        return "Operation{" + "type=" + type + ", valueStr=" + value + ", left=" + left + ", right=" + right + '}';
    }
    
    
    
}
