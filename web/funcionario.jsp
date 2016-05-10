<%-- 
    Document   : funcionario
    Created on : 09/05/2016, 23:24:29
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>iHungry - Sua cantina online</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="assets/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link rel="stylesheet" type="text/css" href="assets/css/animate.css">
  <script src="assets/js/jQuery.js"></script>
   <script src="assets/js/script.js"></script>
  
</head>
<body>
<div class="navbar-fixed">

  <nav class="red darken-4" role="navigation" id="menu">
    <div class="nav-wrapper container"><a id="logo-container"  href="#" class="brand-logo ">Logo</a>
      <ul class="right hide-on-med-and-down ">
        <li><a href="login.html">Login</a></li>
        <li><a href="?pagina=cadResponsavel">Sobre</a></li>
        <li><a href="?pagina=cadProduto">Vantagens</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Login</a></li>
        <li><a href="?pagina=cadResponsavel">Cadastro Responsavel</a></li>
        <li><a href="?pagina=cadProduto">Cadastro Produto</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav> 


</div>  



        
  



  <div class="container">

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

  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">iHungry Inc.</h5>
          <p class="grey-text text-lighten-4">Somos só mais uma start up que apastou no "inesperado", trazendo aos nossos clientes um serviço inedito e que cumpre bem aquilo que promete, se tornando sucesso em mais de 500 escolas pelo Brasil.</p>


        </div>
        <div class="col l6 s12">
          <h5 class="white-text">Redes Sociais</h5>
          <ul>
            <li><a class="white-text" href="#!">Twiter</a></li>
            <li><a class="white-text" href="#!">Facebbok</a></li>
            <li><a class="white-text" href="#!">Instagran</a></li>
            <li><a class="white-text" href="#!">Google+</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
           Desenvolvido por <a class="text-lighten-3" href="#">Eugênio</a> e <a href="#">Jeferson</a>
    </div>
  </footer>
  <script src="assets/js/jQuery.js"></script>
  <script src="assets/js/wow.js"></script>
  <script src="assets/js/materialize.js"></script>
  <script src="assets/js/init.js"></script>

  
  
  </body>
</html>

