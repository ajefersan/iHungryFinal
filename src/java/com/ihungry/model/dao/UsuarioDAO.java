package com.ihungry.model.dao;


import com.ihungre.model.Usuario;
import com.ihungry.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends ConnectionFactory{
     
    public void cadastrar(Usuario user) throws SQLException
    {   
        String qr = "INSERT INTO usuario (login,senha,tipoUsuario) VALUES (?,?,?)";
       
        
        try(PreparedStatement stmt = this.query(qr))
        {
            
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getTipoUsuario());
           
            stmt.execute();
            stmt.close(); 
            System.out.println("Cad ok!");
        } catch (SQLException e){
        }
    }
    
    private ArrayList<Usuario> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Usuario item = new Usuario();
            
            item.setLogin(resultset.getString("login"));
            item.setSenha(resultset.getString("senha"));
            item.setTipoUsuario(resultset.getString("tipoUsuario"));
          
           
            lista.add(item);
        }
        
        resultset.close();
        
        return lista;
    }
    
    public ArrayList<Usuario> consultarUser() throws SQLException 
    {
        ArrayList<Usuario> lista;
        String qr = "SELECT * FROM usuario";
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        for (Usuario user : lista) {
            System.out.println("Login: " + user.getLogin());
            System.out.println("Senha: " + user.getSenha());
            System.out.println("Tipo User: " + user.getTipoUsuario());
            System.out.println("\n");
            }
        return lista;
    }

    
    public void atualizar(Usuario item) throws SQLException 
    {   
        String qr = "UPDATE usuario SET login=?, senha=?, tipoUsuario=? WHERE idUsuario=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getLogin());
            stmt.setString(2, item.getSenha());
            stmt.setString(3, item.getTipoUsuario());
            stmt.setInt(4, item.getIdUsuario());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void deletar(Usuario item) throws SQLException 
    {   
        String qr = "DELETE FROM usuario WHERE idUsuario=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdUsuario());
            stmt.execute();
            stmt.close();
        }
    }
}