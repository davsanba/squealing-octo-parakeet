package model;

import java.util.List;
import java.util.regex.*;
import org.antlr.v4.runtime.Token;
import controller.App;
import grammar.Java8Parser.*;

public class StatementsCheck {
	public void ifThenStCheck(StatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		
		if(!parte1.endsWith(" ")){
			App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
		}
	}
	
	public void ifThenElseStCheck(NormalClassDeclarationContext ctx){
		
	}
	
	public void whileStCheck(NormalClassDeclarationContext ctx){
		
	}
	
	public void forStCheck(NormalClassDeclarationContext ctx){
		
	}
}
