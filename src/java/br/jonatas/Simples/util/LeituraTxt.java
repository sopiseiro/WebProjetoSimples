/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.jonatas.Simples.util;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Recebe um caminho do txt na criacao 
 * devolve uma vetor de dados do txt
 * 
 * @author issqn
 */
public class LeituraTxt {
    private Object caminho;
    private List v;
    
    public LeituraTxt(Object caminho){
        this.caminho = caminho;
    }
    
    public void imprimir(){
        for (int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
    }
    
    public List LeituraTxt() throws FileNotFoundException{
        v = new ArrayList();
        try{
            FileReader fileReader = new FileReader(caminho.toString());
            BufferedReader reader = new BufferedReader(fileReader);
            String data = null;

            while((data = reader.readLine()) != null){
                v.add(data);
            }
            fileReader.close();
            reader.close();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Deu bosta");
        }
        //System.out.println(v.size());
        /*Scanner scanner = new Scanner(new FileReader(caminho));//.useDelimiter("\\r\\n");
        System.out.println("Caminho: "+caminho);
        while (scanner.hasNext()) {
            v[i++] = scanner.next();
            System.out.println("Info:"+v[i-1]);
          /*String nome = scanner.next();
          String cidade = scanner.next();
          String compras = scanner.next();
          System.out.println(nome);
          System.out.println(cidade);
          System.out.println(compras);
        }
        scanner.close();*/
        
        return v;
    }
    
    public List leituraTxtPGDAS() throws FileNotFoundException{
        v = new ArrayList();
        String codMunicipio = "8979";
        List<String> aux;
        
        try{
            FileReader fileReader = new FileReader(caminho.toString());
            BufferedReader reader = new BufferedReader(fileReader);
            String data = null;
            String corte[] = null;
            boolean captura = false;
            //int i=0;
            aux = new ArrayList<String>();
            while((data = reader.readLine()) != null){
                 aux.add(data);
                 if (data.substring(0,5).equals("00000")){
                    if (data.split("\\|")[8].equals("8979")){
                        //v.add(data);
                        captura = true;
                        //System.out.println(data + "Contador: "+i++);
                    }
                }
                 
                if (data.substring(0,5).equals("03000") ){
                        if (data.split("\\|")[3].equals(codMunicipio))
                            captura = true;  
                } 
                 
                if (data.substring(0,5).equals("99999")){
                    if (captura){
                        for (int i=0;i<aux.size();i++){
                            v.add(aux.get(i));
                        }
                    }
                    aux = new ArrayList<String>();
                    captura = false;
                }
                
            }
                /*if (captura){
                    v.add(data);
                    //System.out.println(data);
                }
                if (data.substring(0,5).equals("00000")){
                    if (data.split("\\|")[8].equals("8979")){
                        v.add(data);
                        captura = true;
                        //System.out.println(data + "Contador: "+i++);
                    }
                }
                
                if (data.substring(0,5).equals("99999"))
                    captura = false;
               
            }
            fileReader.close();
            reader.close();*/
            
        }catch(Exception e){
            System.out.println("Deu bosta");
        }
        System.out.println(v.size());
        /*Scanner scanner = new Scanner(new FileReader(caminho));//.useDelimiter("\\r\\n");
        System.out.println("Caminho: "+caminho);
        while (scanner.hasNext()) {
            v[i++] = scanner.next();
            System.out.println("Info:"+v[i-1]);
          /*String nome = scanner.next();
          String cidade = scanner.next();
          String compras = scanner.next();
          System.out.println(nome);
          System.out.println(cidade);
          System.out.println(compras);
        }
        scanner.close();*/
        
        return v;
    }
}
