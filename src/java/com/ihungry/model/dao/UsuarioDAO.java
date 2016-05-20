package com.ihungry.model.dao;


import com.ihungre.model.Aluno;
import com.ihungre.model.Responsavel;
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
            
            System.out.println(e.getMessage());
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
        ArrayList<Usuario> lista = null;
        String qr = "SELECT * FROM usuario";
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }catch(Exception e){
            System.out.println(e.getMessage());
        
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
        }catch(Exception e ){
            System.out.println(e.getMessage());
                  
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
    
    
    private ArrayList<Usuario> listarUsuario(ResultSet resultset) throws SQLException
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Usuario item = new Usuario();
            
            item.setLogin(resultset.getString("login"));
            item.setSenha(resultset.getString("senha"));
            item.setNome(resultset.getString("nome"));
            item.setTipoUsuario(resultset.getString("tipoUsuario"));
          
           
            lista.add(item);
        }
        
        resultset.close();
        
        return lista;
    }
    
    
       public boolean login(String usuario,String senha) throws SQLException{
        
       boolean resposta = false; 
       String sql = "SELECT * FROM usuario WHERE login = '" +usuario  + "' and senha ='" + senha + "'";
       
       UsuarioDAO log = new UsuarioDAO();
       ArrayList<Usuario> lista;
       
       try(PreparedStatement stmt = this.query(sql))
       {
           ResultSet rs = stmt.executeQuery();
           lista = log.listarUsuario(rs);
           if(lista.size() > 0)
               resposta = true;
           
           stmt.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
           resposta = false;
       }
       
       return resposta;
    }
       
       public Usuario getUsuario(String usuario,String senha) throws SQLException{
      
        String sql = "SELECT * FROM usuario WHERE login = '" +usuario+ "' and senha = '" +senha+ "'";
        Usuario user = new Usuario();
        try(PreparedStatement stmt = this.query(sql)){
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
           
            user.setIdUsuario(rs.getInt("idUsuario"));
            user.setNome(rs.getString("nome"));
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            user.setTipoUsuario(rs.getString("tipoUsuario"));
       
            }catch(Exception e){
            System.out.println(e.getMessage());
                    
            return null;
            
            }
        
        return user;
 }
            
           
    
    
    public Responsavel getRespons(int id) throws SQLException{
    
        Responsavel resp = new Responsavel();
        
        String sql = "SELECT * FROM responsavel WHERE idUsario_FK = " + id;
        
        try(PreparedStatement stmt = this.query(sql)){
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            
            resp.setIdResponsavel(rs.getInt("idResponsavel"));
            resp.setCpf(rs.getString("cpf"));
            resp.setEmail(rs.getString("email"));
            resp.setTelefone(rs.getString("telefone"));
            rs.close();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        
        }
           
    return resp;
}
    
    public ArrayList<Aluno> respConsultarFilhos(int id) throws SQLException{
        
       ResponsavelDAO resD = new ResponsavelDAO(); 
       AlunoDAO alunoDao = new AlunoDAO();
       
        
       String sql = "SELECT * " +
                    "FROM usuario AS U " +
                    "LEFT JOIN aluno AS A ON U.idUsuario =  A.idUsuario_FK " +
                    "WHERE A.idResponsavel_FK = '" + id+"'";
       
       ArrayList<Aluno> lista;
       
       try(PreparedStatement stmt = this.query(sql))
       {
           ResultSet rs = stmt.executeQuery();
           lista = alunoDao.listarAlunos(rs);
           stmt.close();
       }
       for (Aluno resp : lista) {
            System.out.println("Nome: " + resp.getNome());
            System.out.println("Matt: " + resp.getMatricula());
            System.out.println("Turma: " + resp.getTurma());
            System.out.println("\n");
            }
       
       return lista;
    }
}