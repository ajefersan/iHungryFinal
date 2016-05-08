<%-- 
    Document   : cadAluno
    Created on : 08/05/2016, 17:46:35
    Author     : jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link type="text/css" rel="stylesheet" href="../assets/css/materialize.min.css"  media="screen,projection"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container row">
		
		<div class="col s12 offset-s2">
			<form name="form" onsubmit="return validar();" action="http://localhost:8083/iHungry/servletAlunoadd" class="col s8 ">
				<div class="row">

					<fieldset>

						<div class="input-field col s12">
							<h4>Cadastrar Aluno</h4>	
						</div>
                                            
                                            <div class="input-field col s12">

							<input class="validate" type="text" placeholder="cpf do responsavel" name="cpf"></input>
							
						</div>

						<div class="input-field col s12">

							<input class="validate" type="text" placeholder="Matricula" name="matricula"></input>
							
						</div>


						
						
						
						<div class="input-field col s12">
							<input class="validate" type="text" name="turma" placeholder="Turma">
						</div>	

						<div class="input-field col s12">					
							<input class="validate" type="text" name="nome" placeholder="Nome do Aluno"></input>	

						</div>
						<div class="input-field col s12">					
							<input class="validate" type="text" name="login" placeholder="login do Aluno"></input>	
						</div>
						<div class="input-field col s12">					
							<input class="validate" type="password" name="senha" placeholder="Senha do Aluno"></input>	
						</div>
						<div class="input-field col s12">					
							<input class="validate" type="number" name="saldo" placeholder="Saldo do Aluno"></input>	
						</div>
						<br>
						<div class="input-field col s12">
						    
						  	<select name="turno" class="browser-default" >
						  		<option value="" disabled selected>Escolha o Turno</option>
						    	<option value="matutino">Matutino</option>
							    <option value="noturno">Vespertino</option>
							    <option value="integral">Integral</option>
						  	</select>
							<br>
							<div class="col s12">
								<button class="btn waves-effect waves-light" type="submit" name="action">Enviar
							   
								</button>
								<button class="btn waves-effect waves-light" type="submit" name="consultar">Consultar
							   
								</button>
							</div>
							
		        		</div>
					</fieldset>
			</form>	
		</div>	
	</div>

    </body>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
     <script type="text/javascript" src="../assets/js/materialize.min.js"></script>
     <script type="text/javascript" src="../assets/js/jQuery.js"></script>
</html>
