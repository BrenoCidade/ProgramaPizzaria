package main;

import java.util.ArrayList;

import java.util.Scanner;

import negocio.Cliente;
import negocio.Pedido;

public class cadastroPedidos {

    private static Scanner src = new Scanner(System.in);
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public static void menuCadastrarPedidos() {

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Pedidos------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar Todos Pedidos   |");
        System.out.println("|   Opcao 3 - Pesquisar Pedido   |");
        System.out.println("|   Opcao 4 - Voltar para o menu anterior   |");
        int opcao = src.nextInt();

        switch (opcao) {
            case 1:
                cadastrarPedidos();
                break;
            case 2:
                listarPedidos();
                break;
            case 3:
                pesquisarPedido();
                break;
            case 4:
                cadastroClientes.menuCadastrarCliente();
                break;
            default:
                System.out.println("Opção inválida!");
                menuCadastrarPedidos();
        }
    }

    private static void cadastrarPedidos() {
        System.out.println("Lista de Clientes Cadastrados: ");

        System.out.printf("%-5s %-20s %-30s %-30s %-20s %-15s\n", "ID", "Nome", "Endereço", "Email", "Telefone", "CPF");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        for (Cliente cliente : cadastroClientes.clientes) {
            System.out.println(cliente);
        }

        System.out.println("Digite o id do cliente para registrar o pedido do mesmo: ");
        int idCliente = src.nextInt();
        src.nextLine();

        boolean idEncontrado = false;
        for (Cliente cliente : cadastroClientes.clientes) {
            if (cliente.getId() == idCliente) {
                idEncontrado = true;
                break;
            }
        }

        if (!idEncontrado) {
            System.out.println("Cliente não encontrado!");
            menuCadastrarPedidos();
        }

        Cliente clienteSelecionado = null;
        for (Cliente cliente : cadastroClientes.clientes) {
            if  (cliente.getId() == idCliente) {
                clienteSelecionado = cliente;
                break;
            }
        }

        if (clienteSelecionado != null) {
            System.out.println("Nome do Cliente: " + clienteSelecionado.getNome());
        }

        System.out.println("Sabor da Pizza:");
        String pizza = src.nextLine();

        System.out.println("Tipo de pagamento:");
        String pagamento = src.nextLine();

        Pedido pedido = new Pedido(idCliente, clienteSelecionado, pagamento, pizza);
        pedidos.add(pedido);

        System.out.println("Pedido de " + clienteSelecionado.getNome() + " cadastrado com sucesso!");

        menuCadastrarPedidos();
    }

    private static void listarPedidos() {
        System.out.println("***Pedidos Cadastrados!*** \n");

        System.out.println(Pedido.getCabecalhoPedido());
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (Pedido pedido : pedidos) {
            System.out.printf("%-5d %-15d %-30s %-30s %-20s\n",
            pedido.getIdPedido(), pedido.getId(), pedido.getCliente().getNome(), pedido.getPizza(), pedido.getPagamento());
        }

        menuCadastrarPedidos();
    }

    private static void pesquisarPedido() {
        src.nextLine();

        System.out.println("Digite o nome do cliente que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false;

        System.out.println(Pedido.getCabecalhoPedido());
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (Pedido pedido : pedidos) {
            String[] espacoNome = pedido.getCliente().getNome().split(" ");

            if (pedido.getCliente().getNome().equals(nome)) {
                System.out.println(pedido);
                encontrado = true;
            }

            else if (espacoNome[0].equals(nome)) {
                System.out.println(pedido);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Pedido nao encontrado!");
        }

        menuCadastrarPedidos();
    }

}
