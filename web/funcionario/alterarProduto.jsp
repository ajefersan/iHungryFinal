<%-- 
    Document   : alterarProduto
    Created on : 15/05/2016, 19:57:43
    Author     : jeferson
--%>


<%@page import="com.ihungre.model.Produto"%>
<%
    Produto  produto = (Produto) request.getAttribute("produto");
  %>
<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">

<form name="form"action="http://localhost:8083/iHungry/servletProdutoAlterar" >
     <div class="mdl-card__supporting-text">
            <h4 align="center"> Alterar Produto </h4>
           
         </div>
    
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" disabled value="<% out.print(produto.getTipo()); %>" name="tipo" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Tipo...</label>
             </div>
            

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                 <input class="mdl-textfield__input" value="<% out.print(produto.getCodigo()); %>" name="codigo" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Codigo...</label>
             </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" value="<% out.print(produto.getNome()); %>" name="nome" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Nome...</label>
            </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input"  value="<% out.print(produto.getObservacao()); %>" name="observacao" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Observacao...</label>
             </div>


            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input"  value="<% out.print(produto.getPreco()); %>"type="text" name="preco" pattern="-?[0-9]*(\.[0-9]+)?" id="sample5">
                    <label class="mdl-textfield__label" for="sample5">Preco R$....</label>
                    <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
            </div>


            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input"  value="<% out.print(produto.getQuantidade()); %>" name="quantidade" type="number" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Quantidade...</label>
            </div>
            <div class="mdl-layout-spacer"></div>

             <button type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                 Alterar
            </button>                      
               
            </form>
    
</div>
</div>