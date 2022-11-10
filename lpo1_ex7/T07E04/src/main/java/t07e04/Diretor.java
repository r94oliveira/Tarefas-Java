package t07e04;

public class Diretor extends Funcionario {
    private String[] Departamentos;
    
    public Diretor(String nome, String endereco, int idade, int cpf, double salario, String[] Departamentos) throws DiretorException {
        super(nome, endereco, idade, cpf, salario);
        
        if(Departamentos.length >= 2) {
            this.Departamentos = Departamentos;
        } else {
            throw new DiretorException();
        }
        
    }
    
    public double getBonus() {
        return (4 * super.getSalario()) + (3000 * Departamentos.length);
    }
}
