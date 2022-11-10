package t06e01;

public class Gerente extends Funcionario {
    private String[] Funcionarios;
    
    public Gerente(String nome, String endereco, int idade, int cpf, double salario, String[] Funcionarios) {
        super(nome, endereco, idade, cpf, salario);
        this.Funcionarios = Funcionarios;
    }
    
    public double getBonus() {
        return (2 * super.getSalario()) + (100 * Funcionarios.length);
    }
}
