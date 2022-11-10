/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author robson.mariano
 */
public class Usuario {
 
    private int id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;

    public Usuario(){
    }

    public Usuario(String paramNome, String paramLogin, String paramSenha){
        nome_usuario = paramNome;
        login_usuario = paramLogin;
        senha_usuario = paramSenha;
    }

    public int getId() {
        return id_usuario;
    }

    public void setId(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome_usuario;
    }

    public void setNome(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin() {
        return login_usuario;
    }

    public void setLogin(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha() {
        return senha_usuario;
    }

    public void setSenha(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }   
}
