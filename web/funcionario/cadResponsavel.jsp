<form action="http://localhost:8083/iHungry/servletResponsavelAdd" name="form" >
                  <div class="mdl-card__supporting-text">
                     <h4 align="center">Cadastro de Responsavel </h4>
                   
                  </div>

                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" name="nome" type="text" id="sample3">
                      <label class="mdl-textfield__label" for="sample3">Nome...</label>
                  </div>

                   <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" name="cpf" pattern="-?[0-9]*(\.[0-9]+)?" id="sample2">
                      <label class="mdl-textfield__label" for="sample2">Cpf...</label>
                      <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
                  </div>


                 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" name="email" type="email" id="sample3">
                      <label class="mdl-textfield__label" for="sample3">Email...</label>
                </div>


                   <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" name="telefone" pattern="-?[0-9]*(\.[0-9]+)?" id="sample5">
                      <label class="mdl-textfield__label" for="sample5">Telefone...</label>
                      <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
                  </div>

                 

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" name="login" type="text" id="sample3">
                      <label class="mdl-textfield__label" for="sample3">Login...</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" name="senha" type="password" id="sample3">
                      <label class="mdl-textfield__label" for="sample3">Senha...</label>
                </div>

  
            
                <button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                  Cadastrar
                </button>
                
              </form>
              