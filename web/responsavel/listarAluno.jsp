<%-- 
    Document   : depositaCredito.jsp
    Created on : 16/05/2016, 00:45:50
    Author     : jeferson
--%>


<%@page import="com.ihungre.model.Aluno"%>
<%@page import="com.ihungry.model.dao.AlunoDAO"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mdl-grid mdl-card__supporting-text">
    
    
<table class="mdl-data-table mdl-js-data-table  mdl-cell ">
    <caption><h4>Alunos cadastrados </h4></caption>
 
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Nome</th>
      <th class="mdl-data-table__cell--non-numeric">Matricula</th>
      <th class="mdl-data-table__cell--non-numeric">Turma</th>
      <th class="mdl-data-table__cell--non-numeric">Turno</th>
       <th>Saldo</th>
      <th class="mdl-data-table__cell--non-numeric">Apagar</th>
      <th class="mdl-data-table__cell--non-numeric">Alterar</th>
      
     
     
    </tr>
  </thead>
  
   <% 
            AlunoDAO aluno = new AlunoDAO();
            
            ArrayList<Aluno> lista = aluno.consultar();
            
            for(Aluno a : lista ){
                
      %>
    
     <tr>
            <td class="mdl-data-table__cell--non-numeric"> <% out.print(a.getNome());  %></td>
            <td class="mdl-data-table__cell--non-numeric"> <% out.print(a.getMatricula());  %></td>
            <td class="mdl-data-table__cell--non-numeric"> <%  out.print(a.getTurma());  %> </td>
            <td class="mdl-data-table__cell--non-numeric"> <%  out.print(a.getTurno());  %> </td>
            <td>R$ <% out.print(a.getSaldo()); %></td>
            <td class="mdl-data-table__cell--non-numeric"><a  class="mdl-color--red mdl-button mdl-js-button mdl-button--raised "href="AcaoAluno?acao=excluir&id=<% out.print(a.getIdAluno()); %>">Apagar</a></td>
            <td class="mdl-data-table__cell--non-numeric"><a class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="AcaoAluno?acao=alterar&id=<% out.print(a.getIdAluno()); %>">Alterar</a></td>
     </tr>
    
    <%  
            }

     %>
       
  
</table>
     
</div>