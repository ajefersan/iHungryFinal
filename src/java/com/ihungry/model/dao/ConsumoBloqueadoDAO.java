package com.ihungry.model.dao;

import com.ihungre.model.ConsumoBloqueado;
import com.ihungry.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsumoBloqueadoDAO extends ConnectionFactory{
    
    public boolean cadastrar(ConsumoBloqueado consumo) throws SQLException
    {   
        
        boolean resposta = true;
        String qr = "INSERT INTO consumo_bloqueado (idAluno_FK,idProduto_FK) VALUES (?,?)";
                                                                        
        
        try(PreparedStatement stmt = this.query(qr))
            
        {
            
           
            stmt.setInt(1, consumo.getIdAluno());
            stmt.setInt(2,consumo.getIdProduto());
           
            stmt.execute();
            stmt.close(); 
            
        } catch (SQLException e){
            
            System.out.print(e.getMessage() + "entrei dao consumo bloqueado");
            resposta = false;
        }
        
        return resposta;
    
    }
    private ArrayList<ConsumoBloqueado> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<ConsumoBloqueado> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            ConsumoBloqueado item = new ConsumoBloqueado();
            
            
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
        String qr = "UPDATE consumo_bloqueado SET  idAluno_FK=?, idProduto_FK=? WHERE idConsumo=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            
            stmt.setInt(1, item.getIdAluno());
            stmt.setInt(2, item.getIdProduto());
            stmt.setInt(3, item.getIdConsumoBloqueado());
            
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
