/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Bean;

/**
 *
 * @author issqn
 */
public class EventoPeriodoTabelaSimplesBean {
    
    private eventoSimplesBean evento;
    private periodoSimplesBean periodo;
    private TabelaEventoSimplesBean tabela;

    public TabelaEventoSimplesBean getTabela() {
        return tabela;
    }

    public void setTabela(TabelaEventoSimplesBean tabela) {
        this.tabela = tabela;
    }
    
    public EventoPeriodoTabelaSimplesBean() {
    }

    public eventoSimplesBean getEvento() {
        return evento;
    }

    public void setEvento(eventoSimplesBean evento) {
        this.evento = evento;
    }

    public periodoSimplesBean getPeriodo() {
        return periodo;
    }

    public void setPeriodo(periodoSimplesBean periodo) {
        this.periodo = periodo;
    }
    
    
}
