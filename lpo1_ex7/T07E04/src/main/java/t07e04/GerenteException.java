package t07e04;

public class GerenteException extends Exception {
    public GerenteException() {
        super("###ERRO###\nO Gerente deve gerenciar ao menos 5 funcionários!");
    }
}
