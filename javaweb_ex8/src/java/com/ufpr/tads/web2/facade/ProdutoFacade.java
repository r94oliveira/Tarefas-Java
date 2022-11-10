/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.web2.facade;

import java.sql.Connection;
import java.util.List;
import com.ufpr.tads.web2.dao.ConnectionFactory;
import exceptions.ProdutoException;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.dao.ProdutoDAO;

public class ProdutoFacade {
    public static Produto buscar(int id) throws ProdutoException {
        Produto produto;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            produto = dao.buscar(id);
        } catch (Exception e) {
            throw new ProdutoException("Erro buscando produto");
        }
        return produto;
    }

    public static List<Produto> buscarTodos() throws ProdutoException {
        List<Produto> produtos;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            produtos = dao.buscarTodos();
        } catch (Exception e) {
            throw new ProdutoException("Erro buscando todos os produtos");
        }
        return produtos;
    }
}
