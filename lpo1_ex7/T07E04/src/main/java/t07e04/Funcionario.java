package t07e04;

public abstract class Funcionario {
    private String nome;
    private String endereco;
    private int idade;
    private int cpf;
    private double salario;
    
    public Funcionario(String nome, String endereco, int idade, int cpf, double salario) {
        setNome(nome);
        setEndereco(endereco);
        setIdade(idade);
        setCPF(cpf);
        setSalario(salario);
    }
    
    public void setNome(String nome){ this.nome = nome; }
    
    public String getNome(){ return nome; }
    
    public void setEndereco(String endereco){ this.endereco = endereco; }
    
    public void setIdade(int idade){ this.idade = idade; }
    
    public void setCPF(int cpf){ this.cpf = cpf; }
    
    public void setSalario(double salario){ this.salario = salario; }
    
    public double getSalario(){ return salario; }
    
    public abstract double getBonus();
}
