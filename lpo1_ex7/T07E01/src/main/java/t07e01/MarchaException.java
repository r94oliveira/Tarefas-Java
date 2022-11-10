package t07e01;

public class MarchaException extends Exception {
    public MarchaException() {
        super("###ERRO###\nMarcha deve ser positivo e não superar 24!");
    }
}
