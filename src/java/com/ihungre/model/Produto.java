package com.ihungre.model;

import com.ihungry.model.dao.ProdutoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public String printStatus(int status){
        
        String mensagem = null;
        if(status == 1) mensagem = "DISPONIVEL";
        else if(status == 0) mensagem = "BLOQUEADO";
        
        return mensagem;
    
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
     
     public ArrayList<Produto> listarProduto(ResultSet resultset) throws SQLException
    {
        ArrayList<Produto> lista = new ArrayList<>();
        ProdutoDAO prod = new ProdutoDAO();
        
        while(resultset.next()) 
        {
            Produto item = new Produto();
            
           
            item.setCodigo(resultset.getString("codigo"));
            item.setNome(resultset.getString("nome"));
            item.setTipo(resultset.getString("tipo"));
            item.setPreco(resultset.getDouble("preco"));
            item.setObservacao(resultset.getString("observacao"));
            item.setQuantidade(resultset.getInt("quantidade"));
            item.setStatus(resultset.getInt("status"));
            
             
            lista.add(item);
        }
        
        //resultset.close();
        return lista;
    } 
    


   
}
