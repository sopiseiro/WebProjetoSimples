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
public class TabelaEventoSimplesBean {
    
    private String cod_evento, nome_evento, tipo_evento;

    public TabelaEventoSimplesBean() {
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(String cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }
    
    
    
}
