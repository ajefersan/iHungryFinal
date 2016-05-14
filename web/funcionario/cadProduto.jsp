 <form name="form"action="http://localhost:8083/iHungry/servletProdutoAdd" method="post" onsubmit="return validar();" class="col s8 offset-s2" >
                <div class="row">
                <fieldset>

                    

                        <div class="input-field col s12">
                            <h4>Cadastro de Produtos</h4>   
                        </div>

                        <br>

                         <p>
                          <input name="tipo" value="comida" type="radio" id="comida" />
                          <label for="comida">Comida</label>
                          
                        </p>

                         <p>
                          <input name="tipo" value="bebida" type="radio" id="bebida" />
                          <label for="bebida">Bebida</label>
                          
                        </p>

                    
                        
                        <div class="row">               
                            <div class="col s12">
                                <input class="validate" type="text" placeholder="Codigo" name="codigo" ></input>
                                
                            </div>  

                        </div>   
                    
                        <div class="input-field col s12">
                            <input type="text" class="validate" placeholder="Nome" name="nome"></input>
                            
                        </div>

                        <div class="input-field col s12">
                            <input type="text" class="validate" 
                            placeholder="Ingrediente ou Fornecedor" name="observacao"></input>
                            
                        </div>

                        

                        <div class="input-field col s6">
                            <input class="validate" type="text" placeholder="Preço R$ " name="preco"></input>
                           
                        </div>

                        <div class="input-field col s6">
                            <input class="validate" type="number" placeholder="Quantidade" name="quantidade"></input>
                           
                        </div>
                        
                        <button class="btn red darken1" type="submit" name="action">Cadastrar
                          
                        </button>

               
            </form>