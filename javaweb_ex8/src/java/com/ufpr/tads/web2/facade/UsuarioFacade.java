/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.facade;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import exceptions.UsuarioException;
import java.sql.Connection;
import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.dao.UsuarioDAO;

public class UsuarioFacade {
    public static Usuario buscar(int id) throws UsuarioException {
        Usuario usuario;
        try (Connection con = new ConnectionFactory().getConnection()) {
            UsuarioDAO dao = new UsuarioDAO(con);
            usuario = dao.buscar(id);
        } catch (Exception e) {
            throw new UsuarioException("Erro buscando usuário");
        }
        return usuario;
    }
}
