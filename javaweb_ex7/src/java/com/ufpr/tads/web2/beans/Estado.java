/*
Um Java Bean que contém os dados da tabela tb_estado. 
Este bean deve ser usado juntamente com as classes DAO para acessar o banco de dados.
 */
package com.ufpr.tads.web2.beans;

public class Estado {
    private int id_estado;
    private String nome_estado;
    private String sigla_estado; 
    
    public Estado() {
    }

    public Estado(int id_estado, String nome_estado, String sigla_estado) {
        this.id_estado = id_estado;
        this.nome_estado = nome_estado;
        this.sigla_estado = sigla_estado;
    }
    
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    public String getSigla_estado() {
        return sigla_estado;
    }

    public void setSigla_estado(String sigla_estado) {
        this.sigla_estado = sigla_estado;
    } 
}
