package com.ihungre.model;

import com.ihungry.model.dao.EscolaDAO;

public class Escola {
    
    private int idEscola;
    private String nome;
    private String telefone;
    private String email;

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    private String endereço;
    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean cadastrar (Escola esc) throws Exception {

          boolean resposta = true;
         try {
             EscolaDAO escola = new EscolaDAO();
              resposta = escola.cadastrar(esc);
              
            
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
       
        return resposta;
    }
    
    
}
