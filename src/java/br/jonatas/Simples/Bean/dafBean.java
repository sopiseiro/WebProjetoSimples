/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Bean;

import java.util.Date;

/**
 *
 * @author issqn
 */
public class dafBean {
    private int id;
    private String cnpj;
    private String competencia;
    private String numero_guia;
    private Date vencimento;
    private Date data_pagamento;
    private Float valor_original;
    private Float valor_juros;
    private Float valor_multa;

    public String getArqdaf() {
        return arqdaf;
    }

    public void setArqdaf(String arqdaf) {
        this.arqdaf = arqdaf;
    }
    private Float valor_total;
    private String arqdaf;

    public dafBean() {
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

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getNumero_guia() {
        return numero_guia;
    }

    public void setNumero_guia(String numero_guia) {
        this.numero_guia = numero_guia;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Float getValor_original() {
        return valor_original;
    }

    public void setValor_original(Float valor_original) {
        this.valor_original = valor_original;
    }

    public Float getValor_juros() {
        return valor_juros;
    }

    public void setValor_juros(Float valor_juros) {
        this.valor_juros = valor_juros;
    }

    public Float getValor_multa() {
        return valor_multa;
    }

    public void setValor_multa(Float valor_multa) {
        this.valor_multa = valor_multa;
    }

    public Float getValor_total() {
        return valor_total;
    }

    public void setValor_total(Float valor_total) {
        this.valor_total = valor_total;
    }

    public void getData_pagamento(Date formataData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
