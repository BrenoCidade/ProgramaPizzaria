package main;

import java.util.Scanner;

import negocio.Cliente;

public class cadastroClientes {
    private static Scanner src = new Scanner(System.in);
    private static final int maxClientes = 100;
    private static Cliente[] clientes = new Cliente[maxClientes];
    private static int totalClientes = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Clientes------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar   |");
        System.out.println("|   Opcao 3 - Cadastrar pedido   |");
        System.out.println("|   Opcao 4 - Sair   |");

        int opcao = src.nextInt();

        switch (opcao) {
            case 1:
                cadastrarClientes();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                cadastroPedidos.menu2();
                break;

            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida");
                menu();
                break;
        }

    }

    private static void cadastrarClientes() {
        if (totalClientes < maxClientes)
            System.out.print("Nome do cliente: ");
        String nome = src.next();
        src.nextLine();

        System.out.println("CPF do cliente: ");
        String cpf = src.next();

        System.out.println("Email do cliente: ");
        String email = src.next();
        src.nextLine();

        System.out.println("Telefone do cliente: ");
        String telefone = src.nextLine();

        System.out.println("Endereco do cliente: ");
        String endereco = src.nextLine();

        Cliente cliente = new Cliente(nome, endereco, email, telefone, cpf);
        clientes[totalClientes++] = cliente;

        System.out.println(cliente.getNome() + " cadastrado com sucesso!");

        menu();
    }

    private static void listarClientes() {

        System.out.println("Cliente Cadastrados! \n");


        if (totalClientes > 0) {

            for (int i = 0; i < totalClientes; i++) {
                System.out.println(clientes[i] + "\n");
            }
        }
        menu();
    }
}
