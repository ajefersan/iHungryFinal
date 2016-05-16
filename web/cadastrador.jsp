<%-- 
    Document   : cadastrador.jsp
    Created on : 08/05/2016, 16:57:47
    Author     : jeferson
--%>
<%@page import="com.ihungre.model.Produto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

       
<h1>Cadastrador com sucesso !</h1>
   <% 

        
        
    Produto p  =(Produto ) request.getAttribute("produto");
    
    out.print(p.getNome());
    out.print(p.getCodigo());
        
        
            

        
%>