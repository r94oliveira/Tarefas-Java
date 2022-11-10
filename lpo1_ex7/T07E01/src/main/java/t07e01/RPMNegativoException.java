package t07e01;

public class RPMNegativoException extends Exception {
    public RPMNegativoException() {
        super("###ERRO###\nRPM deve ser positivo!");
    }
}
