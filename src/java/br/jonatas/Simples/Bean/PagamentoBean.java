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
public class PagamentoBean {
    private DafBean daf;
    private CadastroMunicipal cadmun;

    public PagamentoBean() {

    }

    
    
    public DafBean getDaf() {
        return daf;
    }

    public void setDaf(DafBean daf) {
        this.daf = daf;
    }

    public CadastroMunicipal getCadmun() {
        return cadmun;
    }

    public void setCadmun(CadastroMunicipal cadmun) {
        this.cadmun = cadmun;
    }
    
    
}
