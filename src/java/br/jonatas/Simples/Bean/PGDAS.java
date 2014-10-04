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
public class PGDAS {
    private int id;
    private String pa;
    private String razao;
    private String cnpj;
    private Float valorpa;
    private Float valdecsemretencao;
    private Float valdeccomretencao;
    private Float valorrecoiss;
    private Float aliquota;
    private String data;
    private String operacao;

    public PGDAS() {
        id = 0;
        pa = "";
        razao = "";
        cnpj = "";
        valorpa = new Float(0);
        valdecsemretencao = new Float(0);
        valdeccomretencao = new Float(0);
        valorrecoiss = new Float(0);
        aliquota = new Float(0);
        data = "";
        operacao = "";
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pa
     */
    public String getPa() {
        return pa;
    }

    /**
     * @param pa the pa to set
     */
    public void setPa(String pa) {
        this.pa = pa;
    }

    /**
     * @return the razao
     */
    public String getRazao() {
        return razao;
    }

    /**
     * @param razao the razao to set
     */
    public void setRazao(String razao) {
        this.razao = razao;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the valorpa
     */
    public Float getValorpa() {
        return valorpa;
    }

    /**
     * @param valorpa the valorpa to set
     */
    public void setValorpa(Float valorpa) {
        this.valorpa = valorpa;
    }

    /**
     * @return the valdecsemretencao
     */
    public Float getValdecsemretencao() {
        return valdecsemretencao;
    }

    /**
     * @param valdecsemretencao the valdecsemretencao to set
     */
    public void setValdecsemretencao(Float valdecsemretencao) {
        this.valdecsemretencao = valdecsemretencao;
    }

    /**
     * @return the valdeccomretencao
     */
    public Float getValdeccomretencao() {
        return valdeccomretencao;
    }

    /**
     * @param valdeccomretencao the valdeccomretencao to set
     */
    public void setValdeccomretencao(Float valdeccomretencao) {
        this.valdeccomretencao = valdeccomretencao;
    }

    /**
     * @return the valorrecoiss
     */
    public Float getValorrecoiss() {
        return valorrecoiss;
    }

    /**
     * @param valorrecoiss the valorrecoiss to set
     */
    public void setValorrecoiss(Float valorrecoiss) {
        this.valorrecoiss = valorrecoiss;
    }

    /**
     * @return the aliquota
     */
    public Float getAliquota() {
        return aliquota;
    }

    /**
     * @param aliquota the aliquota to set
     */
    public void setAliquota(Float aliquota) {
        this.aliquota = aliquota;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    
    
}
