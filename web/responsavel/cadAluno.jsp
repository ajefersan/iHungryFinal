<%-- 
    Document   : cadAluno
    Created on : 08/05/2016, 17:46:35
    Author     : jeferson
--%>

<form action="http://localhost:8083/iHungry/servletAlunoadd" >
		<div class="mdl-card__supporting-text">
                 <h4 align="center">Cadastro de Alunos </h4>
                   
        </div>
		
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="cpf" type="text" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Cpf...</label>
         </div>
       
				
		 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="nome" type="text" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Nome...</label>
         </div>


          <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="matricula" type="text" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Matricula...</label>
         </div>

		 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="turma" type="text" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Turma...</label>
         </div>


          <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="login" type="text" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Login...</label>
         </div>


         <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" name="senha" type="password" id="sample3">
                <label class="mdl-textfield__label" for="sample3">Senha...</label>
          </div>


        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" name="saldo" pattern="-?[0-9]*(\.[0-9]+)?" id="sample5">
                <label class="mdl-textfield__label" for="sample5">Saldo...</label>
                <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
        </div>
        <div class="input-field">
		<select name="turno"  >
                    <optgroup>
				<option value="" disabled selected>Escolha o Turno</option>
				<option value="matutino">Matutino</option>
				<option value="noturno">Vespertino</option>
				<option value="integral">Integral</option>
                    </optgroup>
		</select>
		<br>
            
        </div>						
		<button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
             Cadastrar
         </button>
					
</form>	
	