/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jonatas.Simples.Controle;

import br.jonatas.Simples.Modelo.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonatas
 */
public class Autenticacao extends HttpServlet {

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
        
        try {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            HttpSession autenticacao = request.getSession();
            
            Connection connection = ConnectionFactory.getConnection();
            String SQL = "SELECT usuario,nome FROM usuario WHERE senha = ? AND usuario = ?";
            
            PreparedStatement ps = null;
            
            ps = connection.prepareStatement(SQL);
            ps.setString(2, usuario);
            ps.setString(1, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                autenticacao.setAttribute("nome", rs.getString("nome"));
                autenticacao.setAttribute("usuario", usuario);
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("login.jsp");
                //request.getRequestDispatcher("login.html").forward(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);
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
        HttpSession autenticacao = request.getSession();
        if (autenticacao.getAttribute("usuario") == null)
            response.sendRedirect("login.jsp");
        else
            response.sendRedirect("index.jsp");
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
