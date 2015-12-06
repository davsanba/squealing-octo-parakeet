package model;

import org.antlr.v4.runtime.Token;

public class Errores {
	public Errores(int linea, String cadena, TipoErrores tipo){
		this.linea = linea;
		this.cadena = cadena;
		this.tipo = tipo;
	}
	
	public int linea;
	public String cadena;
	public TipoErrores tipo;
}
