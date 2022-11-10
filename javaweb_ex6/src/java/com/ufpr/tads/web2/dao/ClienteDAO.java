/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ufpr.tads.web2.beans.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robson.mariano
 */
public class ClienteDAO {
    private Connection con = null;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
   
    public boolean insert(Cliente cliente){
        
        String sql = "INSERT into tb_cliente (cpf_cliente, nome_cliente, email_cliente, data_cliente, "
                + "rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getCpf_cliente());
            stmt.setString(2, cliente.getNome_cliente());
            stmt.setString(3, cliente.getEmail_cliente());
            stmt.setString(4, cliente.getData_cliente());
            stmt.setString(5, cliente.getRua_cliente());
            stmt.setInt(6, cliente.getNr_cliente());
            stmt.setString(7, cliente.getCep_cliente());
            stmt.setString(8, cliente.getCidade_cliente());
            stmt.setString(9, cliente.getUf_cliente());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }    
    }
    
    public Cliente select(Cliente cliente){
        String sql = "SELECT * FROM tb_cliente WHERE id_cliente = " + cliente.getId_cliente();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
 
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();            

            while (rs.next()){
              cliente.setId_cliente(rs.getInt("id_cliente"));
              cliente.setCpf_cliente(rs.getString("cpf_cliente"));
              cliente.setNome_cliente(rs.getString("nome_cliente"));
              cliente.setEmail_cliente(rs.getString("email_cliente"));
              cliente.setData_cliente(rs.getString("data_cliente"));
              cliente.setRua_cliente(rs.getString("rua_cliente"));
              cliente.setNr_cliente(rs.getInt("nr_cliente"));
              cliente.setCep_cliente(rs.getString("cep_cliente"));
              cliente.setCidade_cliente(rs.getString("cidade_cliente"));
              cliente.setUf_cliente(rs.getString("uf_cliente"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        return cliente;
    } 
    
    public List<Cliente> selectAll(){

        List<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "SELECT * FROM tb_cliente";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeQuery(sql);
            
            ResultSet rs = stmt.getResultSet();            

            while (rs.next()){
              Cliente cliente = new Cliente();
              cliente.setId_cliente(rs.getInt("id_cliente"));
              cliente.setCpf_cliente(rs.getString("cpf_cliente"));
              cliente.setNome_cliente(rs.getString("nome_cliente"));
              cliente.setEmail_cliente(rs.getString("email_cliente"));
              cliente.setData_cliente(rs.getString("data_cliente"));
              cliente.setRua_cliente(rs.getString("rua_cliente"));
              cliente.setNr_cliente(rs.getInt("nr_cliente"));
              cliente.setCep_cliente(rs.getString("cep_cliente"));
              cliente.setCidade_cliente(rs.getString("cidade_cliente"));
              cliente.setUf_cliente(rs.getString("uf_cliente"));
              
              clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
        
        return clientes;
    } 
    
    public boolean update(Cliente cliente){ 
        String sql = "UPDATE tb_cliente "
                + "SET cpf_cliente = ?, nome_cliente = ?, "
                + "email_cliente = ?, data_cliente = ?, "
                + "rua_cliente = ?, nr_cliente = ?, "
                + "cep_cliente = ?, cidade_cliente = ?, "
                + "uf_cliente = ? "
                + "WHERE id_cliente = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getCpf_cliente());
            stmt.setString(2, cliente.getNome_cliente());
            stmt.setString(3, cliente.getEmail_cliente());
            stmt.setString(4, cliente.getData_cliente());
            stmt.setString(5, cliente.getRua_cliente());
            stmt.setInt(6, cliente.getNr_cliente());
            stmt.setString(7, cliente.getCep_cliente());
            stmt.setString(8, cliente.getCidade_cliente());
            stmt.setString(9, cliente.getUf_cliente());
            stmt.setInt(10, cliente.getId_cliente());
           
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }    
    }
    
    public boolean delete(Cliente cliente){ 
        String sql = "DELETE FROM tb_cliente "
                + "WHERE id_cliente = " + cliente.getId_cliente();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
                       
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }    
    }
}
