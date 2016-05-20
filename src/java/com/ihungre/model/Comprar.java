package com.ihungre.model;

import com.ihungry.ConnectionFactory;
import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.ProdutoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Comprar extends ConnectionFactory {
  
    public Produto consultarProduto(String codigo) throws SQLException 
        {
            Produto lista = null;

            String qr = "SELECT * FROM produto WHERE codigo = ?";

            ProdutoDAO prodDao = new ProdutoDAO();
            Produto prod = new Produto();
            try (PreparedStatement stmt = this.query(qr)) 
            {   
                stmt.setString(1, codigo);

                    ResultSet rs = stmt.executeQuery();
                    rs.next();
                    
                    lista.setNome(rs.getString("nome"));
                    lista.setIdProduto(rs.getInt("idProduto"));
                    lista.setPreco(rs.getDouble("preco"));
                    lista.setStatus(rs.getInt("status"));
                    rs.close();  
            }

            
             return lista;
        }  

    private void atualizarProduto(Double valor,Integer id) throws SQLException 
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

    public int pegarIdProduto(String codigo)throws SQLException {
             int id = 0;
             String qr = "SELECT idProduto FROM produto WHERE codigo = '"+codigo+"'";

              try (PreparedStatement stmt = this.query(qr)) 
            {
                ResultSet rs = stmt.executeQuery();
                rs.next();
                id = rs.getInt("idProduto");
                System.out.println("Deu certo ID :" +id);

            }catch(Exception e ){
                System.out.println(e.getMessage() + "Deu Merda");
            }

              return id;
        }

    public boolean comprarProd(String matricula,String codigo, String data )throws SQLException, Exception{

           AlunoDAO alunoDAO = new AlunoDAO();
           int idAluno = alunoDAO.pegarIdAluno(matricula);

        //   Comprar comp = new Comprar(); '-' Não esqueça o THIS

           int idProduto;
           idProduto = this.pegarIdProduto(codigo);
           
           Double val = this.consultarValorProduto(codigo);
           Double sal = this.consultarSaldo(idAluno);
           if(val > sal)
           {    
               System.out.println("Saldo insuficiente");
               return false;
           }
           
           String sql = "INSERT INTO consumo (data,idProduto_FK,idAluno_FK) VALUES (?,?,?)";

           try(PreparedStatement stmt = this.query(sql)){

               stmt.setString(1,data);
               stmt.setInt(2, idProduto);
               stmt.setInt(3, idAluno);
               stmt.execute();
               stmt.close();

           }catch (SQLException e){
                System.out.println("Erro compra " + e.getMessage());
                return false;
            }

           this.atualizarS(idAluno, val);
           
           return true;
       }

    public Double consultarValorProduto(String codigo) throws SQLException
        {
            Double val = 0.0;

            try(PreparedStatement stmt = this.query("SELECT preco FROM produto WHERE codigo = ?"))
            {
                stmt.setString(1, codigo);

                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    val = rs.getDouble("preco");
                }

            }

            return val;
        }

    public void atualizarS(int idAluno, Double valor) throws SQLException
        {
            Double nValor = this.consultarSaldo(idAluno) - valor;
            this.atualizarSaldo(nValor,idAluno);
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
    public ArrayList<Produto> consultarConsumo(String codAluno,String dataI,String dataF) throws SQLException{
        
        ArrayList<Produto> lista;
        AlunoDAO alunoDao = new AlunoDAO();
        int idAluno = alunoDao.pegarIdAluno(codAluno);
        
        String sql = "SELECT nome,tipo,preco,idAluno_FK\n" +
                    "FROM  produto AS P\n" +
                    "LEFT JOIN consumo AS C  ON  P.idProduto = C.idProduto_FK\n" +
                    "WHERE idAluno_FK = '"+ idAluno +"' AND data BETWEEN '"+dataI+"' AND '"+dataF+"'";
        try(PreparedStatement stmt = this.query(sql)){
            
            ResultSet rs = stmt.executeQuery();
            lista = this.listar(rs);
        }
        return lista;
    }            
    
    public ArrayList<Produto> listar(ResultSet resultset) throws SQLException
    {
        ArrayList<Produto> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Produto item = new Produto();
            
            item.setNome(resultset.getString("nome"));
            item.setPreco(resultset.getDouble("preco"));
            item.setTipo(resultset.getString("tipo"));
            lista.add(item);
        }
        
        for (Produto prod : lista) {
            System.out.println("Nome Comida: " + prod.getNome());
            System.out.println("Tipo: " + prod.getTipo());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("\n");
            }
        
        resultset.close();
        return lista;
    } 
}










