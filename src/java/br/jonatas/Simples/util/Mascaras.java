/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.util;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author issqn
 */
public class Mascaras {

    public Mascaras() {
    }
    
    public String getCnpjFormatado(String value){
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("##.###.###-####/##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String Mascara(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCompetencia(String pa){
        return pa.substring(4, 6)+"/"+pa.substring(0, 4);
    }
    
    public String getData(String data){
        return data.substring(6, 8)+"/"+data.substring(4, 6)+"/"+data.substring(0, 4);
    }
    
    public String getCompetenciaConsulta(String data){
        //JOptionPane.showMessageDialog(null, data.substring(3, 7)+data.substring(0, 2));
        if (data.length() >= 7)
            return data.substring(3, 7)+data.substring(0, 2);
        else
            return "";
    }
    
    public String getRemoveCnpj(String cnpj){
        return cnpj.replace(".", "").replace("/", "").replace("-", "").replace(" ", "");
    }
}
