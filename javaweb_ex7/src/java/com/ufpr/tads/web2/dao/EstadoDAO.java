/*
É a classe DAO de acesso do usuário ao banco de dados para manipular os dados de estados.
 */
package com.ufpr.tads.web2.dao;
import com.ufpr.tads.web2.beans.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    private Connection con = null;

    //construtor
    public EstadoDAO(){
        con = ConnectionFactory.getConnection();
    }
    public Estado select(int id){
        //seleciona todos os campos do banco de dados
        String sql = "SELECT * FROM tb_estado WHERE id_estado = " + id;
        Estado estado = new Estado();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);            
            
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();            
            //verifica se tem algum resultado na query executada
            /* Enquanto tiver (while): preenche os atributos do objeto de acordo 
            com a linha da Tabela (ResultSet) do Banco de Dados. */
            while (rs.next()){
              estado.setId_estado(rs.getInt("id_estado"));   
              estado.setNome_estado(rs.getString("nome_estado"));
              estado.setSigla_estado(rs.getString("sigla_estado"));
            }
        } catch (SQLException erro) {
            System.err.println("Erro: " + erro);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        //retorna o objeto estado
        return estado;
    } 
    public List<Estado> selectAll(){
        //cria lista de cidades
        List<Estado> estados = new ArrayList<Estado>();
        String sql = "SELECT * FROM tb_estado";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();            
            //verifica se tem algum resultado na query executada
            /* Enquanto tiver (while): cria novo objeto (do tipo Cidade) e preenche os 
            atributos do objeto de acordo com cada linha da Tabela (ResultSet) do Banco 
            de Dados. Depois adiciona este objeto na lista de Cidades */
            while (rs.next()){
              Estado estado = new Estado();
              
              estado.setId_estado(rs.getInt("id_estado"));   
              estado.setNome_estado(rs.getString("nome_estado"));
              estado.setSigla_estado(rs.getString("sigla_estado"));
                            
              estados.add(estado);
            }
        } catch (SQLException erro) {
            System.err.println("Erro: " + erro);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        //retorna a lista criada de estados
        return estados;
    } 
}
   
