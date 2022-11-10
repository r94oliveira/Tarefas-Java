package t07e04;

public class DiretorException extends Exception {
    public DiretorException() {
        super("###ERRO###\nO Diretor deve ter pelo menos 2 departamentos!");
    }
}
