package com.ihungry.model.dao;

import com.ihungre.model.ConsumoBloqueado;
import com.ihungry.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsumoBloqueadoDAO extends ConnectionFactory{
    
    public void cadastrar(ConsumoBloqueado consumo) throws SQLException
    {   
        String qr = "INSERT INTO consumo_bloqueado (cod,idAluno_FK,idProduto_FK) VALUES (?,?,?)";
                                                                        
        
        try(PreparedStatement stmt = this.query(qr))
            
        {
            
            stmt.setString(1,consumo.getCod());
            stmt.setInt(2, consumo.getIdAluno());
            stmt.setInt(3,consumo.getIdProduto());
           
            stmt.execute();
            stmt.close(); 
            System.out.println("Cad ok!");
        } catch (SQLException e){
        }
    
    }
    private ArrayList<ConsumoBloqueado> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<ConsumoBloqueado> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            ConsumoBloqueado item = new ConsumoBloqueado();
            
            item.setCod(resultset.getString("cod"));
            item.setIdAluno(resultset.getInt("idAluno_FK"));
            item.setIdProduto(resultset.getInt("idProduto_FK"));
            
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    public ArrayList<ConsumoBloqueado> consultar() throws SQLException 
    {
        ArrayList<ConsumoBloqueado> lista;
        String qr = "SELECT * FROM consumo_bloqueado";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }
    
    public void atualizar(ConsumoBloqueado item) throws SQLException 
    {   
        String qr = "UPDATE consumo_bloqueado SET cod=?, idAluno_FK=?, idProduto_FK=? WHERE idConsumo=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getCod());
            stmt.setInt(2, item.getIdAluno());
            stmt.setInt(3, item.getIdProduto());
            stmt.setInt(4, item.getIdConsumoBloqueado());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void deletar(ConsumoBloqueado item) throws SQLException 
    {   
        String qr = "DELETE FROM consumo_bloqueado WHERE idConsumo_bloqueado=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdConsumoBloqueado());
            stmt.execute();
            stmt.close();
        }
    }
}
