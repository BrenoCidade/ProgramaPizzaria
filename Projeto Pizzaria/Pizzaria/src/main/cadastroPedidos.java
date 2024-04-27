package main;

import java.util.Scanner;

import negocio.Pedido;

public class cadastroPedidos {

    private static Scanner src = new Scanner(System.in);
    private static final int maxPedidos = 100;
    private static Pedido[] pedidos = new Pedido[maxPedidos];
    private static int totalPedidos = 0;

    public static void main(String[] args) {
        menu2();
    }

    public static void menu2() {

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Pedidos------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar   |");
        System.out.println("|   Opcao 3 - Voltar para o menu anterior   |");
        int opcao = src.nextInt();

        switch (opcao) {
            case 1:
                    System.out.println("Nome do Cliente: ");
                    String nomePessoa = src.next();
                    System.out.println("Sabor da Pizza:");
                    String pizza = src.next();
                    System.out.println("Tipo de pagamento:");
                    String pagamento = src.next();

                    Pedido pedido = new Pedido(pagamento, pizza, nomePessoa);
                    pedidos[totalPedidos++] = pedido;

                    System.out.println("Pedido de " + pedido.getNomePessoa() + " cadastrado com sucesso!");
                break;

            case 2:
                listarPedidos();
                break;
            case 3:
                cadastroClientes.menu();
                break;
            default:
                System.out.println("Opção inválida!");
                menu2();
        }
        menu2();
    }

    private static void listarPedidos() {
        if (totalPedidos > 0) {
            System.out.println("***Pedidos Cadastrados!*** \n");

            for (int i = 0; i < totalPedidos; i++) {
                System.out.println(pedidos[i] + "\n");
            }
        } else {
            System.out.println("Nao há Pedidos cadastrados!");
        }
        menu2();
    }
}
