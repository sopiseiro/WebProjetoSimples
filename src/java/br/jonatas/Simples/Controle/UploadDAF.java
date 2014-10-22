/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Controle;

import br.jonatas.Simples.Bean.ArquivodafBean;
import br.jonatas.Simples.Bean.dafBean;
import br.jonatas.Simples.Modelo.ArquivodafDAO;
import br.jonatas.Simples.Modelo.dafDAO;
import br.jonatas.Simples.util.LeituraTxt;
import br.jonatas.Simples.util.tratamentoDatas;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author issqn
 */
@WebServlet(name = "UploadDAF", urlPatterns = {"/upload-daf"})
public class UploadDAF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String save = "/home/issqn/Copy/WebProjetoSimplesNacional/upload/";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        boolean ismultipart = ServletFileUpload.isMultipartContent(request);
        if (!ismultipart){
            
        }else{
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            
            try{
                
                items = upload.parseRequest(request);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            Iterator itr = items.iterator();
            while (itr.hasNext()){
                FileItem item = (FileItem) itr.next();
                
                if (item.isFormField()){
                    
                }else{
                    try {
                        String itemname = item.getName();
                        if (itemname == null || itemname.equals("")){
                            continue;
                        }
                        String filename = FilenameUtils.getName(itemname);
                        File f = new File(save + filename);
                        //System.out.print(f.getAbsolutePath()+" e adf asdf ");
                        ArquivodafDAO arqdafdao = new ArquivodafDAO();
                        ArquivodafBean arqdafbean = new ArquivodafBean();
                        
                        arqdafbean.setArquivo(f.getName());
                        arqdafbean.setData(new Date());
                        
                        System.out.println(arqdafdao.localizar(arqdafbean));
                        if (arqdafdao.localizar(arqdafbean)){
                            request.setAttribute("retorno", "2");
                            request.setAttribute("msg", "Este arquivo já foi importado!");
                            request.getRequestDispatcher("importacaodaf.jsp").forward(request, response);
                            return;
                        }

                        item.write(f);
                        
                        LeituraTxt txt = new LeituraTxt(f.getPath());
                        List<String> v = txt.LeituraTxt();
                        
                        String auto = arqdafdao.autoIncrement();                     
                        
                        tratamentoDatas d = new tratamentoDatas();
                        
                        String data_pagamento = "";
                        
                        
                        for (int i=1;i<v.size()-1;i++){
                            dafBean daf = new dafBean();
                            dafDAO dafD = new dafDAO();

                            daf.setData_pagamento(d.formataData(v.get(i).substring(9, 17)));
                            daf.setVencimento(d.formataData(v.get(i).substring(17, 25)));
                            daf.setCnpj(v.get(i).substring(74, 88));
                            daf.setCompetencia(v.get(i).substring(100, 106));
                            daf.setValor_original(convertValores( v.get(i).substring(106, 123) ));
                            daf.setValor_multa(convertValores(v.get(i).substring(123, 140)));
                            daf.setValor_juros(convertValores(v.get(i).substring(140, 157)));
                            daf.setNumero_guia(v.get(i).substring(461, 479));
                            daf.setValor_total(convertValores(v.get(i).substring(140, 157))+convertValores(v.get(i).substring(123, 140))+convertValores( v.get(i).substring(106, 123) ));
                            daf.setArqdaf(auto);
                            
                            data_pagamento = v.get(i).substring(9, 17);
                            dafD.inserir(daf);
                            
                        }
                        
                        
                        arqdafbean.setData_pagamento(d.formataData(data_pagamento));
                        arqdafdao.inserir(arqdafbean);
                        
                        request.setAttribute("retorno", "1");
                        request.setAttribute("msg", "Sucesso!");
                        request.getRequestDispatcher("importacaodaf.jsp").forward(request, response);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(UploadDAF.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("retorno", "2");
                        request.setAttribute("msg", "Erro ao importar o arquivo");
                        request.getRequestDispatcher("importacaodaf.jsp").forward(request, response);
                    }
                }
                
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private File checkExists(String fileName) {
        File f = new File(save + fileName);
        
        if (f.exists()){
            StringBuffer sb = new StringBuffer(fileName);
            sb.insert(sb.lastIndexOf("."),"-"+new Date().getTime());
            f = new File(save+sb.toString());
        }
        return f;
    }

    private Float convertValores(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.insert(string.length() - 2, '.');
        return Float.parseFloat(stringBuilder.toString());
        
    }

}
