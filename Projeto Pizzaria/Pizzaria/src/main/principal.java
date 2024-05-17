package main;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner src = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Menu Principal------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar Cliente   |");
        System.out.println("|   Opcao 2 - Cadastrar Pedidos   |");
        System.out.println("|   Opcao 3 - Sair  |");

        int opcao = src.nextInt();

        switch (opcao) {
            case 1:
                cadastroClientes.menuCadastrarCliente();
                break;
            case 2:
                cadastroPedidos.menuCadastrarPedidos();;
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida");
                menuPrincipal();
                break;
        }
        src.close();
    }
}
