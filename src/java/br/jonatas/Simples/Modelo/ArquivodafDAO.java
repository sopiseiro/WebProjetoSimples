/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.ArquivodafBean;
import br.jonatas.Simples.Bean.PGDASBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author issqn
 */
public class ArquivodafDAO {
    private Connection connection;

    public ArquivodafDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void inserir(ArquivodafBean arqdaf) {
        try {
            String SQL = "INSERT INTO arqdaf (arquivo, data, data_pagamento)"
                    + " values"
                    + "(?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, arqdaf.getArquivo());
            ps.setDate(2, new java.sql.Date( arqdaf.getData().getTime() ));
            ps.setDate(3, new java.sql.Date( arqdaf.getData_pagamento().getTime() ));


            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String autoIncrement (){
        try {
            String SQL = "SHOW TABLE STATUS LIKE 'arqdaf'";
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            String resultado = "";
            while (rs.next()) {
                resultado =  rs.getString("Auto_increment");
            }
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(DafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "teste";
    }
    
    public List<ArquivodafBean> buscar(ArquivodafBean a){
        try {
            String SQL = "SELECT * FROM arqdaf WHERE arquivo = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, a.getArquivo());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivodafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              return null;  
    }
    
    public boolean localizar(ArquivodafBean a){
        try {
            String SQL = "SELECT * FROM arqdaf WHERE arquivo = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, a.getArquivo());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return true;

            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivodafDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
