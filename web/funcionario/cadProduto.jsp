<div class="mdl-grid demo-content">

<div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">

<form name="form"action="http://localhost:8083/iHungry/servletProdutoAdd" >
     <div class="mdl-card__supporting-text">
            <h4 align="center">Cadastro de Produtos </h4>
                   
    

           
               
            <p align="center">
                <label class="mdl-radio mdl-js-radio" for="option1" >
                    <input value="comida" type="radio" id="option1" name="tipo" class="mdl-radio__button" checked>
                    <span class="mdl-radio__label">Comida</span>
                </label>

        
                 <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option2">
                    <input value="bebida" type="radio" id="option2" name="tipo" class="mdl-radio__button" >
                    <span class="mdl-radio__label">Bebida</span>
                 </label>

             </p>
         </div>
            

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" name="codigo" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Codigo...</label>
             </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" name="nome" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Nome...</label>
            </div>

             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" name="observacao" type="text" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Observacao...</label>
             </div>


            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="text" name="preco" pattern="-?[0-9]*(\.[0-9]+)?" id="sample5">
                    <label class="mdl-textfield__label" for="sample5">Preco R$....</label>
                    <span class="mdl-textfield__error">Apenas numeros neste campo!</span>
            </div>


            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" name="quantidade" type="number" id="sample3">
                    <label class="mdl-textfield__label" for="sample3">Quantidade...</label>
            </div>
            <div class="mdl-layout-spacer"></div>

             <button  type="submit"class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                  Cadastrar
            </button>                      
               
            </form>
    
</div>
</div>