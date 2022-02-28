/*
 * Welcome
 */
package com.example.practica1.parserLexer;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.practica1.parserLexer.Errors.Errors;
import com.example.practica1.parserLexer.lexer.LexerP1;
import com.example.practica1.parserLexer.parser.ParserP1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;


/**
 *
 * @author achess
 */
public class Compile {
    
    @RequiresApi(api = Build.VERSION_CODES.N)

    public static void compile(String text){
        try{
            Reader reader = new StringReader(text);
            LexerP1 lexer = new LexerP1(reader);
            ParserP1 parser = new ParserP1(lexer);
            try{
                Errors.getErrors().clear();
                Execute.getExecute().clear();
                parser.parse();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
