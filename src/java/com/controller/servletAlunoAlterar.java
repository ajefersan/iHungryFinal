/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ihungre.model.Aluno;
import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.EscolaDAO;
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
@WebServlet(name = "servletAlunoAlterar", urlPatterns = {"/servletAlunoAlterar"})
public class servletAlunoAlterar extends HttpServlet {

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
       boolean resposta = true;
         Aluno aluno = new Aluno();
         AlunoDAO al = new AlunoDAO();
         EscolaDAO escola  = new EscolaDAO(); 
        
         aluno.setNome(request.getParameter("nome"));
         aluno.setMatricula(request.getParameter("matricula"));
         aluno.setTurma(request.getParameter("turma"));
         aluno.setTurno(request.getParameter("turno"));
         aluno.setSenha(request.getParameter("senha"));
         aluno.setLogin(request.getParameter("login"));
         aluno.setTipoUsuario("ALUNO");
         aluno.setIdEscola(escola.pegarIdEscola("escola"));
         
         
        try{
          if(resposta =  al.atualizar(aluno)){
             RequestDispatcher rd = request.getRequestDispatcher("responsavel.jsp?pagina=listarAluno");
             rd.include(request, response);
        
          }
        
        }catch(SQLException | ServletException | IOException e){
            
             System.out.println(e.getMessage());
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
            Logger.getLogger(servletAlunoAlterar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletAlunoAlterar.class.getName()).log(Level.SEVERE, null, ex);
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
