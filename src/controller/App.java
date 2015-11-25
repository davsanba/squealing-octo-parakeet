package controller;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.java8.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class App {
	private App() { }
	   
	public static App getInstance() {
		if(instance == null) {
			instance = new App();
		}
		return instance;
	}
	
	public static void main(String[] args) {

		}
	
	public void analizar(String[] texto){
		try {
			Java8Lexer lexer;
			if (texto.length > 0)
				lexer = new Java8Lexer(new ANTLRFileStream(texto[0]));
			else
				lexer = new Java8Lexer(new ANTLRInputStream(System.in));

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			Java8Parser parser = new Java8Parser(tokens);
			ParseTree tree = parser.compilationUnit(); 
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(new Java8BaseListener(), tree);
		} catch (Exception e) {

			System.err.println("Error (Test): " + e);
		
		}
	}


	
	private static App instance = null;
}
