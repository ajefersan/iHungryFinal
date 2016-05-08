package com.ihungry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ConnectionFactory 
{
    protected Connection con;
    private final String URL = "jdbc:mysql://localhost/ihungry";
    private final String USER ="root";
    private final String SENHA ="root";
    private final String DRIVER="com.mysql.jdbc.Driver";
    
    public ConnectionFactory() 
    {   
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro classNotFound");
        }
        this.con = this.getConnection();
    }
    
    public final Connection getConnection()
    {
        try 
        {
            return DriverManager.getConnection(URL,USER,SENHA);
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public PreparedStatement query(String query) throws SQLException 
    {
        return this.con.prepareStatement(query);
    }
    
     public PreparedStatement query(String query, Integer statement) throws SQLException 
    {
        return this.con.prepareStatement(query, statement);
    }
    
}
