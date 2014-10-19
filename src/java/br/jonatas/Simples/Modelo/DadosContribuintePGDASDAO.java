/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.EventoPeriodoTabelaSimeiBean;
import br.jonatas.Simples.Bean.TabelaEventoSimeiBean;
import br.jonatas.Simples.Bean.eventoSimeiBean;
import br.jonatas.Simples.Bean.periodoSimeiBean;
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
public class DadosContribuintePGDASDAO {
    private Connection connection;

    public DadosContribuintePGDASDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    
    public List<DadosContribuintePGDASDAO> getBuscar(String pa){
        List<DadosContribuintePGDASDAO> dcpgdas = new ArrayList<DadosContribuintePGDASDAO>();
        try {
           /* String SQL = "";
            PreparedStatement ps = null;
            
            SQL = "SELECT DISTINCT "
                        + "     pgdas.cnpj,"
                        + "     pgdas.aliquota"
                        + "     pgdas.razao"
                        + "     dadoscontribuinte.aliquota"
                        + " FROM "
                        + "     pgdas, dadoscontribuinte "
                        + " WHERE "
                        + "     dadoscontribuinte.cnpj NOT IN "
                        + "     (SELECT DISTINCT pgdas.cnpj FROM pgdas WHERE pgdas.pa = ?)"
                        + " AND "
                        + "     pgdas.pa = ?";
                        

                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");
                ps.setString(2, "590");
                
                ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eventoSimeiBean e = new eventoSimeiBean();
                periodoSimeiBean p = new periodoSimeiBean();
                TabelaEventoSimeiBean t = new TabelaEventoSimeiBean();

                e.setCnpj(m.Mascara(pattern, rs.getString("cnpj")));
                e.setDataOcorrencia(m.getData(rs.getString("data_ocorrencia")));
                e.setNaturezaEvento(ato[Integer.parseInt(rs.getString("natureza_evento")) - 1]);
                e.setDataEfeito(m.getData(rs.getString("data_efeito")));

                t.setNome_evento(rs.getString("nome_evento"));
                t.setTipo_evento(rs.getString("tipo_evento").equals("E ") ? "Desenquadrado" : "Ingresso");
                t.setCod_evento(rs.getString("codigo_evento").equals("590") ? "Baixada" : "Ativo");

                EventoPeriodoTabelaSimeiBean aux = new EventoPeriodoTabelaSimeiBean();

                aux.setEvento(e);
                aux.setTabela(t);
                aux.setPeriodo(p);

                eps.add(aux);

            }

            rs.close();
            ps.close();

            return eps;*/
                
        }catch(Exception ex){
             Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDASvsNFS-e", ex.getCause());
        }

    
    return null;
    }   
}
