package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import controle.CadastroClientes;
import controle.CadastroFuncionarios;
import controle.CadastroPedidos;

public class Principal {
    public static void main(String[] args) {

        // Cria instâncias das classe cadastroPedidos e cadastroClientes e a armazena na
        // variáveis cadastro e cadastro2.
        CadastroClientes cadastroClientes = new CadastroClientes();
        CadastroPedidos cadastroPedidos = new CadastroPedidos();
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();

        // Chama o método menuPrincipal para iniciar o menu, passando como parâmetros as
        // instâncias de cadastroClientes e cadastroPedidos.
        menuPrincipal(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
    }

    public static void menuPrincipal(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {
        // Cria um novo objeto Scanner para ler a entrada do usuário
        Scanner src = new Scanner(System.in);

        while (true) {
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

            try {
                // Lê a opção escolhida pelo usuário
                int opcao = src.nextInt();

                switch (opcao) {
                    case 1:
                        // Se a opção for 1, chama o método para cadastrar clientes
                        cadastroClientes.menuCadastrarClientes(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                        break;
                    case 2:
                        // Se a opção for 2, chama o método para cadastrar pedidos
                        cadastroPedidos.menuCadastrarPedidos(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                        break;
                    case 3:
                        // Se a opção for 3, chama o método para cadastrar funcionarios
                        cadastroFuncionarios.menuCadastrarFuncionarios(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                        break;
                    case 4:
                        // Se a opção for 3, encerra o programa
                        System.exit(0);
                        src.close();
                        break;
                    default:
                        // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                        System.out.println("Opcao invalida");
                        menuPrincipal(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                        break;
                }
            } catch (IllegalStateException e) {
                // Se ocorrer algum erro, exibe uma mensagem de erro e chama o menu novamente
                System.out.println("Ocorreu um erro!");
                src.next();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, digite uma opção válida.");
                src.next();
            }
        }
    }
}
