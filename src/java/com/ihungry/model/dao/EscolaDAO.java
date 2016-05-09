package com.ihungry.model.dao;


import com.ihungre.model.Escola;
import com.ihungre.model.Usuario;
import com.ihungry.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EscolaDAO extends ConnectionFactory {
    
    public boolean cadastrar(Escola item) throws SQLException
    {   
        String qr = "INSERT INTO escola (nome,endereco,telefone,email) VALUES (?,?,?,?)";
        boolean resposta = true;
       
        
        try(PreparedStatement stmt = this.query(qr))
        {
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getEndereço());   
            stmt.setString(3, item.getTelefone());
            stmt.setString(4, item.getEmail());
           
            stmt.execute();
            stmt.close(); 
         
        } catch (SQLException e){
            System.out.println(e.getMessage());
            resposta = false;
        }
        return resposta;
    }
    
    private ArrayList<Escola> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Escola> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Escola item = new Escola();
            
            item.setNome(resultset.getString("nome"));
            item.setTelefone(resultset.getString("telefone"));
            item.setEmail(resultset.getString("email"));
          
           
            lista.add(item);
        }
        
        resultset.close();
        
        return lista;
    }
    
    public ArrayList<Escola> consultar() throws SQLException 
    {
        ArrayList<Escola> lista;
        String qr = "SELECT * FROM escola";
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }

    
    public void atualizar(Escola item) throws SQLException 
    {   
        String qr = "UPDATE escola SET nome =?,telefone = ?,email = ? WHERE idEscola=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getTelefone());
            stmt.setString(3, item.getEmail());
            stmt.setInt(4, item.getIdEscola());
            
            stmt.execute();
            stmt.close();
        }
    }
}
