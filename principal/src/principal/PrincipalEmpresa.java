/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author ALUNO
 */
public class PrincipalEmpresa {
    
    public static void main(String[] args){
        
        IntefaceLinhaComando interfaceLinhaComando = new IntefaceLinhaComando();
        Empresa empresaLeitura = interfaceLinhaComando.lerEmpresa();
        System.out.println("Nome lido: " + empresaLeitura.getNome());
        System.out.println("Endereco lido:" + empresaLeitura.getEndereco());
        empresaLeitura.salvarEmpresa();
        interfaceLinhaComando.exibirListaEmpresas();
        
    }
    
}
