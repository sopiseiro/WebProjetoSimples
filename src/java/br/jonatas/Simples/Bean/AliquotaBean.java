/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Bean;

/**
 *
 * @author jonatas
 */
public class AliquotaBean {
    private PGDASBean pgdas;
    private DadosContribuintesBean dc;
    
    public AliquotaBean() {
    }

    public PGDASBean getPgdas() {
        return pgdas;
    }

    public void setPgdas(PGDASBean pgdas) {
        this.pgdas = pgdas;
    }

    public DadosContribuintesBean getDc() {
        return dc;
    }

    public void setDc(DadosContribuintesBean dc) {
        this.dc = dc;
    }
    
    
    
}
