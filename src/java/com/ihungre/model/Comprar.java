package com.ihungre.model;

import com.ihungry.ConnectionFactory;
import com.ihungry.model.dao.ProdutoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Comprar extends ConnectionFactory {
    
    
 public ArrayList<Produto> consultarProduto(String codigo) throws SQLException 
    {
        ArrayList<Produto> lista = null;
                
        String qr = "SELECT * FROM produto WHERE codigo = ?";
        
        ProdutoDAO prodDao = new ProdutoDAO();
        Produto prod = new Produto();
        try (PreparedStatement stmt = this.query(qr)) 
        {   
            stmt.setString(1, codigo);
            
                ResultSet rs = stmt.executeQuery();
                lista = prod.listarProduto(rs);
                rs.close();  
        }
        
        for (Produto resp : lista) {
            System.out.println("Nome: " + resp.getNome());
            System.out.println("Email: " + resp.getCodigo());
            System.out.println("Endereço: " + resp.getObservacao());
            System.out.println("Endereço: " + resp.getTipo());
            System.out.println("\n");
            }
         return lista;
    }  
   
    private void atualizarProduto(Double valor,Integer id) throws SQLException 
    {   
        String qr = "UPDATE aluno SET saldo = ? WHERE idAluno = ?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(2, id);
            stmt.setDouble(1, valor);
            
            stmt.execute();
            stmt.close();
        }
    }
      

    
    public void consultarRespPorId(Integer item) throws SQLException 
    {
        String qr = "SELECT * FROM responsavel WHERE idResponsavel = ?";
        boolean id = false;
        
        try(PreparedStatement stmt = this.query(qr))
        {   
            stmt.setInt(1, item);
            ResultSet rs = stmt.executeQuery();
            
        }
        
    }
}
