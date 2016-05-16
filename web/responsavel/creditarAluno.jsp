<%-- 
    Document   : creditarAluno
    Created on : 16/05/2016, 03:47:23
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
 <div class="mdl-card__supporting-text">
<form name="form"action="http://localhost:8083/iHungry/servletCreditarAluno" >
    <h4 align="center">Consultar Saldo </h4>

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