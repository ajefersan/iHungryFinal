package com.ihungry.model.dao;

import com.ihungre.model.Aluno;
import com.ihungre.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO extends UsuarioDAO{
    
     public boolean cadastrar(Aluno aluno, String cpf) throws SQLException
    {   
        
        int idReturn = 0;
        String qrUs = "INSERT INTO usuario(login,senha,nome,tipoUsuario) VALUES (?,?,?,?)";  
        String qrAl = "INSERT INTO aluno (matricula,turma,turno,saldo,idUsuario_FK,idResponsavel_FK,idEscola_FK) VALUES (?,?,?,?,?,?,?)";
        int idResp = this.pegarIdResponsavel(cpf);                                                           
            
        try(PreparedStatement stmt = this.query(qrUs , Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, aluno.getLogin());
            stmt.setString(2, aluno.getSenha());
            stmt.setString(3, aluno.getNome());
            stmt.setString(4, aluno.getTipoUsuario());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();  
            
            if (rs.next())
                idReturn = rs.getInt(1);   
        }
        
        System.out.println("ok user");
        
        if(idReturn == 0)
            System.out.println("Erro idUserFK");
           
        try(PreparedStatement stmt = this.query(qrAl))    
        {

            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getTurma());
            stmt.setString(3, aluno.getTurno());
            stmt.setDouble(4, aluno.getSaldo());
            stmt.setInt(5, idReturn);
            stmt.setInt(6, idResp);
            stmt.setInt(7, aluno.getIdEscola());
          
            stmt.execute();
            stmt.close(); 
            System.out.println("ok aluno!");
        } catch (SQLException e){
            System.out.println("Erro " + e.getMessage());
        }
        return true;
    }   
     
     
    public ArrayList<Aluno> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Aluno> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Aluno item = new Aluno();
            
            item.setNome(resultset.getString("usuario.nome"));
            item.setMatricula(resultset.getString("matricula"));
            item.setTurma(resultset.getString("turma"));
            item.setTurno(resultset.getString("turno"));
            item.setSaldo(resultset.getDouble("saldo"));
            item.setIdUsuario(resultset.getInt("idUsuario_FK"));
            item.setIdResponsavel(resultset.getInt("idResponsavel_FK"));
            item.setIdEscola(resultset.getInt("idEscola_FK"));
            item.setIdAluno(resultset.getInt("idAluno"));
            
            
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    public ArrayList<Aluno> consultar() throws SQLException 
    {
        ArrayList<Aluno> lista;
        String qr = "SELECT usuario.nome, aluno.* FROM usuario INNER JOIN aluno on IdUsuario = idUsuario_FK";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {   
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }
    
    
    
    
    public Aluno  consultarPorId(int id) throws SQLException 
    {
        String qr = "SELECT usuario.nome,usuario.login, usuario.senha,usuario.idUsuario,aluno.* FROM usuario INNER JOIN aluno on IdUsuario = idUsuario_FK WHERE idAluno = " + id;
        Aluno a = new Aluno();
        
        try(PreparedStatement stmt = this.query(qr))
        {   
 
            ResultSet rs = stmt.executeQuery();
            rs.next();
            a.setNome(rs.getString("usuario.nome"));
            a.setLogin(rs.getString("usuario.login"));
            a.setSenha(rs.getString("usuario.senha"));
            a.setIdUsuario(rs.getInt("usuario.idUsuario"));
            a.setMatricula(rs.getString("matricula"));
            a.setTurma(rs.getString("turma"));
            a.setTurno(rs.getString("turno"));
            a.setSaldo(rs.getDouble("saldo"));
            
        }catch(Exception e ){
            System.out.println(e.getMessage() + "Entrei consultaId aluno");
        }
        
        return a ;
        
    }
    
      public int pegarIdResponsavel(String cpf)throws SQLException {
         int id = 0;
         String qr = "SELECT idResponsavel from responsavel where cpf = '"+cpf+"'";
         
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             id = rs.getInt("idResponsavel");
             System.out.println("Deu certo ID :" +id);
           
        }catch(Exception e ){
            System.out.println(e.getMessage() + "Deu Merda");
        }
          
          return id;
    }
      
       public int pegarIdUsuario(String matricula )throws SQLException {
         int id = 0;
         String qr = "SELECT idUsuario_FK from aluno where matricula = '"+matricula+"'";
         
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             id = rs.getInt("idUsuario_FK");
             System.out.println(id + "imprimi id usuario");
           
        }catch(Exception e ){
            System.out.println(e.getMessage() + "Entrei idFK nesse");
        }
          
          return id;
         
     
     
     }
     
       
    public float consultarSaldo(String matricula){
        float saldo = 0;
        String qr = "SELECT saldo FROM aluno WHERE matricula = '" + matricula + " '" ;
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
             saldo = rs.getFloat("saldo");
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    
        return saldo;
    }
    
    
    public Aluno consularPorMatricula(String matricula){
        
        String qr = "SELECT usuario.nome, aluno.saldo FROM usuario INNER JOIN aluno on IdUsuario = idUsuario_FK WHERE aluno.matricula = '" + matricula + " '" ;
        Aluno aluno = new Aluno();
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
           aluno.setNome(rs.getString("usuario.nome"));
           aluno.setMatricula(matricula);
           aluno.setSaldo(rs.getDouble("saldo"));
             
            
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    
    return aluno;
    
    }
    
    public boolean atualizar(Aluno item) throws SQLException 
    {   
        boolean resposta = true;
        String qr = "UPDATE usuario SET nome = ? , login = ?, senha = ? WHERE idUsuario = ? ";
        
        try(PreparedStatement stmt = this.query(qr)) 
        {
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getLogin());
            stmt.setString(3, item.getSenha());
            stmt.setInt(4, this.pegarIdUsuario(item.getMatricula()));
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage()+ " ALUNO DAO atualizar ");
            resposta = false;
        }
        String qr2 = "UPDATE aluno SET matricula=?, turma=? , turno=?  WHERE idAluno = ? " ;
        try(PreparedStatement stmt = this.query(qr2)) 
        {
            //aluno nao tem nome
            stmt.setString(1, item.getMatricula());
            stmt.setString(2, item.getTurma());
            stmt.setString(3, item.getTurno());
            stmt.setInt(4, this.pegarIdAluno(item.getMatricula()));
            stmt.execute();
            stmt.close();
        }catch(Exception e){
        
            System.out.println(e.getMessage()+ " ALUNO DAO atualizar ");
            resposta = false;
        }
        
        return resposta ;
    }

    public void deletar(int id) throws SQLException 
    {   
        String qr = "DELETE FROM aluno WHERE idAluno=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        
        }
    }
    
   
    
    public Usuario loginAluno(String usuario,String senha) throws SQLException{
        
       String sql = "SELECT usuario.* FROM aluno" +
                    "LEFT JOIN usuario ON usuario.idUsuario = aluno.idUsuario_FK" +
                    "WHERE usuario.login = '"+usuario+"' AND usuario.senha='"+senha+"'";   
       
       Usuario user = new Usuario();
       
       ArrayList<Usuario> lista;
       
       try(PreparedStatement stmt = this.query(sql))
       {
           ResultSet rs = stmt.executeQuery();
           lista = user.listarUser(rs);
           stmt.close();
       }
       
       return (lista.size() > 0) ? lista.get(0) : null;
    }
    
    public int pegarIdAluno(String codigo)throws SQLException {
         int id = 0;
         String qr = "SELECT idAluno FROM aluno WHERE matricula = '"+codigo+"'";
         
          try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
           
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("idAluno");
                      
        }catch(Exception e ){
            System.out.println(e.getMessage() + "Deu Merda");
        }
          
          return id;
    }
    
     
}

