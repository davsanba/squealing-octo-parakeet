package model;

import controller.App;
import grammar.Java8Parser.*;

public class StatementsCheck {
	public void ifThenStCheck(StatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("if") && !parte1.endsWith(" ")){
			if(!parte2.contains("\n")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
			}
		}	
	}
	
	public void ifThenElseStCheck(StatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("if") && !parte1.endsWith(" ")){
			if(!parte2.contains(" else ")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
			}
		}
	}
	
	public void whileStCheck(StatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("while") && !parte1.endsWith(" ")){
			if(!parte2.contains("\n")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
			}
		}
	}
	
	public void forStCheck(StatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("for") && !parte1.endsWith(" ")){
			if(!parte2.contains("\n")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
			}
		}
	}
}
