<%-- 
    Document   : alterarAluno
    Created on : 16/05/2016, 02:01:16
    Author     : jeferson
--%>
<%@page import="com.ihungre.model.Aluno"%>
<%
   Aluno  aluno = (Aluno) request.getAttribute("aluno");
  %>

<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">

<form name="form"action="http://localhost:8083/iHungry/servletAlunoAlterar" >
     <div class="mdl-card__supporting-text">
            <h4 align="center"> Alterar Aluno </h4>
           
         </div>
    
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input"  value="<% out.print(aluno.getNome()); %>" name="nome" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Nome...</label>
             </div>
            

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                 <input class="mdl-textfield__input" value="<% out.print(aluno.getMatricula()); %>" name="matricula" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Matricula...</label>
             </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" value="<% out.print(aluno.getTurma()); %>" name="turma" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Turma...</label>
            </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input"  value="<% out.print(aluno.getLogin()); %>" name="login" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Login...</label>
             </div>


            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input"  value="<% out.print(aluno.getSenha()); %>"type="text" name="senha"  id="sample5">
                    <label class="mdl-textfield__label" for="sample5">Senha....</label>
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
                 <br>
            
        </div>


            <div class="mdl-layout-spacer"></div>

             <button type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                 Alterar
            </button>    
           
               
            </form>
    
</div>
</div>