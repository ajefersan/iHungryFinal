<%-- 
    Document   : creditarAluno
    Created on : 16/05/2016, 03:47:23
    Author     : jeferson
--%>

<%@page import="com.ihungre.model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
 <div class="mdl-card__supporting-text">
<form name="form"action="http://localhost:8083/iHungry/servletCreditarAluno" >
    <h4 align="center">Creditar Aluno </h4>
    
 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
     
                    <input class="mdl-textfield__input" name="matricula" type="" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Matricula do Aluno ...</label>
                   
 </div>

 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
     
                    <input class="mdl-textfield__input" name="saldo" type="" id="sample3"  pattern="-?[0-9]*(\.[0-9]+)?">
                    <label class="mdl-textfield__label" for="sample3">Valor a Credtar ...</label>
                     <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
                   
 </div>
 <div class="mdl-layout-spacer"></div>
 <button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                 Creditar
 </button>   
    
    
</form>
     
 <% 
     
         Aluno aluno = (Aluno) request.getAttribute("aluno");
         if(aluno != null){
             
  %>
       
       <table class="mdl-data-table mdl-js-data-table  mdl-cell ">
            <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">Nome</th>
                    <th class="mdl-data-table__cell--non-numeric">Matricula</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><% out.print(aluno.getNome()); %></td>
                    <td><% out.print(aluno.getMatricula()); %></td>
                    <td>R$ <% out.print(aluno.getSaldo()); %></td>
                </tr>
            </tbody>
       </table>
                
       <%
           
            }


        %>
            
     
</div>
</div>
</div>