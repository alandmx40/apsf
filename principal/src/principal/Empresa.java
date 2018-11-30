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
public class Empresa implements IEmpresa{
    
    private int id;
    private String nome;
    private String endereco;
 
    public Empresa(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }
   
    public Empresa() {
       
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
 
    public String getEndereco() {
        return endereco;
    }
 
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
   
    public void salvarEmpresa() {
        try {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into tb_empresa(nome, endereco) values (?,?)";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, this.getNome());
        pstmt.setString(2, this.getEndereco());
        pstmt.execute();
        pstmt.close();
        conexao.close();
        System.out.println("Empresa salva");
        } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
        }
    }
   
    public List<Empresa> listarEmpresa() {
    List<Empresa> empresas = new ArrayList<Empresa>();
    try {
        Connection conexao = new Conexao().getConexao();
        String sql = "select * from tb_empresa";
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Empresa empresa = new Empresa(getId(), getNome(), getEndereco());
            empresa.setId(rs.getInt("id"));
            empresa.setNome(rs.getString("nome"));
            empresa.setEndereco(rs.getString("endereco"));
            empresas.add(empresa);
        }
        rs.close();
        pstmt.close();
        conexao .close();
        return empresas;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
