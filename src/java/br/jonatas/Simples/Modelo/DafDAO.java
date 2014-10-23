/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.Bean.DafBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author issqn
 */
public class DafDAO {
    private Connection connection;

    public DafDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void inserir(DafBean daf) {
        try {
            String SQL = "INSERT INTO daf "
                    + "(cnpj, competencia, numero_guia, vencimento, data_pagamento,"
                    + "valor_original, valor_juros, valor_multa, valor_total, arqdaf_id)"
                    +" values"
                    + "(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, daf.getCnpj());
            ps.setString(2, daf.getCompetencia());
            ps.setString(3, daf.getNumero_guia());
            ps.setDate(4, new java.sql.Date(daf.getVencimento().getTime()));
            ps.setDate(5,new java.sql.Date(daf.getData_pagamento().getTime()));
            ps.setFloat(6, daf.getValor_original());
            ps.setFloat(7, daf.getValor_juros());
            ps.setFloat(8, daf.getValor_multa());
            ps.setFloat(9, daf.getValor_total());
            ps.setString(10, daf.getArqdaf());
            
            

            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String autoIncrement (){
        try {
            String SQL = "SHOW TABLE STATUS LIKE 'daf'";
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("Auto_increment");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
