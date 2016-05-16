
import com.ihungre.model.Aluno;
import com.ihungre.model.Produto;
import com.ihungre.model.Responsavel;
import com.ihungre.model.Usuario;
import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.ProdutoDAO;
import com.ihungry.model.dao.ResponsavelDAO;
import static com.ihungry.model.dao.ResponsavelDAO.idReturnP;
import java.sql.SQLException;
import java.util.ArrayList;

public class testeInsertUserAluno {
    
   public static void main(String[] args) throws SQLException{
    /*
    */
    
      
  /* Usuario userP = new Usuario();
      userP.setLogin("AAA223");
      userP.setSenha("admn");
      userP.setNome("Ed");
             
      Responsavel resp = new Responsavel();
      
      resp.setCpf("cpf3");
      resp.setEmail("email");
      resp.setTelefone("tel");
        
      ResponsavelDAO respDao = new ResponsavelDAO();
      //respDao.cadastrar(userP, resp);
      //respDao.consultarPorID(53);
      
      Usuario user = new Usuario();
      user.setLogin("carinha");
      user.setSenha("123");
      user.setNome("coroa");*/
       
      //matricula,turma,turno,saldo,idUsuario_FK,idResponsavel_FK,idEscola_FK
      /*  Aluno aluno = new Aluno();
      aluno.setMatricula("3aa3ssddssjjddjkkccmsssrlw31");
      aluno.setTurma("B");
      aluno.setTurno("VES");
      aluno.setSaldo(120.3);
      aluno.setLogin("login");
      aluno.setSenha("senha");
      aluno.setTipoUsuario("ALUNO");
      aluno.setNome("jeferson");
      
      
      AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.cadastrar(aluno,"cpf3"); 
     Responsavel res = new Responsavel();
        res.depositarCredito(aluno, 500,"cpf3");
        System.out.println(aluno.consultarSaldo(aluno.getMatricula()));*/
      
    
    ProdutoDAO prod = new ProdutoDAO();
    
    Produto produto =  prod.consultarPorId(10);
    
    System.out.println(produto.getIdProduto() + " " + produto.getNome());
    
     
   
}
   
}
