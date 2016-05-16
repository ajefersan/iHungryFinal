<%-- 
    Document   : consultarSaldo
    Created on : 15/05/2016, 22:25:10
    Author     : jeferson
--%>

<%@page import="com.ihungre.model.Aluno"%>
<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
 <div class="mdl-card__supporting-text">
<form name="form"action="http://localhost:8083/iHungry/consultarSaldo" >
    <h4 align="center">Consultar Saldo </h4>

 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
     
                    <input class="mdl-textfield__input" name="matricula" type="" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Matricula do Aluno ...</label>
                   
 </div>
 <div class="mdl-layout-spacer"></div>
 <button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                  Consultar
 </button>   
    
    
</form>
     <% 
         if(request.getAttribute("aluno") != null){
             
             Aluno aluno = (Aluno) request.getAttribute("aluno");
         
         
         
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