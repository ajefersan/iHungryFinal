package com.ihungry.model.dao;


import com.ihungre.model.Consumo;
import com.ihungry.ConnectionFactory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsumoDAO extends ConnectionFactory {
    
    public void cadastrar(Consumo item) throws SQLException
    {   
        String qr = "INSERT INTO consumo (codigo,tipo) VALUES (?,?)";
                                                                        
        
        try(PreparedStatement stmt = this.query(qr))
            
        {
            
            stmt.setDate(1, (Date) item.getData());
            stmt.setInt(2, item.getIdProduto());
            stmt.setInt(3,item.getIdAluno());
                       
            stmt.execute();
            stmt.close(); 
            System.out.println("Cad 5 ok!");
        } catch (SQLException e){
        }
    
    }
    
    private ArrayList<Consumo> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Consumo> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Consumo item = new Consumo();
            
            item.setData(resultset.getDate("data"));
            item.setIdProduto(resultset.getInt("idResponsavel_FK"));
            item.setIdAluno(resultset.getInt("idEscola_FK"));
            
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    public ArrayList<Consumo> consultar() throws SQLException 
    {
        ArrayList<Consumo> lista;
        String qr = "SELECT * FROM consumo";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }
    
    private ArrayList<Consumo> buscar(String qr) throws SQLException {
        
        ArrayList<Consumo> lista;
        
        try(PreparedStatement stmt =  this.query(qr))
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
            
            stmt.close();
        }
        return lista;
    }
    
    public void atualizar(Consumo item) throws SQLException 
    {   
        String qr = "UPDATE consumo SET data=?, idProduto_FK=?, idAluno_FK=? WHERE idConsumo=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setDate(1, (Date) item.getData());
            stmt.setInt(2, item.getIdProduto());
            stmt.setInt(9, item.getIdConsumo());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void deletar(Consumo item) throws SQLException 
    {   
        String qr = "DELETE FROM consumo WHERE id=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdConsumo());
            stmt.execute();
            stmt.close();
        }
    }
    
    public ArrayList<Consumo> buscaData(Date data) throws SQLException {
        return this.buscar("SELECT * FROM consumo WHERE data = '" + data + "'");
    }
}
