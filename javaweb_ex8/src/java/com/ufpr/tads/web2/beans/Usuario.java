
package com.ufpr.tads.web2.beans;

public class Usuario {

    //atributos encapsulados
    private int id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;
    
    //Construtor Vazio
    public Usuario(){
    }
    
    //Um construtor que recebe todos os atributos e os preenche
    public Usuario(int paramId, String paramNome, String paramLogin, String paramSenha){
        id_usuario = paramId;
        nome_usuario = paramNome;
        login_usuario = paramLogin;
        senha_usuario = paramSenha;
    }

    //métodos Get and Set que acessam os atributos encapsulados
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
}
