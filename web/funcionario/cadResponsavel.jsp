<%-- 
    Document   : cadResponsavel.jsp
    Created on : 04/05/2016, 21:21:45
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="../assets/css/materialize.min.css"  media="screen,projection"/>
         <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Cadastro de Responsavel</title>
    </head>
    <body>
      <div class="container row">
		<div class="col s12 offset-s2">
			<form name="form" action="http://localhost:8083/iHungry/servletResponsavelAdd" method="post"onsubmit="return validar();" class="col s8">
				<div class="row">

					

						<div class="input-field col s12">
							<h4>Cadastro de Responsavel</h4>	
						</div>
						<div class="input-field col s12">
							<input class="validate" type="text" placeholder="Nome do Responsavel" name="nome"></input>
							
						</div>
						
						
											
						
						<div class="input-field col s12">
							<input class="validate" type="text" name="cpf" placeholder="CPF"></input>
							
						</div>	

						<div class="input-field col s12">					
							<input class="validate" type="text" name="telefone" placeholder="Telefone"></input>	

						</div>

						<div class="input-field col s12">
							<input class="validate" type="email" name="email" placeholder="Email"></input>
							
						</div>

						<div class="input-field col s12">
							<input class="validate" type="text" name="login" placeholder="Login"></input>
							
						</div>

						<div class="input-field col s12">
							<input class="validate" type="text" name="senha" placeholder="Senha"></input>
							
						</div>
						
						<div class="col s12">
							<button class="btn red darken1" type="submit" name="action">Enviar
							</button>
							<button class="btn red darken1" type="submit" name="action">Consultar
						   		
							</button>


						</div>
						
		        
					
			</form>	
		</div>	
	</div>

<!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="../assets/js/materialize.min.js"></script>
    </body>
</html>
