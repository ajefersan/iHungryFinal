/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ihungre.model.Responsavel;
import com.ihungre.model.Usuario;
import com.ihungre.model.Invalido;
import com.ihungry.model.dao.ResponsavelDAO;
import com.ihungry.model.dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jeferson
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin"})
public class servletLogin extends HttpServlet {

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
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        ResponsavelDAO respons = new ResponsavelDAO();
  //      Usuario responsavel = respons.login(login, senha);
  
  UsuarioDAO  user= new UsuarioDAO();
      
        boolean confirm = user.login(login, senha);
                
        Usuario usuario = user.getUsuario(login, senha);
        
        HttpSession session = request.getSession();
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao");
         if(confirm == true){
             
            session = request.getSession(true);
            
            String tipoUsuario = usuario.getTipoUsuario();
            if(tipoUsuario.equals("ALUNO")){
           //     Aluno aluno = user.getRespons(0)
                RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
                rd.include(request, response);
            }else if(tipoUsuario.equals("FUNCIONARIO")){
                RequestDispatcher rd = request.getRequestDispatcher("funcionario.jsp");
                rd.include(request, response);
            }else if(tipoUsuario.equals("RESPONSAVEL")){
                RequestDispatcher rd = request.getRequestDispatcher("responsavel.jsp");
                rd.include(request, response);
            }else{
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                throw new Invalido("Login ou Senha invalidos");
            
            }
            
         }else{
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            throw new Invalido("Login ou Senha invalidos");
            
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
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
