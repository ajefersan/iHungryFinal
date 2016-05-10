<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/> 
        <link type="text/css" href="materialize/css/estilo.css" >
        <title>JSP Page</title>
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="assets/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="stylesheet" type="text/css" href="assets/css/animate.css">
  <script src="assets/js/jQuery.js"></script>
   <script src="assets/js/script.js"></script>
 
        
    </head>
    <body>
        
        <div id="header"> 
           <div class="menu">
            <nav>
              <div class="nav-wrapper teal #ffc400 amber accent-3">
                <a href="index.jsp" class="brand-logo">Logo</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down fixed"> 
                  <li><a href="">Home</a></li>
                  <li><a href="?pagina=cadResponsavel">Cadastrar Responsavel <span class="new badge">4</span></a></li>
                  <li><a href="?pagina=cadProduto">Cadastrar Produto</a></li>
                </ul>
              </div>
            </nav>
        </div>    
        </div> 
        
        <div>
            <c:choose>
                <c:when test="${param.pagina != null}">
                    <jsp:include page="funcionario/${param.pagina}.jsp"/>  
                    <br />
                </c:when>    
                <c:otherwise>
                    <jsp:include page="home.html"/> 
                </c:otherwise>
            </c:choose>
        
        </div>
        
        <div class="footer">
            <footer class="page-footer footer teal #795548 brown">
          <div class="container ">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-1" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
        </div>
        
    
    <script src="assets/js/jQuery.js"></script>
  <script src="assets/js/wow.js"></script>
  <script src="assets/js/materialize.js"></script>
  <script src="assets/js/init.js"></script>
    </body>
</html>
