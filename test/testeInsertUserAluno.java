
import com.ihungre.model.Aluno;
import com.ihungre.model.Responsavel;
import com.ihungre.model.Usuario;
import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.ResponsavelDAO;
import static com.ihungry.model.dao.ResponsavelDAO.idReturnP;
import java.sql.SQLException;

public class testeInsertUserAluno {
    
   public static void main(String[] args) throws SQLException{
    /*
    */
    
      
   Usuario userP = new Usuario();
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
      user.setNome("coroa");
       
      //matricula,turma,turno,saldo,idUsuario_FK,idResponsavel_FK,idEscola_FK
      Aluno aluno = new Aluno();
      aluno.setMatricula("301");
      aluno.setTurma("B");
      aluno.setTurno("VES");
      aluno.setSaldo(120.3);
      aluno.setResponsavel(idReturnP);
      
      
      AlunoDAO alunoDAO = new AlunoDAO();
//    alunoDAO.cadastrar(user, aluno,"cpf3"); 
    
    } 
     
   
}
