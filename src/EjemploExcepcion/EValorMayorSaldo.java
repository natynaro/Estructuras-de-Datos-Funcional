package EjemploExcepcion;

public class EValorMayorSaldo extends Exception {
 private String string;

public EValorMayorSaldo(String string) {
	super(string);
	this.string = string;
}

public EValorMayorSaldo() {
	super("El saldo no es suficiente");

}
}
