package trabajarconobligatorio.Genericos;

public class Retorno {
	public enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
	boolean valorbooleano;
	public Resultado resultado;

	public Retorno(Resultado resultado) {

		this.resultado = resultado;
	}

}
