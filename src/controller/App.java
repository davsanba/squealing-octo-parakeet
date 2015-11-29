package controller;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.*;
import grammar.Error;
import grammar.Java8Parser.*;
import model.Errores;
import model.GenErrores;
import model.TipoErrores;
import util.Ident;
import util.NameCheck;
import util.StatementsCheck;
import view.MainWindow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class App {
	private App() { }
	   
	public static App getInstance() {
		if(instance == null) {
			instance = new App();
		}
		return instance;
	}
	
	public static void main(String[] args) {
			App.getInstance().start();
		}
	
	public void start(){
		//window = new MainWindow();
		nameChk = new NameCheck();
		ident = new Ident();
		generador = new GenErrores();
		statement = new StatementsCheck();
		analizar("C:/Users/Steven/Desktop/hola.java");
	}
	
	public void chkIdent(List<Token> tokens, int identLevel){
		ident.identCheck(tokens, identLevel);
	}
	
	public void checkClassName(NormalClassDeclarationContext ctx) {
		nameChk.checkClass(ctx);
	}
	
	public void checkMethodName(MethodDeclaratorContext ctx) {
		nameChk.checkMethod(ctx);
	}
	
	public void checkVarName(VariableDeclaratorIdContext ctx) {
		nameChk.checkVar(ctx);
	}
	
	public void checkStatementIf(IfThenStatementContext ctx) {
		statement.ifThenStCheck(ctx);
	}
	
	public void checkStatementIfElse(IfThenElseStatementContext ctx) {
		statement.ifThenElseStCheck(ctx);
	}
	
	public void checkStatementWhile(WhileStatementContext ctx) {
		statement.whileStCheck(ctx);
	}
	
	public void checkStatementFor(ForStatementContext ctx) {
		statement.forStCheck(ctx);
	}
	
	public void analizar(String texto){
		try {
			Java8Lexer lexer;
			if (texto.length() > 0)
				lexer = new Java8Lexer(new ANTLRFileStream(texto));
			else
				lexer = new Java8Lexer(new ANTLRInputStream(System.in));
				
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			lexer.removeErrorListeners();
			lexer.addErrorListener(new Error());

			
			Java8Parser parser = new Java8Parser(tokens);
			parser.removeErrorListeners();
	        parser.addErrorListener(new Error());
			ParseTree tree = parser.compilationUnit(); 
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(new Listener(tokens), tree);
		} catch (Exception e) {

			e.printStackTrace();
		
		}
	}

	public void setError(int linea, String cadena, TipoErrores tipo) {
		errores.add(new Errores(linea, cadena, tipo));
	}
	
	private List<Errores> errores = new ArrayList<Errores>();
	private StatementsCheck statement;
	private NameCheck nameChk;
	private GenErrores generador;
	private Ident ident;
	private MainWindow window;
	private static App instance = null;
	
}
