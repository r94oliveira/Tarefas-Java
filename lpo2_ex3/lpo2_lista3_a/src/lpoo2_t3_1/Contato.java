package lpoo2_t3_1;

import java.util.Date;

public final class Contato {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private Date dataNasc;
    
    public Contato(){}
    
    public Contato(String nome, String email, String endereco, Date dataNasc){
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
        setDataNasc(dataNasc);
    }
    
    public Contato(int id, String nome, String email, String endereco, Date dataNasc){
        setId(id);
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
        setDataNasc(dataNasc);
    }
    
    //Setters
    public void setId(int id) throws RuntimeException{ 
        if (id > 0) this.id = id;
        else throw new RuntimeException("Id inválido!");
    }
    
    public void setNome(String nome) throws RuntimeException{ 
        if (nome != null && !nome.equals("")) this.nome = nome; 
        else throw new RuntimeException("Nome não pode estar vazio!");
    }
    
    public void setEmail(String email) throws RuntimeException{ 
        if (email != null && !email.equals("")) this.email = email; 
        else throw new RuntimeException("Email não pode estar vazio!");
    }
    
    public void setEndereco(String endereco) throws RuntimeException{ 
        if (endereco != null && !endereco.equals("")) this.endereco = endereco; 
        else throw new RuntimeException("Endereco não pode ser vazio!");
    }
    
    public void setDataNasc(Date dataNasc) throws RuntimeException{ 
        if (dataNasc != null && dataNasc.getTime() != new Date().getTime()) this.dataNasc = dataNasc;
        else throw new RuntimeException("Data inválida!");
    }
    
    //Getters
    public int getId(){ return this.id; }
    public String getNome(){ return this.nome; }
    public String getEmail(){ return this.email; }
    public String getEndereco(){ return this.endereco; }
    public Date getDataNasc(){ return this.dataNasc; }
    
    @Override
    public String toString(){
        return "\n Id: " + this.getId() + "\n Nome: " + this.getNome() + "\n Email: " + this.getEmail() + "\n Endereço: " 
                + this.getEndereco() + "\n Data de Nascimento: " + this.getDataNasc().toString();
    }
}
