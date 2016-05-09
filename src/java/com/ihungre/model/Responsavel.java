package com.ihungre.model;

import com.ihungry.model.dao.AlunoDAO;
import com.ihungry.model.dao.ResponsavelDAO;
import java.sql.SQLException;

public class Responsavel extends Usuario {
    
    private int idResponsavel;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int idUsuario;
    private int idReturnP;

    public int getIdReturnP() {
        return idReturnP;
    }

    public void setIdReturnP(int idReturn) {
        this.idReturnP = idReturn;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //Da pra fazer um cadastro generico depois pensamos nisso
     public boolean cadastrar (Responsavel respons) throws Exception {

          boolean resposta = true;
         try {
              ResponsavelDAO responsavel = new ResponsavelDAO();
              resposta = responsavel.cadastrar(respons);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
     
    public void depositarCredito(Aluno aluno, float saldo){
        Double novoSaldo;
        
        
        novoSaldo = aluno.getSaldo() + saldo;
        aluno.setSaldo(novoSaldo);
        try{
            AlunoDAO a = new AlunoDAO();
            a.atualizar(aluno);
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
        
        
    
    
    }
    
    
}
