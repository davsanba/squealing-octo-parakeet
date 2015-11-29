package util;

import controller.App;
import grammar.Java8Parser.MethodDeclaratorContext;
import grammar.Java8Parser.NormalClassDeclarationContext;
import grammar.Java8Parser.VariableDeclaratorIdContext;
import model.TipoErrores;

public class NameCheck {

	public void checkClass(NormalClassDeclarationContext ctx){
		String nombre = getClassName(ctx.getText());
		if( !Character.isUpperCase(nombre.charAt(0)) || nombre.contains("_"))
			App.getInstance().setError(ctx.getStart().getLine(),nombre,TipoErrores.NOMBRECLASE);
	}
	
	public void checkMethod(MethodDeclaratorContext ctx){
		String nombre  = getMethodName(ctx.getText());
		if( !Character.isLowerCase(nombre.charAt(0)) || nombre.contains("_"))
			App.getInstance().setError(ctx.getStart().getLine(),nombre,TipoErrores.NOMBREMETODO);
	}
	
	public void checkVar(VariableDeclaratorIdContext ctx){
		String nombre  = ctx.getText();
		if( !Character.isLowerCase(nombre.charAt(0)) || nombre.contains("_"))
			App.getInstance().setError(ctx.getStart().getLine(),nombre,TipoErrores.NOMBREVARIABLE);
	}
	
	public String getClassName(String name){
		String rt = "";
		String a[] = name.split("class");
		a = a[1].split("extends|implements|[<{]");
		rt = a[0];
		return rt;
	}
	
	public String getMethodName(String name){
		String rt = "";
		String a[] = name.split("[(]");
		rt = a[0];
		return rt;
	}
}
