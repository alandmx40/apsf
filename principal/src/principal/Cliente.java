/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ALUNO
 */
public class Cliente implements ICliente {
   
    private int id;
    private String nome;
    private String email;
 
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
   
    public Cliente() {
       
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
   
    public void salvar() {
        try {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into tb_cliente(nome, email) values (?,?)";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, this.getNome());
        pstmt.setString(2, this.getEmail());
        pstmt.execute();
        pstmt.close();
        conexao.close();
        System.out.println("Cliente salvo");
        } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
        }
    }
   
    public List<Cliente> listar() {
    List<Cliente> clientes = new ArrayList<Cliente>();
    try {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from tb_cliente";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente(getId(), getNome(), getEmail());
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            clientes.add(cliente);
        }
        rs.close();
        pstmt.close();
        conexao .close();
        return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}