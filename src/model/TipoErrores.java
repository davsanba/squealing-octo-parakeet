package model;

public enum TipoErrores {
	ESPACIOS(1),
	IDENTACION(2),
	NOMBRECLASE(3),
	NOMBREMETODO(4),
	NOMBREVARIABLE(5),
	VARIOSSTATEMENTSENLINEA(6),
	IFTHEN(7)
	;
	
	TipoErrores(int tipo) {
	this.tipo = tipo;
	}
	private final int tipo;
}

