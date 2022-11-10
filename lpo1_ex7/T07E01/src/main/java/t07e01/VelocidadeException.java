package t07e01;

public class VelocidadeException extends Exception {
    public VelocidadeException() {
        super("###ERRO###\nVelocidade deve ser positivo e não superar 100km/h!");
    }
}
