<%-- 
    Document   : cadEscola
    Created on : 08/05/2016, 20:16:48
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
	<div class="container row ">
		<div class="col s12">
			<form name="form" onsubmit="return validar();" class="col s8 offset-l2" action="http://localhost:8083/iHungry/servletEscolaAdd">
				<div class="row">

					

						<div class="input-field col s12">
							<h4>Cadastro de Escola</h4>	
						</div>

						<div class="input-field col s12">
							<input class="validate" type="text" placeholder="Nome da Escola" name="nome"></input>
							<label for="nome">Nome da Escola</label>
						</div>
												
						
						<div class="input-field col s12">
							<input class="validate" type="text" name="endereco" placeholder="endereço"></input>
							<label for="end">Endereco</label>
						</div>	

						<div class="input-field col s12">					
							<input class="validate" type="text" name="telefone" placeholder="telefone"></input>	<label for="tel">Telefone</label>	

						</div>

						<div class="input-field col s12">
							<input class="validate" type="email" name="email" placeholder="email"></input>
							<label for="email">Email</label>
						</div>

						<button class="red darken1 btn" type="submit" name="action">Enviar
						   
						</button>
		        
					
			</form>	
		</div>	
	</div>

<!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="assets/js/materialize.min.js"></script>
       <script type="text/javascript" src="assets/js/jQuery.js"></script>
      
	</script>
    </body>
</html>
