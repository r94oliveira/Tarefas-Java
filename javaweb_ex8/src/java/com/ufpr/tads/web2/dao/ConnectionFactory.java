/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//CLASSE DE CONEXÃO COM O BANCO DE DADOS

package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";   
    //nome do banco de dados que será utilizado
    private static final String URL = "jdbc:mysql://localhost:3306/web2?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";     
    private static final String USER = "root";     
    private static final String PASS = "root";     
    
    //Classe de Conexão
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: " + ex.getMessage(), ex);
        }
    }
    //fechar a coneção
    public static void CloseConnection(Connection con) {
        
        //verifica se a coneção está aberta ou não
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                //imprime em vermelho o erro/exceção
                System.err.println("Erro: "+ex);
            }
        }
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt) {
        
        //verifica se a coneção está aberta ou não, fecha statement e connection
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
            }
        }
        CloseConnection(con);
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
       
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
            }
        }
        //sobrecarga do método, fecha con e stmt
        CloseConnection(con, stmt);
    }
}
