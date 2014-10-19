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
public class DadosContribuintePGDASBean {
    
    private DadosContribuintesBean dadoscontribuinte;
    private PGDASBean pgdas;

    public DadosContribuintePGDASBean() {
    }

    public DadosContribuintesBean getDadoscontribuinte() {
        return dadoscontribuinte;
    }

    public void setDadoscontribuinte(DadosContribuintesBean dadoscontribuinte) {
        this.dadoscontribuinte = dadoscontribuinte;
    }

    public PGDASBean getPgdas() {
        return pgdas;
    }

    public void setPgdas(PGDASBean pgdas) {
        this.pgdas = pgdas;
    }
     
    
}
