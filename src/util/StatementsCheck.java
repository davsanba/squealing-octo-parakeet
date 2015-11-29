package util;

import controller.App;
import model.TipoErrores;
import grammar.Java8Parser.*;

public class StatementsCheck {
	public void ifThenStCheck(IfThenStatementContext ctx){
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
	
	public void ifThenElseStCheck(IfThenElseStatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("if") && !parte1.endsWith(" ")){
			if(!parte2.contains(" else ")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
				System.out.println("esto no sirve por que ");
			}
		}
	}
	
	public void whileStCheck(WhileStatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("while") && !parte1.endsWith(" ")){
			if(!parte2.contains("\n")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
				System.out.println("esto no sirve por que ");
			}
		}
	}
	
	public void forStCheck(ForStatementContext ctx){
		String statement = ctx.getText();
		String[] partes = statement.split("{");
		String parte1 = partes[0];
		String parte2 = partes[1];
		if(parte1.startsWith("for") && !parte1.endsWith(" ")){
			if(!parte2.contains("\n")){
				App.getInstance().setError(ctx.getStart().getLine(),statement,TipoErrores.IFTHEN);
				System.out.println("esto no sirve por que ");
			}
		}
	}
}