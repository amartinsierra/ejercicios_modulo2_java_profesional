package exceptions;

public class SaldoNegativoException extends Exception {

	public SaldoNegativoException() {
		super("Saldo negativo en cuenta");
		
	}
	
}
