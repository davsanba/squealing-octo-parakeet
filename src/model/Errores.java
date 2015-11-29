package model;

import org.antlr.v4.runtime.Token;

public class Errores {
	public Errores(Token token, TipoErrores tipo){
		this.token = token;
		this.tipo = tipo;
	}
	
	private Token token;
	private TipoErrores tipo;
}
