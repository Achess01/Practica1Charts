/*
 * Welcome
 */
package com.example.practica1.parserLexer;

import com.example.practica1.parserLexer.Errors.Errors;
import com.example.practica1.parserLexer.attributes.ArrayNode;
import com.example.practica1.parserLexer.attributes.Attribute;
import com.example.practica1.parserLexer.attributes.Operation;
import com.example.practica1.parserLexer.chartCode.BarChartCode;
import com.example.practica1.parserLexer.chartCode.PieChartCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author achess
 */
public class Validate {
    private static HashMap<String, String> SYMBOLNAMES;

    public static HashMap<String, String> getSymbolNames(){
        if(SYMBOLNAMES == null) {
            SYMBOLNAMES = new HashMap<>();
            SYMBOLNAMES.put("SEMICOLON", ";");
            SYMBOLNAMES.put("COLON", ":");
            SYMBOLNAMES.put("COMMA", ",");
            SYMBOLNAMES.put("LBRACE", "{");
            SYMBOLNAMES.put("RBRACE", "{");
            SYMBOLNAMES.put("LBRACKET", "[");
            SYMBOLNAMES.put("RBRACKET", "]");
            SYMBOLNAMES.put("LPAREN", "(");
            SYMBOLNAMES.put("RPAREN", ")");
            SYMBOLNAMES.put("PLUS", "+");
            SYMBOLNAMES.put("MINUS", "-");
            SYMBOLNAMES.put("DIVISION", "/");
            SYMBOLNAMES.put("TIMES", "*");
        }
        return SYMBOLNAMES;
    }
    
   public static BarChartCode validateBar(ArrayList<Attribute> attributes){
       boolean error = false;
       String titulo = null;
       ArrayList<String> ejex = null;
       ArrayList<Double> ejey = null;
       ArrayList<Integer[]> coords = null;
       
       
       if(attributes.size() != 4){
           Error("Cantidad inesperada de atributos", attributes.get(0).getLine());
           error = true;
       }
       for(Attribute attr: attributes){
           int type = attr.getType();           
           switch(type){
               case Attribute.TITULO:
                    if(titulo != null){
                        Error(attr.getLine(), 0, "Atributo 'titulo' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;
                    }
                    else{
                        titulo = (String) attr.getAttribute();
                    }
                    break;
               case Attribute.EJEX:
                   if( ejex != null){                       
                        Error(attr.getLine(), 0, "Atributo 'ejex' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       ejex = getArrayStrings(attr);
                   }
                   break;
               case Attribute.EJEY:
                   if( ejey != null){                       
                        Error(attr.getLine(), 0, "Atributo 'ejey' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       ejey = getArrayInts(attr);
                       error = ejey == null ? true : error;
                   }
                   break;
                case Attribute.UNIR:
                   if( coords != null){                       
                        Error(attr.getLine(), 0, "Atributo 'unir' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       coords = getUnions(attr);
                       error = coords == null ? true : error;
                   }
                   break;
           }           
       }
       
       if (error) return null;
       BarChartCode chart = new BarChartCode(titulo, ejey, ejex, coords);
       return chart;
   }
   
   public static PieChartCode validatePie(ArrayList<Attribute> attributes){
       boolean error = false;
       boolean porcentaje = false;
       int totalLine = 0;
       String titulo = null;
       ArrayList<String> etiquetas = null;
       ArrayList<Double> valores = null;
       ArrayList<Integer[]> unions = null;
       String tipo = null;
       Double total = null;
       String extra = null;       
       
     
       if(attributes.size() != 6 && attributes.size() != 7){
           Error("Cantidad inesperada de atributos", attributes.get(0).getLine());
           error = true;
       }
       for(Attribute attr: attributes){
           int type = attr.getType();           
           switch(type){
               case Attribute.TITULO:
                    if(titulo != null){
                        Error(attr.getLine(), 0, "Atributo 'titulo' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;
                    }
                    else{
                        titulo = (String) attr.getAttribute();
                    }
                    break;
               case Attribute.ETIQUETAS:
                   if( etiquetas != null){                       
                        Error(attr.getLine(), 0, "Atributo 'etiquetas' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       etiquetas = getArrayStrings(attr);
                   }
                   break;
               case Attribute.VALORES:
                   if( valores != null){                       
                        Error(attr.getLine(), 0, "Atributo 'valores' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       valores = getArrayInts(attr);
                       error = valores == null ? true : error;
                   }
                   break;
                case Attribute.UNIR:
                   if( unions != null){                       
                        Error(attr.getLine(), 0, "Atributo 'unir' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       unions = getUnions(attr);
                       error = unions == null ? true : error;
                   }
                   break;
                case Attribute.EXTRA:
                   if( extra != null){                       
                        Error(attr.getLine(), 0, "Atributo 'extra' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       extra = (String) attr.getAttribute();                       
                   }
                   break;
                case Attribute.TIPO:
                   if( tipo != null){                       
                        Error(attr.getLine(), 0, "Atributo 'tipo' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       tipo = (String) attr.getAttribute();
                       porcentaje = tipo.equals("Porcentaje");
                   }
                   break;
                case Attribute.TOTAL:
                   if( total != null){                       
                        Error(attr.getLine(), 0, "Atributo 'total' ya definido", Attribute.TYPES[attr.getType() - 1], Errors.SINTAX);
                        error = true;                    
                   }else{
                       total = getValue(attr);
                       totalLine = attr.getLine();
                       error = total == null ? true : error;
                       error = total.equals(0) ? true : error;
                   }
                   break;
           }            
       }
       PieChartCode chart = null;
       if(porcentaje && total != null){
           Error("El TOTAL no debe estar definido con el tipo PORCENTAJE", totalLine);
           error = true;
       }else if (!porcentaje && total == null){
           Error("El TOTAL no está definido", attributes.get(0).getLine());
           error = true;
       }else if(porcentaje && total == null && titulo != null && etiquetas != null
       && valores != null && unions != null && tipo != null && extra != null){
           chart = new PieChartCode(titulo, etiquetas, valores, unions, tipo, extra);
       }else if(!porcentaje && total != null && titulo != null && etiquetas != null
               && valores != null && unions != null && tipo != null && extra != null){
           chart = new PieChartCode(titulo, etiquetas, valores, unions, tipo,total, extra);
       }else{
           Error(attributes.get(0).getLine(), 0, "Atributos inesperados en la gráfica pie", Attribute.TYPES[attributes.get(0).getType() - 1], Errors.SINTAX);
           error = true;
       }
       if (error) return null;       
       return chart;              
   }
   
   private static void Error(String des, int line){
       Errors.getErrors().addSemError(des, line);
   }
   
   private static void Error(int ln, int col, String des, String lex, int type){
       Errors.getErrors().addLS(ln, col, des, lex, type);
   }
   
   private static Double getValue(Attribute attr){       
       try{
            Operation op = (Operation) attr.getAttribute();
            Double val = op.run();
            if (val.isInfinite()){
                Error("Error matemático", attr.getLine());                 
            }else{
                return val;
            }            
        }catch(Exception e){
            Error("Error matemático", attr.getLine());            
        }
       return null;
   }
   
   private static ArrayList<String> getArrayStrings(Attribute attr){
       ArrayList<String> values = new ArrayList<>();
       ArrayNode<String> node = (ArrayNode<String>) attr.getAttribute();
       while(node != null){
           values.add(node.getValue());
           node = node.getNext();
       }
       return values;
   }
   
   private static ArrayList<Double> getArrayInts(Attribute attr){
       boolean error = false;
       ArrayList<Double> values = new ArrayList<>();
       ArrayNode<Operation> node = (ArrayNode<Operation>) attr.getAttribute();
       while(node != null){
           Operation op = node.getValue();
           Double val = null;
           try{
               val = op.run();
               if (val.isInfinite()){
                   Error("Error matemático", attr.getLine());
                   error = true;
               }else{
                   values.add(val);
               }
               
               node = node.getNext();
           }catch(Exception e){
               Error("Error matemático", attr.getLine());
               error = true;
           }                      
       }
       if (error) return null;
       return values;
   }
   
   private static ArrayList<Integer[]> getUnions(Attribute attr){
       boolean error = false;
       ArrayList<Integer[]> values = new ArrayList<>();
       ArrayNode<Operation[]> node = (ArrayNode<Operation[]>) attr.getAttribute();
       while(node != null){
           Operation op[] = node.getValue();
           Integer x = null;
           Integer y = null;
           try{
               Double xv = op[0].run();
               Double yv = op[1].run();
               
               if(xv.isInfinite() || yv.isInfinite()){
                   Error("Error matemático", attr.getLine());
                   error = true;
               }
               else{
                   x = xv.intValue();
                   y = yv.intValue();
                   Integer arr[] = {x,y};
                   values.add(arr);
               }
               
               node = node.getNext();
           }catch(Exception e){
               Error("Error matemático", attr.getLine());
               error = true;
           }                      
       }
       if (error) return null;
       return values;       
   }
}
