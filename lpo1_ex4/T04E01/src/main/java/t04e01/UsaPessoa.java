package t04e01;

public class UsaPessoa {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        
        p.nome = "Maria da Silva";
        p.idade = 18;
        p.endereco = "Rua Carlos Pradi, 382, Curitiba";
        
        p.imprime();
        
        p.fazAniversario();
        p.fazAniversario();
        p.fazAniversario();
        
        System.out.println("=============");
        
        p.imprime();
    }
    
}
