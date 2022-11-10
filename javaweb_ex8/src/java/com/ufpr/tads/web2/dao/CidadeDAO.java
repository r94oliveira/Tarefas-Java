/*
É a classe DAO de acesso do usuário ao banco de dados para manipular os dados de cidades.
 */

package com.ufpr.tads.web2.dao;
import com.ufpr.tads.web2.beans.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    private Connection con = null;

    //construtor
    public CidadeDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public Cidade select(int id){
        //seleciona todos os campos do banco de dados
        String sql = "SELECT * FROM tb_cidade WHERE id_cidade = " + id;
        Cidade cidade = new Cidade();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);            
            
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();            
            //verifica se tem algum resultado na query executada
            /* Enquanto tiver (while): preenche os atributos do objeto de acordo 
            com a linha da Tabela (ResultSet) do Banco de Dados. */
            while (rs.next()){
              cidade.setId_cidade(rs.getInt("id_cidade"));   
              cidade.setNome_cidade(rs.getString("nome_cidade"));
              cidade.setId_estado(rs.getInt("id_estado"));
            }
        } catch (SQLException erro) {
            System.err.println("Erro: " + erro);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        //retorna o objeto cidade
        return cidade;
    } 
    public List<Cidade> selectAll(){
        //cria lista de cidades
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "SELECT * FROM tb_cidade";
        
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
              Cidade cidade = new Cidade();
              cidade.setId_cidade(rs.getInt("id_cidade"));   
              cidade.setNome_cidade(rs.getString("nome_cidade"));
              cidade.setId_estado(rs.getInt("id_estado"));
              
              cidades.add(cidade);
            }
        } catch (SQLException erro) {
            System.err.println("Erro: " + erro);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        //retorna a lista criada de clientes
        return cidades;
    } 
    
    public List<Cidade> selectCidadesFromEstado(String id){
        //cria lista de cidades
        List<Cidade> cidades = new ArrayList<Cidade>();
        //retorna a lista de cidades de um estado
        String sql = "SELECT * FROM tb_cidade WHERE id_estado = " + id;
        
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
              Cidade cidade = new Cidade();
              cidade.setId_cidade(rs.getInt("id_cidade"));   
              cidade.setNome_cidade(rs.getString("nome_cidade"));
              cidade.setId_estado(rs.getInt("id_estado"));
              
              cidades.add(cidade);
            }
        } catch (SQLException erro) {
            System.err.println("Erro: " + erro);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        //retorna a lista criada de clientes
        return cidades;
    } 
}
