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
    <h4 style="text-align: center;"> Produtos Cadastrados</h4>
    
<table class="mdl-data-table mdl-js-data-table  mdl-cell ">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Nome</th>
      <th>Codigo</th>
      <th class="mdl-data-table__cell--non-numeric">Tipo</th>
      <th>Preco</th>
      <th>Quantidade</th>
      <th>Status</th>
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
    </tr>
    
    <%  
            }

     %>
       
  
</table>
     
</div>