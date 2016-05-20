<%-- 
    Document   : aluno
    Created on : 17/05/2016, 03:25:56
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
  <link href="assets/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <script type="text/javascript" src="assets/js/jQuery.js"></script>
  <script type="text/javascript" src="assets/js/materialize.min.js"></script>
  <style type="text/css">
      body {
    display: flex;
    min-height: 100vh;
    flex-direction: column;
  }

  main {
    flex: 1 0 auto;
  }


  .trans:hover{


    transform: scale(1.1);
    transition: 1s;
  }




  </style>

  <script type="text/javascript">
    
function confirmar(){
          var c = confirm("Confirmar Compra ? ");

          if(c){
            location.href = "http://localhost:8083/iHungry/comprarProd?codigo=887&idAluno=matricula";
          }else{
            return false;
          }


      }



  </script>
</head>
<body>
    
    <%

//Aluno aluno = (Aluno) request.getAttribute("aluno");

if(request.getAttribute("mensagem") != null)
out.print(request.getAttribute("mensagem"));


%>

<div class="navbar-fixed">

  <nav class="red darken-4" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">iHungry</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="login.html">Finalizar Compra</a></li>
        <li><a href="logout.jsp">Sair</a></li>
        
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Login</a></li>
        <li><a href="#sobre">Sobre</a></li>
        <li><a href="#vantagens">Vantagens</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav> 


</div>  
<main>




  <div class="container row">

     <div class="card small col s3 trans ">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/comida2.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><button class="btn red darken-2" onclick="confirmar()">COMPRAR</button></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>

   <div class="card small col s3 offset-s1">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/bebida.png">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><a  class="btn red darken-2" href="#">COMPRAR</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>


   <div class="card small col s3 offset-s1">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/bebida2.png">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><a  class="btn red darken-2" href="#">COMPRAR</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>



   <div class="card small col s3 ">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/bebida3.png">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><a  class="btn red darken-2" href="#">COMPRAR</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>



   <div class="card small col s3 offset-s1">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/bebida4.png">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><a  class="btn red darken-2" href="#">COMPRAR</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>


    <div class="card small col s3 offset-s1">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="assets/img/bebida4.png">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">COMIDA<i class="material-icons right">more_vert</i></span>
      <p><a  class="btn red darken-2" href="#">COMPRAR</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">COMIDA<i class="material-icons right">close</i></span>
      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit.</p>
    </div>
  </div>


    
  
  

  
  </div>
  </main>

  <footer class="page-footer orange">
    
    <div class="footer-copyright">
      <div class="container">
           Desenvolvido por <a class="text-lighten-3" href="#">Eugênio</a> e <a href="#">Jeferson</a>
    </div>
  </footer>

  
  </body>
</html>
