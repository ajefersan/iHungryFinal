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
        String qrAl = "INSERT INTO aluno (matricula,turma,turno,saldo,idUsuario_FK,idResponsavel_FK) VALUES (?,?,?,?,?,?)";
        int idResp = this.pegarIdResponsavel(cpf);                                                                 //idResponsavel_FK
        // ,,idResponsavel_FK      
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
         //   stmt.setInt(5, aluno.getResponsavel().getIdResponsavel());
            stmt.setInt(5, idReturn);
            stmt.setInt(6, idResp);
            
         //   stmt.setString(7, Integer.toString(aluno.getIdEscola()));
           
            stmt.execute();
            stmt.close(); 
            System.out.println("ok aluno!");
        } catch (SQLException e){
            System.out.println("Erro " + e.getMessage());
        }
        return true;
    }   
     
     
    private ArrayList<Aluno> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Aluno> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Aluno item = new Aluno();
            
            item.setNome(resultset.getString("nome"));
            item.setMatricula(resultset.getString("matricula"));
            item.setTurma(resultset.getString("turma"));
            item.setTurno(resultset.getString("turno"));
            item.setSaldo(resultset.getDouble("saldo"));
            item.setIdUsuario(resultset.getInt("idUsuario_FK"));
           // item.setIdResponsavel(resultset.getInt("idResponsavel_FK"));
           // item.setIdEscola(resultset.getInt("idEscola_FK"));
            
            
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    public ArrayList<Aluno> consultar() throws SQLException 
    {
        ArrayList<Aluno> lista;
        String qr = "SELECT * FROM aluno";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {   
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        return lista;
    }
    
    
    
    
    public void consultarPorId(Integer item) throws SQLException 
    {
        String qr = "SELECT * FROM aluno WHERE idAluno = ?";
        boolean id = false;
        
        try(PreparedStatement stmt = this.query(qr))
        {   
            stmt.setInt(1, item);
            ResultSet rs = stmt.executeQuery();
            
        }
        
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
             System.out.println(id + "imprimi isso");
           
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
          
          return id;
         
     
     
     }
    
    public void atualizar(Aluno item) throws SQLException 
    {   
        String qr = "UPDATE aluno SET nome=?, matricula=?, turma=? , turno=? , saldo=? , idUsuario_FK=?, idResponsavel_FK , idEscola_FK=? WHERE id=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getMatricula());
            stmt.setString(3, item.getTurma());
            stmt.setString(4, item.getTurno());
            stmt.setDouble(5, item.getSaldo());
            stmt.setInt(6, item.getIdUsuario());
            stmt.setInt(7, item.getIdResponsavel());
            stmt.setInt(8, item.getIdEscola());
            stmt.setInt(9, item.getIdUsuario());
            
            stmt.execute();
            stmt.close();
        }
    }

    public void deletar(Aluno item) throws SQLException 
    {   
        String qr = "DELETE FROM aluno WHERE id=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdUsuario());
            stmt.execute();
            stmt.close();
        }
    }
}

