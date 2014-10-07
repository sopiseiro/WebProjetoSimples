package br.jonatas.Simples.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author issqn
 */
public class PgdasNFSeBean {
    private PGDASBean pgdas;
    private DadosContribuintesBean dc;

    public PgdasNFSeBean(PGDASBean pgdas, DadosContribuintesBean dc) {
        this.pgdas = pgdas;
        this.dc = dc;
    }

    public PgdasNFSeBean() {
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
