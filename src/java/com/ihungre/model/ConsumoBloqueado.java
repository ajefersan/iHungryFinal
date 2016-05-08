package com.ihungre.model;

public class ConsumoBloqueado {
    
    private int idConsumoBloqueado;
    private String cod; 
    private int idAluno;
    private int idProduto;

    public int getIdConsumoBloqueado() {
        return idConsumoBloqueado;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
