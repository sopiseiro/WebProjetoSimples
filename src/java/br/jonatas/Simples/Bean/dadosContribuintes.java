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
public class dadosContribuintes {

    private int id;
    private String pa;
    private String cnpj;
    private Float valorretido;
    private Float valorsemretencao;
    private Float aliquota;

    public dadosContribuintes() {
        this.id = 0;
        this.pa = "";
        this.cnpj = "";
        this.valorretido = new Float(0);
        this.valorsemretencao = new Float(0);
        this.aliquota = new Float(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Float getValorretido() {
        return valorretido;
    }

    public void setValorretido(Float valorretido) {
        this.valorretido = valorretido;
    }

    public Float getValorsemretencao() {
        return valorsemretencao;
    }

    public void setValorsemretencao(Float valorsemretencao) {
        this.valorsemretencao = valorsemretencao;
    }

    public Float getAliquota() {
        return aliquota;
    }

    public void setAliquota(Float aliquota) {
        this.aliquota = aliquota;
    }

}
