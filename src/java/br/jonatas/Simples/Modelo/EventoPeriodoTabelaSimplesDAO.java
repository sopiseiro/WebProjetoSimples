/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Modelo;

import br.jonatas.Simples.Bean.DadosContribuintesBean;
import br.jonatas.Simples.Bean.EventoPeriodoTabelaSimplesBean;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.Bean.PgdasNFSeBean;
import br.jonatas.Simples.Bean.TabelaEventoSimplesBean;
import br.jonatas.Simples.Bean.eventoSimplesBean;
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
public class EventoPeriodoTabelaSimplesDAO {

    private Connection connection;

    public EventoPeriodoTabelaSimplesDAO() {
        connection = ConnectionFactory.getConnection();
    }

    public List<EventoPeriodoTabelaSimplesBean> buscaInconsistencia(String pa, String opc) {

        String ato[] = {"Medida Judicial", "Ato Administrativo", "Opção do Contribuinte"};
        List<EventoPeriodoTabelaSimplesBean> eps = new ArrayList<EventoPeriodoTabelaSimplesBean>();

        String pattern = "##.###.###/####-##";
        Mascaras m = new Mascaras();

        try {

            String SQL = "";
            PreparedStatement ps = null;
            
            if (opc.equals("4")){
                SQL = "SELECT"
                        + "     eventoSimples.cnpj,"
                        + "     eventoSimples.natureza_evento,"
                        + "     eventoSimples.codigo_evento,"
                        + "     eventoSimples.data_efeito,"
                        + "     eventoSimples.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimples "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimples.codigo_evento "
                        + " AND"
                        + "     eventoSimples.data_ocorrencia like ? "
                        + " AND"
                        + "     tabelaEventosSimples.cod_evento <> ? "
                         + " AND"
                        + "     tabelaEventosSimples.cod_evento <> ? "
                         + " AND "
                        + "     tabelaEventosSimples.tipo_evento = ?";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");
                ps.setString(2, "301");
                ps.setString(3, "390");
                ps.setString(4, "E");
            }
            
            if (opc.equals("3")){
                SQL = "SELECT"
                        + "     eventoSimples.cnpj,"
                        + "     eventoSimples.natureza_evento,"
                        + "     eventoSimples.codigo_evento,"
                        + "     eventoSimples.data_efeito,"
                        + "     eventoSimples.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimples "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimples.codigo_evento "
                        + " AND"
                        + "     eventoSimples.data_ocorrencia like ? "
                         + " AND"
                        + "     tabelaEventosSimples.cod_evento <> ? "
                         + " AND "
                        + "     tabelaEventosSimples.tipo_evento = ?";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");
                ps.setString(2, "301");
                ps.setString(3, "I");
            }
            
            if (opc.equals("2")){
                SQL = "SELECT"
                        + "     eventoSimples.cnpj,"
                        + "     eventoSimples.natureza_evento,"
                        + "     eventoSimples.codigo_evento,"
                        + "     eventoSimples.data_efeito,"
                        + "     eventoSimples.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimples "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimples.codigo_evento "
                        + " AND"
                        + "     eventoSimples.data_ocorrencia like ? "
                         + " AND"
                        + "     tabelaEventosSimples.cod_evento <> ? "
                        + " AND"
                        + "     tabelaEventosSimples.cod_evento = ?";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, pa + "%");
                ps.setString(2, "301");
                ps.setString(3, "390");
            }

            if (opc.equals("1")) {
                SQL = "SELECT"
                        + "     eventoSimples.cnpj,"
                        + "     eventoSimples.natureza_evento,"
                        + "     eventoSimples.codigo_evento,"
                        + "     eventoSimples.data_efeito,"
                        + "     eventoSimples.data_ocorrencia, "
                        + "     tabelaEventosSimples.nome_evento,"
                        + "     tabelaEventosSimples.tipo_evento"
                        + " FROM "
                        + "     tabelaEventosSimples, eventoSimples "
                        + " WHERE "
                        + "     tabelaEventosSimples.cod_evento = eventoSimples.codigo_evento "
                        + " AND"
                        + "     tabelaEventosSimples.cod_evento <> ? "
                       
                        + " AND"
                        + "     eventoSimples.data_ocorrencia like ? ";
                ps = connection.prepareStatement(SQL);
                ps.setString(1, "301");
                ps.setString(2, pa + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                eventoSimplesBean e = new eventoSimplesBean();
                periodoSimplesBean p = new periodoSimplesBean();
                TabelaEventoSimplesBean t = new TabelaEventoSimplesBean();

                e.setCnpj(m.Mascara(pattern, rs.getString("cnpj")));
                e.setDataOcorrencia(m.getData(rs.getString("data_ocorrencia")));
                e.setNaturezaEvento(ato[Integer.parseInt(rs.getString("natureza_evento")) - 1]);
                e.setDataEfeito(m.getData(rs.getString("data_efeito")));

                t.setNome_evento(rs.getString("nome_evento"));
                t.setTipo_evento(rs.getString("tipo_evento").equals("E ") ? "Desenquadrado" : "Ingresso");
                t.setCod_evento(rs.getString("codigo_evento").equals("390") ? "Baixada" : "Ativo");

                EventoPeriodoTabelaSimplesBean aux = new EventoPeriodoTabelaSimplesBean();

                aux.setEvento(e);
                aux.setTabela(t);

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
