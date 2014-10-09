/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Controle;

import br.jonatas.Simples.Bean.PgdasNFSeBean;
import br.jonatas.Simples.Modelo.PgdasNFSEDAO;
import com.lowagie.text.pdf.Pfm2afm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author issqn
 */
public class PgdasNFSEimpressaoControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PgdasNFSEDAO model = new PgdasNFSEDAO();
        
        //List<PgdasNFSeBean> pgnf = new PgdasNFSeBean();
        
        //pgnf = model.buscaInconsistencia("201408", "", true);
        String cnpj = request.getParameter("cnpj");
        String pa   = request.getParameter("pa");
        String inconsistencia = request.getParameter("inconsistencia");
        
        request.setAttribute("inco", inconsistencia);
        request.setAttribute("listaPgdas",model.buscaInconsistencia(pa, cnpj, inconsistencia));
        request.getRequestDispatcher("impressaoPGDASvsNFS.jsp").forward(request, response);
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
        request.getRequestDispatcher("impressaoPGDASvsNFS.jsp").forward(request, response);
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

}
