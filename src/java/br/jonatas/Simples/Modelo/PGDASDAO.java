/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Modelo.ConnectionFactory;
import br.jonatas.Simples.Bean.PGDAS;
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
 * @author issqn
 */
public class PGDASDAO {

    Connection connection;

    public PGDASDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void inserir(PGDAS pgdas) {
        try {
            String SQL = "INSERT INTO pgdas (pa, razao, cnpj, valorpa, valdecsemretencao, "
                    + "valdeccomretencao, valorrecoiss, aliquota, data, operacao) values"
                    + "(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, pgdas.getPa());
            ps.setString(2, pgdas.getRazao());
            ps.setString(3, pgdas.getCnpj());
            ps.setFloat(4, pgdas.getValorpa());
            ps.setFloat(5, pgdas.getValdecsemretencao());
            ps.setFloat(6, pgdas.getValdeccomretencao());
            ps.setFloat(7, pgdas.getValorrecoiss());
            ps.setFloat(8, pgdas.getAliquota());
            ps.setString(9, pgdas.getData());
            ps.setString(10, pgdas.getOperacao());

            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(int id) {
        try {
            String SQL = "DELETE * from pgdas where id= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<PGDAS> listar() {
        List<PGDAS> pg = new ArrayList<PGDAS>();
        try {
            String SQL = "SELECT * FROM pgdas";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PGDAS pgd = new PGDAS();
                pgd.setId(rs.getInt("id"));
                pgd.setPa(rs.getString("pa"));
                pgd.setRazao(rs.getString("razao"));
                pgd.setCnpj(rs.getString("cnpj"));
                pgd.setValorpa(rs.getFloat("valorpa"));
                pgd.setValdecsemretencao(rs.getFloat("valdecsemretencao"));
                pgd.setValdeccomretencao(rs.getFloat("valdeccomretencao"));
                pgd.setValorrecoiss(rs.getFloat("valorrecoiss"));
                pgd.setAliquota(rs.getFloat("aliquota"));
                pgd.setData(rs.getString("data"));
                pg.add(pgd);

            }

            rs.close();
            ps.close();

            return pg;

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDAS", ex.getCause());
        }
    }

    public List<PGDAS> buscaCompetenciaCNPJPA(String pa, String cnpj) {
        List<PGDAS> pg = new ArrayList<PGDAS>();
        try {
            String SQL = "";
            PreparedStatement ps = null;
            
            if (!pa.equals("") && cnpj.equals("")) {
                SQL = "SELECT * FROM pgdas WHERE pa = ? ORDER BY RAZAO, CNPJ ASC    ";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa);
                //ps.setString(2, cnpj);
            }
            
            if (pa.equals("") && !cnpj.equals("")) {
                SQL = "SELECT * FROM pgdas WHERE cnpj = ?";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, cnpj);
                //ps.setString(2, cnpj);
            }
            
            if (!pa.equals("") && !cnpj.equals("")) {
                SQL = "SELECT * FROM pgdas WHERE pa = ? AND cnpj = ?";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa);
                ps.setString(2, cnpj);
            }
            
            if (pa.equals("") && cnpj.equals("")) {
                SQL = "SELECT * FROM pgdas";
                ps = connection.prepareStatement(SQL);
            }
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PGDAS pgd = new PGDAS();
                pgd.setId(rs.getInt("id"));
                pgd.setPa(rs.getString("pa"));
                pgd.setRazao(rs.getString("razao"));
                pgd.setCnpj(rs.getString("cnpj"));
                pgd.setValorpa(rs.getFloat("valorpa"));
                pgd.setValdecsemretencao(rs.getFloat("valdecsemretencao"));
                pgd.setValdeccomretencao(rs.getFloat("valdeccomretencao"));
                pgd.setValorrecoiss(rs.getFloat("valorrecoiss"));
                pgd.setAliquota(rs.getFloat("aliquota"));
                pgd.setOperacao(rs.getString("operacao"));
                pgd.setData(rs.getString("data"));
                pg.add(pgd);

            }

            rs.close();
            ps.close();

            return pg;

        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDAS", ex.getCause());

        }
    }

    public PGDAS buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(PGDAS pgdas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
