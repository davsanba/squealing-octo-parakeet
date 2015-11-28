package grammar;


import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class Error extends BaseErrorListener {
	@Override
	public void syntaxError(Recognizer<?,?> recognizer,
            				Object offendingSymbol,
            				int line,
            				int charPositionInLine,
            				String msg,
            				RecognitionException e){    
        if(e != null ){
            if(!msg.contains("<EOF>")){
        		String exc=e.getClass().getName();
                if (exc.contains("InputMismatchException")) {
                    System.out.println("Error Sintactico: Entrada no coincide con tokens. Linea " + line + ", caracter " + charPositionInLine + ". Por favor verifique su codigo UNALang.");
                    System.out.println("\t Detalle del error: " + msg);
                }else if (exc.contains("FailedPredicateException")) {
                    System.out.println("Error Semantico: Validacion Fallida. Linea " + line + ", caracter " + charPositionInLine + ". Por favor verifique su codigo UNALang.");
                    System.out.println("\t Detalle del error: " + msg);
                }else if (exc.contains("LexerNoViableAltException")) {
                    System.out.println("Error Sintactico: Ambiguedad en entrada para analisis. Linea " + line + ", caracter " + charPositionInLine + ". Por favor verifique su codigo UNALang.");
                    System.out.println("\t Detalle del error: " + msg);
                }else if (exc.contains("NoViableAltException")) {
                    System.out.println("Error Semantico: Ambiguedad en entrada para analisis. Linea " + line + ", caracter " + charPositionInLine + ". Por favor verifique su codigo UNALang.");
                    System.out.println("\t Detalle del error: " + msg);
                }else{
                    System.out.println("OTRO ERROR :V");
                }
            }
        } 
        else {
            System.out.println("Error " + msg + " en Linea " + line + " " + ", caracter " + charPositionInLine  );  
        }
	}
}
