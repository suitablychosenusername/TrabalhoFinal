package br.com.hotel.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/TrabalhoFinal"; // Insira db
    private static final String user = ""; // Insira username
    private static final String password = ""; // Insira senha aqui
    
    public static Connection getConexao(){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection con){
        try{
            con.close();
        }catch(SQLException e){

        }
    }
}