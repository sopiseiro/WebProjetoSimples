/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.DadosContribuintesBean;
import br.jonatas.Simples.Bean.EventoPeriodoTabelaSimeiBean;
import br.jonatas.Simples.Bean.EventoPeriodoTabelaSimplesBean;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.Bean.PgdasNFSeBean;
import br.jonatas.Simples.Bean.TabelaEventoSimeiBean;
import br.jonatas.Simples.Bean.TabelaEventoSimplesBean;
import br.jonatas.Simples.Bean.eventoSimeiBean;
import br.jonatas.Simples.Bean.periodoSimeiBean;
import br.jonatas.Simples.Bean.periodoSimplesBean;
import br.jonatas.Simples.util.Mascaras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author issqn
 */
public class EventoPeriodoTabelaSimeiDAO {

    private Connection connection;

    public EventoPeriodoTabelaSimeiDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public List<EventoPeriodoTabelaSimeiBean> buscaInconsistencia(String pa, String opc) {

        String ato[] = {"Medida Judicial", "Ato Administrativo", "Opção do Contribuinte"};
        List<EventoPeriodoTabelaSimeiBean> eps = new ArrayList<EventoPeriodoTabelaSimeiBean>();

        String pattern = "##.###.###/####-##";
        Mascaras m = new Mascaras();

        try {

            String SQL = "";
            PreparedStatement ps = null;

            if (opc.equals("2")) {
                SQL = "SELECT"
                        + "     eventoSimei.cnpj,"
                        + "     eventoSimei.natureza_evento,"
                        + "     eventoSimei.codigo_evento,"
                        + "     eventoSimei.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento,"
                        + "     eventoSimei.data_efeito"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimei, periodoSimei "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimei.codigo_evento "
                        + " AND"
                        + "     eventoSimei.data_ocorrencia like ?"
                        + " AND"
                        + "     tabelaEventosSimples.cod_evento = '590'";

                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");
                

            }

            if (opc.equals("3")) {
                SQL = "SELECT"
                        + "     eventoSimei.cnpj,"
                        + "     eventoSimei.natureza_evento,"
                        + "     eventoSimei.codigo_evento,"
                        + "     eventoSimei.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento,"
                        + "     eventoSimei.data_efeito"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimei, periodoSimei "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimei.codigo_evento "
                        + " AND"
                        + "     eventoSimei.data_ocorrencia like ? "
                        + " AND "
                        + "     tabelaEventosSimples.tipo_evento = 'I'";

                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");

            }

            if (opc.equals("4")) {
                SQL = "SELECT"
                        + "     eventoSimei.cnpj,"
                        + "     eventoSimei.natureza_evento,"
                        + "     eventoSimei.codigo_evento,"
                        + "     eventoSimei.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento,"
                        + "     eventoSimei.data_efeito"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimei, periodoSimei "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimei.codigo_evento "
                        + " AND"
                        + "     eventoSimei.data_ocorrencia like ? "
                        + " AND"
                        + "     tabelaEventosSimples.tipo_evento = 'E'";

                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");

            }
            
            if (opc.equals("1")) {

                SQL = "SELECT"
                        + "     eventoSimei.cnpj,"
                        + "     eventoSimei.natureza_evento,"
                        + "     eventoSimei.codigo_evento,"
                        + "     eventoSimei.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento,"
                        + "     eventoSimei.data_efeito"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimei, periodoSimei "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimei.codigo_evento "
                        + "     AND"
                        + "     eventoSimei.data_ocorrencia like ? ";

                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");

            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eventoSimeiBean e = new eventoSimeiBean();
                periodoSimeiBean p = new periodoSimeiBean();
                TabelaEventoSimeiBean t = new TabelaEventoSimeiBean();

                e.setCnpj(m.Mascara(pattern, rs.getString("cnpj")));
                e.setDataOcorrencia(m.getData(rs.getString("data_ocorrencia")));
                e.setNaturezaEvento(ato[Integer.parseInt(rs.getString("natureza_evento")) - 1]);
                e.setDataEfeito(rs.getString("data_efeito"));

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

            return eps;

        } catch (Exception ex) {
            Logger.getLogger(PGDASDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao listar PGDASvsNFS-e", ex.getCause());

        }
    }

}
