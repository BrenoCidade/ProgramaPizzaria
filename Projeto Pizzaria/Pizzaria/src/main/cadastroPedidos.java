package main;

import java.util.ArrayList;

import java.util.Scanner;

import negocio.Cliente;
import negocio.Pedido;

public class cadastroPedidos {

    // Cria um objeto Scanner para ser usado em todo o programa
    private static Scanner src = new Scanner(System.in);

    // Cria uma lista de pedidos para armazenar os objetos Pedido
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    // Método que exibe o menu de cadastro de pedidos
    public static void menuCadastrarPedidos() {
        // Exibe o cabeçalho do menu
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Pedidos------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar Todos Pedidos   |");
        System.out.println("|   Opcao 3 - Pesquisar Pedido   |");
        System.out.println("|   Opcao 4 - Voltar para o menu anterior   |");

        // Lê a opção escolhida pelo usuário
        int opcao = src.nextInt();

        // Avalia a opção escolhida usando uma estrutura switch
        switch (opcao) {
            case 1:
                // Se a opção for 1, chama o método para cadastrar um pedido
                cadastrarPedidos();
                break;
            case 2:
                // Se a opção for 2, chama o método para listar todos os pedidos
                listarPedidos();
                break;
            case 3:
                // Se a opção for 3, chama o método para pesquisar um pedido
                pesquisarPedido();
                break;
            case 4:
                // Se a opção for 4, volta para o menu de cadastro de clientes
                cadastroClientes.menuCadastrarCliente();
                break;
            default:
                // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                System.out.println("Opção inválida!");
                menuCadastrarPedidos();
                break;
        }
    }

    private static void cadastrarPedidos() {
        // Exibe a lista de clientes cadastrados
        System.out.println("Lista de Clientes Cadastrados: ");
        System.out.printf("%-5s %-20s %-30s %-30s %-20s %-15s\n", "ID", "Nome", "Endereço", "Email", "Telefone", "CPF");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de clientes e exibe cada cliente formatado
        for (Cliente cliente : cadastroClientes.clientes) {
            System.out.println(cliente);
        }

        // Solicita ao usuário o ID do cliente para registrar o pedido
        System.out.println("Digite o id do cliente para registrar o pedido do mesmo: ");
        int idCliente = src.nextInt();
        src.nextLine();

        boolean idEncontrado = false; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de clientes para verificar se o ID fornecido existe
        for (Cliente cliente : cadastroClientes.clientes) {
            if (cliente.getId() == idCliente) {
                idEncontrado = true;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (!idEncontrado) {
            System.out.println("Cliente não encontrado!");
            menuCadastrarPedidos();
            return; // Para evitar continuar a execução do método
        }

        Cliente clienteSelecionado = null; // Variável para armazenar o cliente selecionado

        // Percorre novamente sobre a lista de clientes para encontrar o cliente com o
        // ID
        for (Cliente cliente : cadastroClientes.clientes) {
            if (cliente.getId() == idCliente) {
                clienteSelecionado = cliente;
                break;
            }
        }

        // Exibe o nome do cliente selecionado se encontrado
        if (clienteSelecionado != null) {
            System.out.println("Nome do Cliente: " + clienteSelecionado.getNome());
        }

        // Solicita ao usuário o sabor da pizza
        System.out.println("Sabor da Pizza:");
        String pizza = src.nextLine();

        // Solicita ao usuário o tipo de pagamento
        System.out.println("Tipo de pagamento:");
        String pagamento = src.nextLine();

        // Cria um novo objeto Pedido e adiciona à lista de pedidos
        Pedido pedido = new Pedido(idCliente, clienteSelecionado, pagamento, pizza);
        pedidos.add(pedido);

        // Exibe uma mensagem de sucesso
        System.out.println("Pedido de " + clienteSelecionado.getNome() + " cadastrado com sucesso!");

        // Retorna ao menu de cadastro de pedidos
        menuCadastrarPedidos();
    }

    private static void listarPedidos() {
        // Exibe a mensagem indicando que os pedidos cadastrados serão listados
        System.out.println("***Pedidos Cadastrados!*** \n");

        // Exibe o cabeçalho da tabela de pedidos
        System.out.println(Pedido.getCabecalhoPedido());
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre a lista de pedidos e exibe cada pedido formatado
        for (Pedido pedido : pedidos) {
            System.out.printf("%-5d %-15d %-30s %-30s %-20s\n",
                    pedido.getIdPedido(), pedido.getId(), pedido.getCliente().getNome(), pedido.getPizza(),
                    pedido.getPagamento());
        }

        // Após listar todos os pedidos, volta ao menu de cadastro de pedidos
        menuCadastrarPedidos();
    }

    private static void pesquisarPedido() {
        src.nextLine();

        // Solicita ao usuário que digite o nome do cliente para pesquisar o pedido
        System.out.println("Digite o nome do cliente que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false; // Variável para indicar se o pedido foi encontrado

        // Exibe o cabeçalho da tabela de pedidos
        System.out.println(Pedido.getCabecalhoPedido());
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre a lista de pedidos para localizar o pedido do cliente com o nome fornecido
        for (Pedido pedido : pedidos) {
            String[] espacoNome = pedido.getCliente().getNome().split(" ");

            // Verifica se o nome completo do cliente no pedido corresponde ao nome fornecido
            if (pedido.getCliente().getNome().equals(nome)) {
                System.out.println(pedido); // Exibe os detalhes do pedido encontrado
                encontrado = true;
            }
            // Verifica se a primeira palavra do nome do cliente no pedido corresponde ao nome fornecido
            else if (espacoNome[0].equals(nome)) {
                System.out.println(pedido); // Exibe os detalhes do pedido encontrado
                encontrado = true;
            }
        }

        // Se o pedido não foi encontrado, exibe uma mensagem indicando isso
        if (!encontrado) {
            System.out.println("Pedido nao encontrado!");
        }

        // Após a pesquisa, volta ao menu de cadastro de pedidos
        menuCadastrarPedidos();
    }

}
