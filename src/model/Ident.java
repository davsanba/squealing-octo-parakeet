package model;

import java.util.List;
import java.util.regex.*;

import org.antlr.v4.runtime.Token;

import controller.App;

public class Ident {
	
	public int tabConverter(List<Token> tokens, int identLevel ){
		int rt = 0;
		Pattern space = Pattern.compile(" ");
		Pattern tab = Pattern.compile("\t");
		for(Token token: tokens){
			int spaces = 0;
			Matcher sp = space.matcher(token.getText());
			Matcher tb = tab.matcher(token.getText());
			while(sp.find()){
				spaces ++;
			}
			while(tb.find())
				rt ++;
			if(spaces % 4 == 0)
				rt ++ ;
			else
				App.getInstance().setError(token,TipoErrores.ESPACIOS);
		}
		return rt;
	}
	
}
