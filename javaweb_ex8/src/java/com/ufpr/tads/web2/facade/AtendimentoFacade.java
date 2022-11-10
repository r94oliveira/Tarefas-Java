/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.dao.ConnectionFactory;
import com.ufpr.tads.web2.dao.DAOException;
import exceptions.AtendimentoException;
import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AtendimentoFacade {
    public static void inserir(Atendimento a) throws AtendimentoException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            dao.inserir(a);
        } catch (Exception e) {
            throw new AtendimentoException("Erro inserindo atendimento");
        }
    }
    
    public static Atendimento buscar(int id) throws AtendimentoException {
        Atendimento atendimento;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimento = dao.buscar(id);
        } catch (Exception e) {
            throw new AtendimentoException("Erro inserindo atendimento");
        }
        return atendimento;
    }
    
    public static List<Atendimento> buscarTodos(int id) throws AtendimentoException {
        List<Atendimento> atendimentos;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimentos = dao.buscarTodos(id);
        } catch (Exception e) {
            throw new AtendimentoException("Erro inserindo atendimento");
        }
        return atendimentos;
    }
}
