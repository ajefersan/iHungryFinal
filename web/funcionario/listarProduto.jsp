<%-- 
    Document   : consultaSaldo
    Created on : 15/05/2016, 14:34:28
    Author     : jeferson
--%>

<%@page import="com.ihungre.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ihungry.model.dao.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mdl-grid mdl-card__supporting-text">
    
    
<table class="mdl-data-table mdl-js-data-table  mdl-cell ">
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
            <td class="mdl-data-table__cell--non-numeric"><a  class="mdl-color--red mdl-button mdl-js-button mdl-button--raised "href="#">Apagar</a></td>
   
            <td class="mdl-data-table__cell--non-numeric"><a class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" href="#">Alterar</a></td>
     </tr>
    
    <%  
            }

     %>
       
  
</table>
     
</div>