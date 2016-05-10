package com.ihungry.model.dao;



import com.ihungre.model.Produto;
import com.ihungry.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO extends ConnectionFactory{
    
     public boolean cadastrar(Produto prod) throws SQLException
    {   
        String qr = "INSERT INTO produto (codigo,nome,preco,quantidade,status,tipo,observacao) VALUES (?,?,?,?,?,?,?)";
       
        boolean resposta = true;
        try(PreparedStatement stmt = this.query(qr))
            
        {
            
            stmt.setString(1, prod.getCodigo());
            stmt.setString(2, prod.getNome());
            stmt.setDouble(3,prod.getPreco());
            stmt.setInt(4, prod.getQuantidade());
            stmt.setInt(5, prod.getStatus());
            stmt.setString(6,prod.getTipo());
            stmt.setString(7, prod.getObservacao());
           
            stmt.execute();
            stmt.close(); 
            System.out.println("Cad 2 ok!");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            resposta = false;
        }
    return resposta;
    }
    public ArrayList<Produto> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Produto> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Produto item = new Produto();
            
            item.setCodigo(resultset.getString("codigo"));
            item.setNome(resultset.getString("nome"));
            item.setPreco(resultset.getDouble("preco"));
            item.setQuantidade(resultset.getInt("quantidade"));
            item.setStatus(resultset.getInt("status"));
            item.setPreco(resultset.getDouble("tipo"));
            item.setQuantidade(resultset.getInt("observacao"));
            
            
           lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    public ArrayList<Produto> consultar() throws SQLException 
    {
        ArrayList<Produto> lista;
        String qr = "SELECT * FROM produto";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }
    
    public boolean atualizar(Produto item) throws SQLException 
    {   
        boolean resposta = true;
        String qr = "UPDATE produto SET codigo=?, nome=?, tipo=? , preco=? , observacao=? , quantidade=?,status=? WHERE idProduto=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getCodigo());
            stmt.setString(2, item.getNome());
            stmt.setString(3, item.getTipo());
            stmt.setDouble(4, item.getPreco());
            stmt.setString(5, item.getObservacao());
            stmt.setInt(6, item.getQuantidade());
            stmt.setInt(7, item.getStatus());
            stmt.setInt(8, this.pegaId(item.getCodigo()));
           
                        
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            resposta = false;
        }
        return resposta;
    }

    public boolean deletar(Produto item) throws SQLException 
    {   boolean resposta = true;
        String qr = "DELETE FROM produto WHERE idProduto=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdProduto());
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println(e.getMessage());
            resposta = false;
        
        }
        return resposta;
    }
     
    
    public int pegaId(String codigo){
    
    int id = 0;
    String qr = "SELECT idProduto FROM produto where codigo = '"+ codigo + "'";   
    
   
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             id = rs.getInt("idProduto");
             System.out.println(id + "imprimi isso");
           
        }catch(Exception e ){
            System.out.println(e.getMessage() + "Entrei nesse");
        }
          
          return id;
    
    
    
    }
     
     
}
