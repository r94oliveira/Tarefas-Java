package t06e01;

public class Analista extends Funcionario {
    public Analista(String nome, String endereco, int idade, int cpf, double salario) {
        super(nome, endereco, idade, cpf, salario);
    }
    
    public double getBonus() {
        return super.getSalario();
    }
}
