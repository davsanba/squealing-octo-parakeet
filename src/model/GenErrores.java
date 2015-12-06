package model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import controller.App;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenErrores {
	
	public void generarErrores(List<Errores> lista, String ruta) {
		try {
			List<String> lst = metodo(lista);
			App.getInstance().listaErrores(lst);
			String aux[] = nombre(ruta);
			String nombre = aux[0];
			ruta = aux[1];
			PrintWriter writer = new PrintWriter(ruta, "UTF-8");
			writer.println(nombre);
			for(String str: lst){
				writer.println("+	"+str);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<String> metodo(List<Errores> lista) {
		ArrayList<String> errorList = new ArrayList<String>();
		for (Errores error : lista) {
			int a = error.linea;
			String b = error.cadena;
			TipoErrores c = error.tipo;

			StringBuilder err = new StringBuilder();

			err.append("Error en la linea: ");
			err.append(a);
			err.append(", en la cadena: ");
			err.append(b);

			switch (c) {
			case ESPACIOS:
				err.append(", Violación de la unidad minima de identación, se recomienda tener 4 espacios como la unidad minima de identacion en bloques.");
				errorList.add(new StringBuilder(err).toString());
				break;
			case IDENTACION:
				err.append(", Violación de la identación, se recomienda tener la tabulacion hacia la derecha despues de iniciar el bloque");
				errorList.add(new StringBuilder(err).toString());
				break;
			case NOMBRECLASE:
				err.append(", Violación de regla nombre, se recomienda tener el nombre en UpperCamelCase");
				errorList.add(new StringBuilder(err).toString());
				break;
			case NOMBREMETODO:
				err.append(", Violación de regla nombre, se recomienda tener el nombre en lowerCamelCase");
				errorList.add(new StringBuilder(err).toString());
				break;
			case NOMBREVARIABLE:
				err.append(", Violacion de regla nombre, se recomienda tener el nombre en lowerCamelCase");
				errorList.add(new StringBuilder(err).toString());
				break;

			case VARIOSSTATEMENTSENLINEA:
				err.append(", Se recomienda tener una sola declaracion por linea");
				errorList.add(new StringBuilder(err).toString());
				break;

			case ESPACIOLLAVE:
				err.append(
						", Violación de espacio en sentencia if, se recomienda tener un espacio antes de la llave {");
				errorList.add(new StringBuilder(err).toString());
				break;
			case IFSINLLAVE:
				err.append(
						", Violación de regla de corchetes, se recomienda tener los corchetes { } asi sea una sentencia vacia");
				errorList.add(new StringBuilder(err).toString());
				break;
			case WHILESINLLAVE:
				err.append(
						", Violación de regla de corchetes, se recomienda tener los corchetes { } asi sea una sentencia vacia");
				errorList.add(new StringBuilder(err).toString());
				break;
			case FORSINLLAVE:
				err.append(
						", Violación de regla de corchetes, se recomienda tener los corchetes { } asi sea una sentencia vacia");
				errorList.add(new StringBuilder(err).toString());
				break;
			default:
				err.append(", Violación de las reglas");
				errorList.add(new StringBuilder(err).toString());
				break;
			}
		}

		return errorList;
	}

	public String[] nombre(String ruta){
		String ret[] = new String[2];
		String rt = "";
		String aux[] = ruta.split("\\\\");
		String nombre = aux[(aux.length-1)];
		ret[0] = nombre;
		aux[(aux.length-1)] = "";
		for(String a: aux ){
			if(a != ""){
				rt += a;
				rt += "\\\\";
			}
		}
		String aux2[] = nombre.split("\\.");
		rt += aux2[0];
		rt += ".txt";
		ret[1] = rt;
		return ret;
	}
}
