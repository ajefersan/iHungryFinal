package com.ihungre.model;

import com.ihungry.model.dao.ProdutoDAO;

public class Produto {
    
    private int idProduto;
    private String codigo;
    private String nome;
    private Double preco;
    private String tipo;
    private String observacao;
    private int quantidade;
    private int status;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean cadastrar (Produto produto) throws Exception {

          boolean resposta = true;
         try {
              ProdutoDAO prod = new ProdutoDAO();
              resposta = prod.cadastrar(produto);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
    public boolean bloquearOuAtt(Produto produto,int operacao){
        /* Operacao 1 = atualizar
           Operacao 2 = bloquear
        */
        
          boolean resposta = true;
          if(operacao == 1)
                 this.status = 0;
         try {
              ProdutoDAO prod = new ProdutoDAO();
              
              resposta = prod.atualizar(produto);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    
    
    }
    
     public boolean deletarProduto(Produto produto){
        
        
          boolean resposta = true;
         try {
              ProdutoDAO prod = new ProdutoDAO();
              this.status = 0;
              resposta = prod.deletar(produto);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    
    
    }
     
     
    


   
}
