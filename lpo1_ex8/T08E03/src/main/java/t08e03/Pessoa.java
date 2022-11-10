package t08e03;

public class Pessoa {
    private String nome;
    private int idade;
    private String endereco;
    
    public Pessoa(String nome, int idade, String endereco) {
        setNome(nome);
        setIdade(idade);
        setEndereco(endereco);
    }
    
    public void setNome(String nome) { this.nome = nome; }
    
    public String getNome() { return nome; }
    
    public void setIdade(int idade) { this.idade = idade; }
    
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
