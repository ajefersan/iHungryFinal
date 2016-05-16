/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ihungre.model.Produto;
import com.ihungry.model.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeferson
 */
@WebServlet(name = "AcaoProduto", urlPatterns = {"/AcaoProduto"})
public class AcaoProduto extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("acao");
        int id = Integer.parseInt(request.getParameter("id"));
        ProdutoDAO produto = new ProdutoDAO();
        
        if(acao.equals("excluir")){
            
            produto.deletar(id);
            response.sendRedirect("funcionario.jsp?pagina=listarProduto");
        
        }else if(acao.equals("alterar")){
            
            Produto prod = produto.consultarPorId(id);
            request.setAttribute("produto", prod);
            RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp?pagina=alterarProduto");
            rd.include(request, response);
            
        
        }else if(acao.equals("bloquear")){
            
           try{
           Produto prod = produto.consultarPorId(id);
           prod.bloquear(prod);
           response.sendRedirect("funcionario.jsp?pagina=listarProduto");
           }catch(Exception e){
               System.out.println(e.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AcaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AcaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
