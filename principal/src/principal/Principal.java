/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
public class Principal {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        IntefaceLinhaComando interfaceLinhaComando = new IntefaceLinhaComando();
        Cliente clienteLeitura = interfaceLinhaComando.lerCliente();
        System.out.println("Nome lido: " + clienteLeitura.getNome());
        System.out.println("Email lido:" + clienteLeitura.getEmail());
        clienteLeitura.salvar();
        interfaceLinhaComando.exibirListaClientes();

    }
   
}
