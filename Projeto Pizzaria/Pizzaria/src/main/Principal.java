package main;

import java.util.Scanner;

import clientes.cadastroClientes;
import funcionarios.cadastroFuncionarios;
import pedidos.cadastroPedidos;

public class Principal {
    public static void main(String[] args) {

        // Cria instâncias das classe cadastroPedidos e cadastroClientes e a armazena na variáveis cadastro e cadastro2.
        cadastroClientes cadastro  = new cadastroClientes();
        cadastroPedidos cadastro2 = new cadastroPedidos();
        cadastroFuncionarios cadastro3 = new cadastroFuncionarios();

        // Chama o método menuPrincipal para iniciar o menu, passando como parâmetros as instâncias de cadastroClientes e cadastroPedidos.
        menuPrincipal(cadastro, cadastro2, cadastro3);
    }

    public static void menuPrincipal(cadastroClientes cadastro, cadastroPedidos cadastro2, cadastroFuncionarios cadastro3) {
        // Cria um novo objeto Scanner para ler a entrada do usuário
        Scanner src = new Scanner(System.in);

        // Exibe o cabeçalho do menu
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Menu Principal------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar Cliente   |");
        System.out.println("|   Opcao 2 - Cadastrar Pedidos   |");
        System.out.println("|   Opcao 3 - Cadastrar Funcionarios   |");
        System.out.println("|   Opcao 4 - Sair  |");

        // Lê a opção escolhida pelo usuário
        int opcao = src.nextInt();

        switch (opcao) {
            case 1:
                // Se a opção for 1, chama o método para cadastrar clientes

                cadastro.menuCadastrarCliente(cadastro, cadastro2, cadastro3);
                break;
            case 2:
                // Se a opção for 2, chama o método para cadastrar pedidos
                cadastro2.menuCadastrarPedidos(cadastro, cadastro2, cadastro3);
                break;
            case 3:
                // Se a opção for 3, chama o método para cadastrar funcionarios
                cadastro3.menuCadastrarFuncionarios(cadastro, cadastro2, cadastro3);
                break;
            case 4:
                // Se a opção for 3, encerra o programa
                System.exit(0);
                break;
            default:
                // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                System.out.println("Opcao invalida");
                menuPrincipal(cadastro, cadastro2,cadastro3);
                break;
        }
        src.close();
    }
}
