
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ufpr.tads.web2.beans.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//CRUD
public class UsuarioDAO {
    private Connection con = null;

    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }
   
    //insere no Banco de Dados (insert)
    public boolean save(Usuario usuario){
        
        String sql = "INSERT into tb_usuario (login_usuario, senha_usuario, nome_usuario) "
                + "VALUES ('" + usuario.getLogin_usuario() + "', '" + usuario.getSenha_usuario() + "', '"+ usuario.getNome_usuario() + "')";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);

            //executa o sql
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }    
    }
    
    public Usuario selectUser(Usuario user){
        String sql = "SELECT * FROM tb_usuario WHERE login_usuario = '" + user.getLogin_usuario() 
            + "' and senha_usuario = '" + user.getSenha_usuario() + "'";
        
        //PreparedStatement prepara a query do BD
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
              //query BD
              user.setId_usuario(rs.getInt("id_usuario"));  
              user.setLogin_usuario(rs.getString("login_usuario"));
              user.setSenha_usuario(rs.getString("senha_usuario"));
              user.setNome_usuario(rs.getString("nome_usuario"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }  
        //retorna um objeto Usuário com todos os atributos preenchidos 
        //se ele existir no banco
        return user;
    }
    
    public List<Usuario> selectAll(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM tb_usuario";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();            
            //verifica se tem algum resultado na query executada
            /* Enquanto tiver (while): cria novo objeto (do tipo Usuario) e preenche os 
            atributos do objeto de acordo com cada linha da Tabela (ResultSet) do Banco 
            de Dados. Depois adiciona este objeto na lista de usuários */
            while (rs.next()){
              Usuario user = new Usuario();
              user.setId_usuario(rs.getInt("id_usuario"));
              user.setLogin_usuario(rs.getString("login_usuario"));
              user.setSenha_usuario(rs.getString("senha_usuario"));
              user.setNome_usuario(rs.getString("nome_usuario"));
              
              usuarios.add(user);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        return usuarios;
    }
}