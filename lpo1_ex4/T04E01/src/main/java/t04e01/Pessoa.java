package t04e01;

public class Pessoa {
    public String nome;
    public int idade;
    public String endereco;
    
    public void fazAniversario() {
        this.idade++;
    }
    
    public void imprime() {
        System.out.printf("\nNome: %s\nIdade: %d\nEndereco: %s\n\n", this.nome, this.idade, this.endereco);
    }
}
