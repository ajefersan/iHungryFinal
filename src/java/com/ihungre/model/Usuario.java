package com.ihungre.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Usuario {
    
    private int idUsuario;
    private String login;
    private String senha;
    private String nome;
    private String tipoUsuario;
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  

    public int getIdUsuario() {
        return idUsuario;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public ArrayList<Usuario> listarUser(ResultSet resultset) throws SQLException
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        while(resultset.next()) 
        {
            Usuario item = new Usuario();
            
           
            item.setNome(resultset.getString("nome"));
            item.setLogin(resultset.getString("login"));
            item.setTipoUsuario(resultset.getString("tipoUsuario"));
           
             
            lista.add(item);
        }
        
        resultset.close();
        return lista;
    }
}
