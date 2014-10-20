/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.AliquotaBean;
import br.jonatas.Simples.Bean.DadosContribuintesBean;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.util.Mascaras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatas
 */
public class AliquotaDAO {
   
    private Connection connection;

    public AliquotaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public List<AliquotaBean> getAliquotasMenores(String pa){
        List<AliquotaBean> aliquota = new ArrayList<AliquotaBean>();
        Mascaras m = new Mascaras();
        
        try {
            
            String SQL = "";
            PreparedStatement ps = null;
            
            SQL = "SELECT DISTINCT"
                    + "     pgdas.pa,"
                    + "     pgdas.cnpj,"
                    + "     pgdas.aliquota,"
                    + "     pgdas.razao,"
                    + "     pgdas.valdeccomretencao,"
                    + "     dadoscontribuinte.aliquota as dcaliquota"
                    + " FROM     "
                    + "     pgdas, dadoscontribuinte "
                    + " WHERE"
                    + "     pgdas.aliquota <> 0"
                    + " AND"
                    + "     pgdas.aliquota <> 2"
                    + " AND"
                    + "     pgdas.cnpj = dadoscontribuinte.cnpj"
                    + " AND"
                    + "     dadoscontribuinte.valorretido > 0"
                    + " AND"
                    + "     dadoscontribuinte.aliquota < pgdas.aliquota"
                    + " AND "
                    + "     pgdas.pa = ?"
                    + " AND "
                    + "     dadoscontribuinte.pa = ?";
            
            ps = connection.prepareStatement(SQL);
            ps.setString(1, pa);
            ps.setString(2, pa);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PGDASBean pg = new PGDASBean();
                DadosContribuintesBean dc = new DadosContribuintesBean();
                
                pg.setCnpj(m.getCnpjFormatado(rs.getString("cnpj")));
                pg.setRazao(rs.getString("razao"));
                pg.setPa(m.getCompetencia(rs.getString("pa")));
                pg.setAliquota(rs.getFloat("aliquota"));
                pg.setValdeccomretencao(rs.getFloat("valdeccomretencao"));
                
                dc.setAliquota(rs.getFloat("dcaliquota"));
                
                AliquotaBean aux = new AliquotaBean();
                aux.setDc(dc);
                aux.setPgdas(pg);
                
                aliquota.add(aux);
            }
                    
            return aliquota;
            
            
        }catch(Exception ex){
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.ALL.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDASvsNFS-e", ex.getCause());
        }

    }
    
    
}
