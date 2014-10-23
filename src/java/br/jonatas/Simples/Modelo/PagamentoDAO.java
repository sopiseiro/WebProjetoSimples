/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.PagamentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatas
 */
public class PagamentoDAO {

    private Connection connection;

    public PagamentoDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public List<PagamentoBean> getPagamentosBuscar(String pa, String cnpj, String regime, String semreco) {
        try {
            List<PagamentoBean> pag = new ArrayList<>();
            String SQL = "";
            PreparedStatement ps = null;

            if (semreco != null) {
                SQL = "SELECT ";

                ps = connection.prepareStatement(SQL);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
