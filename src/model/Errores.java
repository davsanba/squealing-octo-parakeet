package model;

import org.antlr.v4.runtime.Token;

public class Errores {
	public Errores(int linea, String cadena, TipoErrores tipo){
		this.linea = linea;
		this.cadena = cadena;
		this.tipo = tipo;
	}
	
	private int linea;
	private String cadena;
	private TipoErrores tipo;
}
