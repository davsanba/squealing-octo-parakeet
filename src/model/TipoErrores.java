package model;

public enum TipoErrores {
	ESPACIOS(1),
	IDENTACION(2);
	
	TipoErrores(int tipo) {
	this.tipo = tipo;
	}
	private final int tipo;
}

