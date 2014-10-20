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
public class periodoSimplesBean {
    
    private int id;
    private String cnpj, dataInicio, dataFim, identificadorCancelamento, numeroOpcao;

    public periodoSimplesBean() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getIdentificadorCancelamento() {
        return identificadorCancelamento;
    }

    public void setIdentificadorCancelamento(String identificadorCancelamento) {
        this.identificadorCancelamento = identificadorCancelamento;
    }

    public String getNumeroOpcao() {
        return numeroOpcao;
    }

    public void setNumeroOpcao(String numeroOpcao) {
        this.numeroOpcao = numeroOpcao;
    }
    
    
    
}
