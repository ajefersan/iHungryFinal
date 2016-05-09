package com.ihungre.model;

import com.ihungry.model.dao.AlunoDAO;
import java.sql.SQLException;

public class Aluno extends Usuario{
    
    private int idAluno;
    private String nome;
    private String matricula;
    private String turma;
    private String turno;      
    private Double saldo;
    private int idUsuario;
    private int idResponsavel;
    private int idEscola;
    private Responsavel responsavel;
    public int idReturnP;

    public int getIdReturnP() {
        return idReturnP;
    }

    public void setIdReturnP(int idReturnP) {
        this.idReturnP = idReturnP;
    }
    

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    
    public int getIdAluno() {
       return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setResponsavel(int idReturnP) {
        this.setIdResponsavel(idResponsavel);
    }

     public boolean cadastrar (Aluno aluno, String cpf) throws Exception {

          boolean resposta = true;
         try {
              AlunoDAO a = new AlunoDAO();
              resposta = a.cadastrar(aluno, cpf);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
     public float consultarSaldo(){
         float saldo = 0;
          try {
              AlunoDAO a = new AlunoDAO();
              saldo = a.consultarSaldo(this); 
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         return saldo;
     
     
     }
    

  
}
