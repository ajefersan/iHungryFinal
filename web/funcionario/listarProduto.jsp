<%-- 
    Document   : consultaSaldo
    Created on : 15/05/2016, 14:34:28
    Author     : jeferson
--%>

<%@page import="com.ihungre.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ihungry.model.dao.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
    
<table class="mdl-data-table mdl-js-data-table  mdl-cell mdl-card__supporting-text ">
    <caption><h4>Produtos cadastrados </h4></caption>
 
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Nome</th>
      <th>Codigo</th>
      <th class="mdl-data-table__cell--non-numeric">Tipo</th>
      <th>Preco</th>
      <th>Quantidade</th>
      <th>Status</th>
      <th>Apagar</th>
      <th>Alterar</th>
      <th>Bloq | Desbloq</th>
      
    </tr>
  </thead>
  
   <% 
            ProdutoDAO produto = new ProdutoDAO();
            
            ArrayList<Produto> lista = produto.consultar();
            
            for(Produto p : lista ){
                
      %>
    
     <tr>
            <td class="mdl-data-table__cell--non-numeric"> <% out.print(p.getNome());  %></td>
            <td><% out.print(p.getCodigo()); %></td>
            <td class="mdl-data-table__cell--non-numeric"> <% out.print(p.getTipo()); %></td>
            <td> R$ <% out.print(p.getPreco()); %></td>
              <td> <%  out.print(p.getQuantidade());  %> </td>
            <td class="mdl-data-table__cell--non-numeric"> <% out.print(p.printStatus(p.getStatus())); %></td>
            <td class="mdl-data-table__cell--non-numeric"><a  class="mdl-color--red mdl-button mdl-js-button mdl-button--raised "href="AcaoProduto?acao=excluir&id=<% out.print(p.getIdProduto()); %>">Apagar</a></td>
   
            <td class="mdl-data-table__cell--non-numeric"><a class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="AcaoProduto?acao=alterar&id=<% out.print(p.getIdProduto()); %>">Alterar</a></td>
             <td class="mdl-data-table__cell--non-numeric"><a class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="AcaoProduto?acao=bloquear&id=<% out.print(p.getIdProduto()); %>">Bloq|Dsblq</a><br><br></td>
     </tr>
     
     <br>
    
    <%  
            }

     %>
       
  
</table>
     
