package com.example.practica1.parserLexer.lexer;

import java_cup.runtime.*;
import com.example.practica1.parserLexer.parser.sym;
%%

%class LexerP1
%public 
%unicode
%line
%column
%cup
//%standalone


%eofval{
  return new Symbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* Coments */
InputCharacter = [^\r\n]
Comment = "#" {InputCharacter}* {LineTerminator}?

/* Reserved words */

Def = ([Dd]ef)
Barras = (Barras)
Pie = (Pie)
titulo = (titulo)
ejex = (ejex)
ejey = (ejey)
etiquetas = (etiquetas)
valores = (valores)
unir = (unir)
tipo = (tipo)
total = (total)
extra = (extra)
Ejecutar = (Ejecutar)
Cantidad = (Cantidad)
Porcentaje = (Porcentaje)

/* Maths */

Plus = [+]
Minus = [-]
Times = [*]
Division = [\/]
LParen = [\(]
RParen = [\)]
Integer = 0|[1-9][0-9]*
Decimal = {Integer} \. \d+

/* Structures */

LBracket = [\[]
RBracket = [\]]
LBrace = [\{]
RBrace = [\}]
Colon = [:]
Comma = [,]
Semicolon = [;]

/* Strings */

Q = [\"]
StringContent = ([^\"\n\r])*
String = {Q}{StringContent}{Q}

%%

{Comment}
{/* Ignorar */}
{String} 
{return new Symbol(sym.STRING , yyline + 1, yycolumn + 1, yytext());}
{Def}
{return new Symbol(sym.DEF , yyline + 1, yycolumn + 1);}
{Barras}
{return new Symbol(sym.BARRAS , yyline + 1, yycolumn + 1);}
{Pie} 
{return new Symbol(sym.PIE , yyline + 1, yycolumn + 1);}
{titulo} 
{return new Symbol(sym.TITULO , yyline + 1, yycolumn + 1);}
{ejex} 
{return new Symbol(sym.EJEX , yyline + 1, yycolumn + 1);}
{ejey} 
{return new Symbol(sym.EJEY , yyline + 1, yycolumn + 1);}
{etiquetas} 
{return new Symbol(sym.ETIQUETAS , yyline + 1, yycolumn + 1);}
{valores} 
{return new Symbol(sym.VALORES , yyline + 1, yycolumn + 1);}
{unir} 
{return new Symbol(sym.UNIR , yyline + 1, yycolumn + 1);}
{tipo} 
{return new Symbol(sym.TIPO , yyline + 1, yycolumn + 1);}
{total} 
{return new Symbol(sym.TOTAL , yyline + 1, yycolumn + 1);}
{extra} 
{return new Symbol(sym.EXTRA , yyline + 1, yycolumn + 1);}
{Ejecutar} 
{return new Symbol(sym.EJECUTAR , yyline + 1, yycolumn + 1);}
{Cantidad} 
{return new Symbol(sym.CANTIDAD , yyline + 1, yycolumn + 1, yytext());}
{Porcentaje} 
{return new Symbol(sym.PORCENTAJE , yyline + 1, yycolumn + 1, yytext());}

{Plus} 
{return new Symbol(sym.PLUS , yyline + 1, yycolumn + 1);}
{Minus} 
{return new Symbol(sym.MINUS , yyline + 1, yycolumn + 1);}
{Times} 
{return new Symbol(sym.TIMES , yyline + 1, yycolumn + 1);}
{Division} 
{return new Symbol(sym.DIVISION , yyline + 1, yycolumn + 1);}
{LParen} 
{return new Symbol(sym.LPAREN , yyline + 1, yycolumn + 1);}
{RParen} 
{return new Symbol(sym.RPAREN , yyline + 1, yycolumn + 1);}
{Integer} 
{return new Symbol(sym.INTEGER , yyline + 1, yycolumn + 1, new Double(yytext()));}
{Decimal} 
{return new Symbol(sym.DECIMAL , yyline + 1, yycolumn + 1, new Double(yytext()));}

{LBracket} 
{return new Symbol(sym.LBRACKET , yyline + 1, yycolumn + 1);}
{RBracket} 
{return new Symbol(sym.RBRACKET , yyline + 1, yycolumn + 1);}
{LBrace} 
{return new Symbol(sym.LBRACE , yyline + 1, yycolumn + 1);}
{RBrace} 
{return new Symbol(sym.RBRACE , yyline + 1, yycolumn + 1);}
{Colon} 
{return new Symbol(sym.COLON , yyline + 1, yycolumn + 1);}
{Comma} 
{return new Symbol(sym.COMMA , yyline + 1, yycolumn + 1);}
{Semicolon} 
{return new Symbol(sym.SEMICOLON , yyline + 1, yycolumn + 1);}

{WhiteSpace} {/* Ignorar */}
[^] {throw new RuntimeException("Caracter inesperado \""+yytext()+
                                "\" ln:"+yyline+", col:"+yycolumn);
                                }