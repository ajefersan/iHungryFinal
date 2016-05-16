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
@WebServlet(name = "servletProdutoAlterar", urlPatterns = {"/servletProdutoAlterar"})
public class servletProdutoAlterar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Produto produto = new Produto();
        ProdutoDAO prod = new ProdutoDAO();
        boolean resposta = true;
        
        
        produto.setCodigo(request.getParameter("codigo"));
        produto.setNome(request.getParameter("nome"));
        produto.setTipo(request.getParameter("tipo"));
        produto.setObservacao(request.getParameter("observacao"));
        produto.setPreco(Double.parseDouble(request.getParameter("preco")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setStatus(1);
       
        
        

    
    
        try{
          if(resposta =  prod.atualizar(produto)){
             RequestDispatcher rd = request.getRequestDispatcher("cadastrador.jsp");
             rd.include(request, response);
        
          }
        
        }catch(Exception e){
            
             RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
             rd.include(request, response);
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

}
