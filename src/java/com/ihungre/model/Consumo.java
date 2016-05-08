package com.ihungre.model;

import java.util.Date;

public class Consumo {
   
    private int idConsumo;
    private Date data;
    private int idProduto;
    private int idAluno;

    public int getIdConsumo() {
        return idConsumo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
    
}
