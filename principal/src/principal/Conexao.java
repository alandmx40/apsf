/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.sql.*;
 
/**
 *
 * @author ALUNO
 */
public class Conexao {
   
    public static String USUARIO = "root";
    public static String SENHA = "root";
    public static String CONNECTION_URL = "jdbc:mysql://localhost/apsf";
    public Connection getConexao() throws SQLException {
       
    Connection conn = DriverManager.getConnection(CONNECTION_URL, USUARIO, SENHA);
        return conn;
    }
 
}