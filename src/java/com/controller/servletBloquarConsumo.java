/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.ihungre.model.Aluno;
import com.ihungre.model.ConsumoBloqueado;
import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.ConsumoBloqueadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeferson
 */
@WebServlet(name = "servletBloquarConsumo", urlPatterns = {"/servletBloquarConsumo"})
public class servletBloquarConsumo extends HttpServlet {

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
        
       String matricula = request.getParameter("matricula");
        int id = Integer.parseInt(request.getParameter("id"));
        AlunoDAO aluno = new AlunoDAO();
        Aluno al = aluno.consularPorMatricula(matricula);
        ConsumoBloqueado consumo = new ConsumoBloqueado();
        ConsumoBloqueadoDAO bloqueio = new ConsumoBloqueadoDAO();
        
        consumo.setIdAluno(al.getIdAluno());
        consumo.setIdProduto(id);
        
        try{
         
            if(bloqueio.cadastrar(consumo)){
        
        
                response.sendRedirect("reponsavel.jsp?pagina=listarAluno");
        
        
        }else{
            System.out.print("Entrei aqui");
            
         }
        
        
        }catch(Exception e ){
           
                System.out.println(e.getMessage() + "entre servlet consumo ");
                
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
            Logger.getLogger(servletBloquarConsumo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletBloquarConsumo.class.getName()).log(Level.SEVERE, null, ex);
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
