package t06e01;

public class Diretor extends Funcionario {
    private String[] Departamentos;
    
    public Diretor(String nome, String endereco, int idade, int cpf, double salario, String[] Departamentos) {
        super(nome, endereco, idade, cpf, salario);
        this.Departamentos = Departamentos;
    }
    
    public double getBonus() {
        return (4 * super.getSalario()) + (3000 * Departamentos.length);
    }
}
