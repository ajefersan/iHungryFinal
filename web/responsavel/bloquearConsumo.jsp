<%-- 
    Document   : bloquearConsumo
    Created on : 16/05/2016, 04:37:18
    Author     : jeferson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ihungre.model.Produto"%>
<%@page import="com.ihungry.model.dao.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
 <div class="mdl-card__supporting-text">
<form name="form"action="http://localhost:8083/iHungry/servletBloquarConsumo" >
    <h4 align="center">Bloquear Consumo</h4>
    
 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
     
                    <input class="mdl-textfield__input" name="matricula" type="" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Matricula do Aluno ...</label>
                   
 </div>

 <div class="input-field">
		<select name="id">
                    <optgroup>
                            <option value="" disabled selected>Nome do Produto</option>
                      
<% 

    ProdutoDAO prod = new ProdutoDAO();
     ArrayList<Produto> lista = prod.consultar();
     
     for(Produto p : lista ){
         
 
%>

<option value="<% out.print(p.getIdProduto());  %>"><% out.print(p.getNome()); } %></option>


                    </optgroup>
                    
                </select>
<br>
 </div>
<br>
<button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
             Bloquear
  </button>

</form>
 </div>
</div>
</div>

