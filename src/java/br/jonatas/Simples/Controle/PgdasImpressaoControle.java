/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Controle;

import br.jonatas.Simples.Modelo.ConnectionFactory;
import br.jonatas.Simples.Bean.PGDASBean;
import br.jonatas.Simples.Modelo.PGDASDAO;
import br.jonatas.Simples.util.Mascaras;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author issqn
 */
public class PgdasImpressaoControle extends HttpServlet {

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
        String pattern = "##.###.###/####-##";
        Mascaras m = new Mascaras();
        
        try {
            if (request.getParameter("retorno").equals("") || request.getParameter("retorno") == null){
                request.getRequestDispatcher("impressaoPGDAS.jsp").forward(request, response);
            }
            
            Connection conn = ConnectionFactory.getConnection();

            String pa = request.getParameter("pa");
            String cnpj = request.getParameter("cnpj").replace(".", "").replace("/", "").replace("-", "").replace(" ", "");
            String retorno = request.getParameter("retorno");

            List<PGDASBean> pg = new ArrayList<PGDASBean>();
            PGDASDAO model = new PGDASDAO();
            pg = model.buscaCompetenciaCNPJPA(pa, cnpj);

            request.setAttribute("listaPgdas", pg);
            request.setAttribute("cnpj",m.Mascara(pattern, cnpj));
            request.setAttribute("pa", pa);
            request.setAttribute("retorno", retorno);

            request.getRequestDispatcher("impressaoPGDAS.jsp").forward(request, response);

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PgdasImpressaoControle.class.getName()).log(Level.SEVERE, null, ex);
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
        request.getRequestDispatcher("impressaoPGDAS.jsp").forward(request, response);
        
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
