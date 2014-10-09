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
public class EventoPeriodoTabelaSimeiBean {
    
    private eventoSimeiBean evento;
    private periodoSimeiBean periodo;

    public EventoPeriodoTabelaSimeiBean() {
    }

    public eventoSimeiBean getEvento() {
        return evento;
    }

    public void setEvento(eventoSimeiBean evento) {
        this.evento = evento;
    }

    public periodoSimeiBean getPeriodo() {
        return periodo;
    }

    public void setPeriodo(periodoSimeiBean periodo) {
        this.periodo = periodo;
    }
    
    
}
