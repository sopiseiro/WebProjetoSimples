 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 SQL =  "SELECT" 
 + " pgdas.pa, pgdas.razao, pgdas.CNPJ, pgdas.VALORPA, pgdas.VALDECSEMRETENCAO, pgdas.VALDECCOMRETENCAO, pgdas.ALIQUOTA,"
 + "	dadoscontribuinte.PA, dadoscontribuinte.CNPJ, dadoscontribuinte.VALORRETIDO, dadoscontribuinte.VALORSEMRETENCAO,"
 + "	(pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) AS DIFERENCASEMRETENCAO,"
 + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) AS DIFERENCACOMRETENCAO"
 + " FROM pgdas, dadoscontribuinte"
 + " WHERE"
 + "	pgdas.PA = ? AND"
 + "	pgdas.PA = dadoscontribuinte.PA AND"
 + "	pgdas.CNPJ = dadoscontribuinte.CNPJ AND"
 + "	((pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) <> 0 OR"
 + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) <> 0 )"
 + " GROUP BY pgdas.CNPJ"
 + " ORDER BY pgdas.RAZAO".toLowerCase();

 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.DadosContribuintesBean;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.Bean.PgdasNFSeBean;
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
public class PgdasNFSEDAO {

    private Connection connection;

    public PgdasNFSEDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public List<PgdasNFSeBean> buscaInconsistencia(String pa, String cnpj, String only) {
        List<PgdasNFSeBean> pgnf = new ArrayList<PgdasNFSeBean>();
        String pattern = "##.###.###/####-##";
        Mascaras m = new Mascaras();

        try {
            String SQL = "";
            PreparedStatement ps = null;

            if (!pa.equals("") && cnpj.equals("") && only == null) {
                SQL = "SELECT"
                        + " pgdas.pa, pgdas.razao, pgdas.CNPJ, pgdas.VALORPA, pgdas.VALDECSEMRETENCAO, pgdas.VALDECCOMRETENCAO, pgdas.ALIQUOTA,"
                        + "	dadoscontribuinte.PA, dadoscontribuinte.CNPJ, dadoscontribuinte.VALORRETIDO, dadoscontribuinte.VALORSEMRETENCAO,"
                        + "	(pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) AS DIFERENCASEMRETENCAO,"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) AS DIFERENCACOMRETENCAO"
                        + " FROM pgdas, dadoscontribuinte"
                        + " WHERE"
                        + "	pgdas.PA = ? AND"
                        + "	pgdas.PA = dadoscontribuinte.PA AND"
                        + "	pgdas.CNPJ = dadoscontribuinte.CNPJ"
                        + " ORDER BY pgdas.RAZAO".toLowerCase();
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa);
            }

            if (pa.equals("") && !cnpj.equals("") && only == null) {
                SQL = "SELECT"
                        + " pgdas.pa, pgdas.razao, pgdas.CNPJ, pgdas.VALORPA, pgdas.VALDECSEMRETENCAO, pgdas.VALDECCOMRETENCAO, pgdas.ALIQUOTA,"
                        + "	dadoscontribuinte.PA, dadoscontribuinte.CNPJ, dadoscontribuinte.VALORRETIDO, dadoscontribuinte.VALORSEMRETENCAO,"
                        + "	(pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) AS DIFERENCASEMRETENCAO,"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) AS DIFERENCACOMRETENCAO"
                        + " FROM pgdas, dadoscontribuinte"
                        + " WHERE"
                        + "	pgdas.PA = dadoscontribuinte.PA AND"
                        + "	pgdas.CNPJ = ? AND "
                        + "     pgdas.CNPJ = dadoscontribuinte.CNPJ AND"
                        + "	((pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) <> 0 OR"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) <> 0 )"
                        + " ORDER BY pgdas.RAZAO".toLowerCase();
                ps = connection.prepareStatement(SQL);
                ps.setString(1, cnpj);
            }

            if (!pa.equals("") && !cnpj.equals("") && only == null) {
                SQL = "SELECT"
                        + " pgdas.pa, pgdas.razao, pgdas.CNPJ, pgdas.VALORPA, pgdas.VALDECSEMRETENCAO, pgdas.VALDECCOMRETENCAO, pgdas.ALIQUOTA,"
                        + "	dadoscontribuinte.PA, dadoscontribuinte.CNPJ, dadoscontribuinte.VALORRETIDO, dadoscontribuinte.VALORSEMRETENCAO,"
                        + "	(pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) AS DIFERENCASEMRETENCAO,"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) AS DIFERENCACOMRETENCAO"
                        + " FROM pgdas, dadoscontribuinte"
                        + " WHERE"
                        + "	pgdas.PA = ? AND"
                        + "	pgdas.PA = dadoscontribuinte.PA AND"
                        + "	pgdas.CNPJ = ? AND"
                        + "	((pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) <> 0 OR"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) <> 0 )"
                        + " GROUP BY pgdas.CNPJ"
                        + " ORDER BY pgdas.RAZAO".toLowerCase();
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa);
                ps.setString(2, cnpj);
            }
            
            int i = 0;
            if (only != null) {
                SQL = "SELECT"
                        + " pgdas.pa, pgdas.razao, pgdas.CNPJ, pgdas.VALORPA, pgdas.VALDECSEMRETENCAO, pgdas.VALDECCOMRETENCAO, pgdas.ALIQUOTA,"
                        + "	dadoscontribuinte.PA, dadoscontribuinte.CNPJ, dadoscontribuinte.VALORRETIDO, dadoscontribuinte.VALORSEMRETENCAO,"
                        + "	(pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) AS DIFERENCASEMRETENCAO,"
                        + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) AS DIFERENCACOMRETENCAO"
                        + " FROM pgdas, dadoscontribuinte"
                        + " WHERE";
                if (!pa.equals(""))
                    SQL += "	pgdas.PA = ? AND";
                

                SQL += "	pgdas.PA = dadoscontribuinte.PA AND";
                
                if (!cnpj.equals("")) 
                    SQL += "	pgdas.CNPJ = ? AND";
                
                SQL += "	pgdas.CNPJ = dadoscontribuinte.cnpj AND";
                    
                SQL  += "	((pgdas.VALDECSEMRETENCAO - dadoscontribuinte.VALORSEMRETENCAO) <> 0 OR"
                            + "	(pgdas.VALDECCOMRETENCAO - dadoscontribuinte.VALORRETIDO) <> 0 )"
                            + " ORDER BY pgdas.RAZAO ".toLowerCase();
                
                System.out.println(SQL);
                ps = connection.prepareStatement(SQL);
                if (!pa.equals("")) {
                    ps.setString(++i, pa);
                }
                if (!cnpj.equals("")) {
                    ps.setString(++i, cnpj);
                }
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PGDASBean pgdas = new PGDASBean();
                DadosContribuintesBean dadoscontrib = new DadosContribuintesBean();

                pgdas.setPa(m.getCompetencia(rs.getString("pa")));
                pgdas.setCnpj(m.Mascara(pattern, rs.getString("cnpj")));
                pgdas.setRazao(rs.getString("razao"));
                pgdas.setValdecsemretencao(rs.getFloat("valdecsemretencao"));
                pgdas.setValdeccomretencao(rs.getFloat("valdeccomretencao"));

                dadoscontrib.setValorretido(rs.getFloat("valorretido"));
                dadoscontrib.setValorsemretencao(rs.getFloat("valorsemretencao"));
               //dadoscontrib

                PgdasNFSeBean aux = new PgdasNFSeBean();

                aux.setDc(dadoscontrib);
                aux.setPgdas(pgdas);

                pgnf.add(aux);

            }

            rs.close();
            ps.close();

            return pgnf;

        } catch (SQLException ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDASvsNFS-e", ex.getCause());

        }
    }

}
