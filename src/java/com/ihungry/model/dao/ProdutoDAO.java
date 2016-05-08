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
    private ArrayList<Produto> listar(ResultSet resultset) throws SQLException
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
        String qr = "UPDATE produto SET codigo=?, nome=?, preco=? , quantidade=? , status=? , tipo=?, observacao WHERE idProduto=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getCodigo());
            stmt.setString(2, item.getNome());
            stmt.setDouble(3, item.getPreco());
            stmt.setInt(4, item.getQuantidade());
            stmt.setDouble(5, item.getStatus());
            stmt.setString(6, item.getTipo());
            stmt.setString(7, item.getObservacao());
                        
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            resposta = false;
        }
        return resposta;
    }

    public void deletar(Produto item) throws SQLException 
    {   
        String qr = "DELETE FROM produto WHERE idProduto=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdProduto());
            stmt.execute();
            stmt.close();
        }
    }
     
     
     
}
