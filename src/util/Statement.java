package util;

import java.util.ArrayList;
import java.util.List;

import controller.App;
import grammar.Java8Parser.ForStatementContext;
import grammar.Java8Parser.IfThenElseStatementContext;
import grammar.Java8Parser.IfThenStatementContext;
import grammar.Java8Parser.StatementWithoutTrailingSubstatementContext;
import grammar.Java8Parser.WhileStatementContext;
import model.TipoErrores;

public class Statement {
	public Statement(){
		lineas = new ArrayList<>();
	}

	public void checkLines(StatementWithoutTrailingSubstatementContext ctx) {
		int linea = ctx.getStart().getLine();
		lineas.add(linea);
		if(lineas.size() > 10){
			lineas.remove(0);
		}
		if(lineas.contains(linea)){
			App.getInstance().setError(linea, ctx.getText(), TipoErrores.VARIOSSTATEMENTSENLINEA);
		}
	}
	
	public void checkIfThen(IfThenStatementContext ctx) {
		String cont = ctx.getChild(4).getText();
		System.out.println(ctx.getChild(3));
		if(!cont.contains("{")){
			App.getInstance().setError(ctx.getStart().getLine(), cont, TipoErrores.IFSINLLAVE);
		}
	}
	
	public void checkIfElse(IfThenElseStatementContext ctx) {
		String contIf = ctx.getChild(4).getText();
		String contElse = ctx.getChild(6).getText();
		if(!contIf.contains("{") ){
			App.getInstance().setError(ctx.getStart().getLine(), contIf, TipoErrores.IFSINLLAVE);
		} else if(!contElse.contains("{")){
			App.getInstance().setError(ctx.getStart().getLine(), contElse, TipoErrores.IFSINLLAVE);
		}
	}
	
	public void checkWhile(WhileStatementContext ctx) {
		String cont = ctx.getChild(4).getText();
		if(!cont.contains("{")){
			App.getInstance().setError(ctx.getStart().getLine(), cont, TipoErrores.WHILESINLLAVE);
		}
	}
	
	public void checkFor(ForStatementContext ctx) {
		String cont = ctx.getChild(0).getText();
		if(!cont.contains("{")){
			App.getInstance().setError(ctx.getStart().getLine(), cont, TipoErrores.FORSINLLAVE);
		}
	}
	
	private List<Integer> lineas;
}
