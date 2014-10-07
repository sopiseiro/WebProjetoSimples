/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Modelo.ConnectionFactory;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.util.Mascaras;
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

    private Connection connection;

    public PGDASDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public void inserir(PGDASBean pgdas) {
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

    public List<PGDASBean> listar() {
        List<PGDASBean> pg = new ArrayList<PGDASBean>();
        try {
            String SQL = "SELECT * FROM pgdas";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PGDASBean pgd = new PGDASBean();
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

    public List<PGDASBean> buscaCompetenciaCNPJPA(String pa, String cnpj) {
        List<PGDASBean> pg = new ArrayList<PGDASBean>();
        String pattern = "##.###.###/####-##";
        Mascaras m = new Mascaras();
        
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
            
            /*if (pa.equals("") && cnpj.equals("")) {
                SQL = "SELECT * FROM pgdas";
                ps = connection.prepareStatement(SQL);
            }*/
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String paCorreto = rs.getString("pa").substring(4 ,6);
                       paCorreto += "/"+ rs.getString("pa").substring(0 ,4);
                PGDASBean pgd = new PGDASBean();
                pgd.setId(rs.getInt("id"));
                pgd.setPa(paCorreto);
                pgd.setRazao(rs.getString("razao"));
                pgd.setCnpj(m.Mascara(pattern, rs.getString("cnpj")));
                pgd.setValorpa(rs.getFloat("valorpa"));
                pgd.setValdecsemretencao(rs.getFloat("valdecsemretencao"));
                pgd.setValdeccomretencao(rs.getFloat("valdeccomretencao"));
                pgd.setValorrecoiss(rs.getFloat("valorrecoiss"));
                pgd.setAliquota(rs.getFloat("aliquota"));
                pgd.setOperacao(rs.getString("operacao").equals("A")?"Apuração":"Retificação");
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

    public PGDASBean buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(PGDASBean pgdas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
