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
public class ArquivodafBean {
    private int id;
    private String arquivo;
    private Date data;
    private Date data_pagamento;

    public ArquivodafBean() {
        this.id = 0;
        this.arquivo = "";
        this.data = null;
        this.data_pagamento = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    
    
    
    
}
