package com.ihungry.model.dao;


import com.ihungre.model.Aluno;
import com.ihungre.model.Responsavel;
import com.ihungre.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResponsavelDAO extends UsuarioDAO{
    public static int idReturnP;
    
    public boolean cadastrar(Responsavel item) throws SQLException
    {   
        boolean resposta = true;
        String qrUs = "INSERT INTO usuario(login,senha,nome,tipoUsuario) VALUES (?,?,?,?)";  
        String qrRes = "INSERT INTO responsavel (cpf,email,telefone,idUsuario_FK) VALUES (?,?,?,?)";
        
        int idReturn = 0;
        
        try(PreparedStatement stmt = this.query(qrUs , Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setString(1, item.getLogin());
            stmt.setString(2, item.getSenha());
            stmt.setString(3, item.getNome());
            stmt.setString(4, item.getTipoUsuario());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();  
            
            if (rs.next())
                idReturn = rs.getInt(1);
              System.out.println("ok user");
            
        }catch (SQLException e){
            resposta = false;
        }
      
        
        
        try(PreparedStatement stmt = this.query(qrRes,Statement.RETURN_GENERATED_KEYS))
        {
            
            stmt.setString(1, item.getCpf());
            stmt.setString(2, item.getEmail());
            stmt.setString(3, item.getTelefone());
            stmt.setInt(4, idReturn);
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();  
            
            if (rs.next())
                idReturnP = rs.getInt(1);
            
            stmt.close(); 
            
            System.out.println("ok Res!");
        } catch (SQLException e){
            resposta = false;
        }
        
        return resposta;
    }
    
    private ArrayList<Responsavel> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Responsavel> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Responsavel item = new Responsavel();
            
            //item.setNome(resultset.getString("nome"));
            item.setCpf(resultset.getString("cpf"));
            item.setEmail(resultset.getString("email"));
            item.setTelefone(resultset.getString("telefone"));
           // item.setIdUsuario(resultset.getInt("idUsuario_FK"));
            
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    private ArrayList<Usuario> listarUser(ResultSet resultset) throws SQLException
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Usuario item = new Usuario();
            
           
            item.setNome(resultset.getString("nome"));
            item.setLogin(resultset.getString("login"));
            item.setTipoUsuario(resultset.getString("tipoUsuario"));
            item.setNome(resultset.getString("nome"));
             
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    
    
    private ArrayList<Aluno> listarAluno(ResultSet resultset) throws SQLException
    {
        ArrayList<Aluno> lista = new ArrayList<>();
        ResponsavelDAO resp = new ResponsavelDAO();
        
        while(resultset.next()) 
        {
            Aluno item = new Aluno();
            
           
            item.setIdAluno(resultset.getInt("idAluno"));
            item.setMatricula(resultset.getString("matricula"));
            item.setTurma(resultset.getString("turma"));
            item.setTurno(resultset.getString("turno"));
            item.setNome(resultset.getString("saldo"));
            item.setIdUsuario(resultset.getInt("idUsuario_FK"));
           // item.setIdResponsavel());
             
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
    public Usuario login(String usuario,String senha) throws SQLException{
        
       String sql = "SELECT usuario.* FROM responsavel" +
                    "LEFT JOIN usuario ON usuario.idUsuario = responsavel.idUsuario_FK" +
                    "WHERE usuario.login = '"+usuario+"' AND usuario.senha='"+senha+"'";   
       
       ArrayList<Usuario> lista;
       
       try(PreparedStatement stmt = this.query(sql))
       {
           ResultSet rs = stmt.executeQuery();
           lista = this.listarUser(rs);
           stmt.close();
       }
       
       return (lista.size() > 0) ? lista.get(0) : null;
    }
     
     
      public Usuario respConsultarFilhos(Responsavel resp) throws SQLException{
        
       String sql = "SELECT * FROM aluno\n" +
                    "INNER JOIN responsavel\n" +
                    "ON aluno.idResponsavel_FK = responsavel.idResponsavel\n" +
                    "WHERE aluno.idResponsavel_FK = '" + resp.getIdResponsavel();
      
       ArrayList<Aluno> lista;
       
       try(PreparedStatement stmt = this.query(sql))
       {
           ResultSet rs = stmt.executeQuery();
           lista = this.listarAluno(rs);
           stmt.close();
       }
       
       return (lista.size() > 0) ? lista.get(0) : null;
    }
    
    
    
    public ArrayList<Responsavel> consultar() throws SQLException 
    {
        ArrayList<Responsavel> lista;
        String qr = "SELECT * FROM responsavel";
        
        try (PreparedStatement stmt = this.query(qr)) 
        {
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        
        for (Responsavel resp : lista) {
            System.out.println("Nome: " + resp.getNome());
            System.out.println("Email: " + resp.getCpf());
            System.out.println("Endereço: " + resp.getEmail());
            System.out.println("\n");
            }
        return lista;
    }  
    
      public ArrayList<Responsavel> consultarPorID(int id) throws SQLException 
    {
        ArrayList<Responsavel> lista;
        ArrayList<Usuario> lista2;
        
        String qr = "SELECT login,tipoUsuario,nome,email,cpf,telefone \n" +
                    "FROM  usuario \n" +
                    "INNER JOIN responsavel \n" +
                    "ON usuario.idUsuario = responsavel.idUsuario_FK\n" +
                    "WHERE idResponsavel = " + id + "" ;
        
        try (PreparedStatement stmt = this.query(qr)) 
        {
           // stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
            ResultSet rs2 = stmt.executeQuery();
            lista2 = this.listarUser(rs2);
          //  rs.close();
           
        }
        
         for(Usuario user : lista2)
        {
          System.out.println("Nome: " + user.getNome()); 
          System.out.println("Tipo User:" + user.getTipoUsuario());
        }
         
        for (Responsavel resp : lista) 
        {
           
            System.out.println("Email: " + resp.getCpf());
            System.out.println("Endereço: " + resp.getEmail());
            System.out.println("\n");
        }

         // concatenarListas(lista,lista2);
         return lista;
    }  
      
   
    
     
   
    public void atualizar(Responsavel item) throws SQLException 
    {   
        String qr = "UPDATE responsavel SET nome=?, cpf=?, telefone=? , idUsuario_FK=? WHERE idResponsavel=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCpf());
            stmt.setString(3, item.getEmail());
            stmt.setString(4, item.getTelefone());
            stmt.setInt(5, item.getIdUsuario());
            
            stmt.execute();
            stmt.close();
        }
    }

  
      public void deletarRes(Responsavel item) throws SQLException 
    {   
        String qr = "DELETE FROM responsavel WHERE idResponsavel=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item.getIdResponsavel());
            stmt.execute();
            stmt.close();
        }
    }
    
    
    public void deletarId(Integer item) throws SQLException 
    {   
        String qr = "DELETE FROM responsavel WHERE idResponsavel=?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(1, item);
            stmt.execute();
            stmt.close();
        }
    }
       
    public Double consultarSaldo(int idAluno) throws SQLException
    {
        Double val = 0.0;
        
        try(PreparedStatement stmt = this.query("SELECT saldo FROM aluno WHERE idAluno = ?"))
        {
            stmt.setInt(1, idAluno);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                val = rs.getDouble("saldo");
            }
            
        }
        
        return val;
    }
    
    private void atualizarSaldo(Double valor,Integer id) throws SQLException 
    {   
        String qr = "UPDATE aluno SET saldo = ? WHERE idAluno = ?";
        try(PreparedStatement stmt = this.query(qr)) 
        {
            stmt.setInt(2, id);
            stmt.setDouble(1, valor);
            
            stmt.execute();
            stmt.close();
        }
    }
      
   
    public void addCredito(int idAluno, Double valor) throws SQLException
    {
        Double nValor = this.consultarSaldo(idAluno) + valor;
        this.atualizarSaldo(nValor,idAluno);
    }
    
    public void consultarRespPorId(Integer item) throws SQLException 
    {
        String qr = "SELECT * FROM responsavel WHERE idResponsavel = ?";
        boolean id = false;
        
        try(PreparedStatement stmt = this.query(qr))
        {   
            stmt.setInt(1, item);
            ResultSet rs = stmt.executeQuery();
            
        }
        
    }
}
