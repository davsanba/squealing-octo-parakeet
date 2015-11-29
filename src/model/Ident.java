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
			Matcher sp = space.matcher(token.getText());
			Matcher tb = tab.matcher(token.getText());
			if(sp.find(0)){
				rt += spacesCheck(sp, token);
			}
			else if(tb.find()){
				
				rt += token.getText().length();
			}
		}
		System.out.println(rt);
		return rt;
	}

	private int spacesCheck(Matcher sp, Token token) {
		int rt = 0;
		int spaces = 0;
		while(sp.find()){
			spaces ++;
		}
		spaces++;
		if(spaces % 4 == 0)
			rt += spaces/4;
		else
			App.getInstance().setError(token,TipoErrores.ESPACIOS);
		return rt;
		
	}
	
}
