/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.util.*;
/**
 *
 * @author ALUNO
 */
public class IntefaceLinhaComando {
    
     private Scanner scanner;
   
    public IntefaceLinhaComando() {
        this.scanner = new Scanner(System.in);
    }
   
    public Cliente lerCliente() {
        Cliente cliente = new Cliente();
        System.out.println("Digite o nome:");
        cliente.setNome(scanner.nextLine());
        System.out.println("Digite o email:");
        cliente.setEmail(scanner.nextLine());
        return cliente;
    }
   
    public void exibirListaClientes() {
        Cliente clienteConsulta = new Cliente();
        for (Cliente cliente: clienteConsulta.listar()) {
        System.out.println("Id: " + cliente.getId() +
        ", Nome: " + cliente.getNome() +
        ", Email: " + cliente.getEmail());
        }
    }
    
    public Empresa lerEmpresa() {
        Empresa empresa = new Empresa();
        System.out.println("Digite o nome da empresa:");
        empresa.setNome(scanner.nextLine());
        System.out.println("Digite o endereco:");
        empresa.setEndereco(scanner.nextLine());
        return empresa;
    }
    
    public void exibirListaEmpresas() {
        Empresa empresaConsulta = new Empresa();
        for (Empresa empresa: empresaConsulta.listarEmpresa()) {
        System.out.println("Id: " + empresa.getId() +
        ", Nome da empresa: " + empresa.getNome() +
        ", Endereco: " + empresa.getEndereco());
        }
    }
}
