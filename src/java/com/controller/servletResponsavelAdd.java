/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ihungre.model.Responsavel;
import java.io.IOException;
import static java.lang.System.out;
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
@WebServlet(name = "servletResponsavelAdd", urlPatterns = {"/servletResponsavelAdd"})
public class servletResponsavelAdd extends HttpServlet {

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
        boolean resposta = true;
        Responsavel responsavel = new Responsavel();
        
       
        
        
        responsavel.setCpf(request.getParameter("cpf"));
        responsavel.setNome(request.getParameter("nome"));
        responsavel.setEmail(request.getParameter("email"));
        responsavel.setTelefone(request.getParameter("telefone"));
        responsavel.setLogin(request.getParameter("login"));
        responsavel.setSenha(request.getParameter("senha"));
        responsavel.setTipoUsuario("RESPONSAVEL");
        
        try{
          if(resposta =  responsavel.cadastrar(responsavel)){
             RequestDispatcher rd = request.getRequestDispatcher("cadastrador.jsp");
             rd.include(request, response);
        
          }
        
        }catch(Exception e){
            
            out.println(e.getMessage());
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
