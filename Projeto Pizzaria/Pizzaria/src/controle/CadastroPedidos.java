package controle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Pedido;
import entidades.Pizza;
import main.Principal;

public class CadastroPedidos {

    // Cria um objeto Scanner
    private static Scanner src = new Scanner(System.in);
    // Cria uma lista de pedidos para armazenar os objetos Pedido
    public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    // Criando um método get para chamar os pedidos do array
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    // Método que exibe o menu de cadastro de pedidos
    public void menuCadastrarPedidos(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios, Cardapio cardapio) {
        try {
            while (true) {
                // Exibe o cabeçalho do menu
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("---------------------------Cadastro Pedidos------------------------");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("*******Selecione a operacao que deseja realizar*******");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("|   Opcao 1 - Cadastrar   |");
                System.out.println("|   Opcao 2 - Listar Todos Pedidos   |");
                System.out.println("|   Opcao 3 - Pesquisar Pedido   |");
                System.out.println("|   Opcao 4 - Atualizar Pedido   |");
                System.out.println("|   Opcao 5 - Deletar Pedido   |");
                System.out.println("|   Opcao 6 - Voltar ao menu principal   |");

                try {
                    // Lê a opção escolhida pelo usuário
                    int opcao = src.nextInt();

                    // Avalia a opção escolhida usando uma estrutura switch
                    switch (opcao) {
                        case 1:
                            // Se a opção for 1, chama o método para cadastrar um pedido
                            cadastrarPedidos(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
                            break;
                        case 2:
                            // Se a opção for 2, chama o método para listar todos os pedidos
                            listarPedidos(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 3:
                            // Se a opção for 3, chama o método para pesquisar um pedido
                            pesquisarPedido(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 4:
                            // Se a opção for 4, chama o método para atualizar o pedido
                            atualizarPedido(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
                            break;
                        case 5:
                            // Se a opção for 5, chama o método para deletar o pedido
                            deletarPedido(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 6:
                            // Se a opção for 6, volta para o menu principal
                            Principal.menuPrincipal(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
                            break;
                        default:
                            // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                            System.out.println("Opção inválida!");
                            menuCadastrarPedidos(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida! Por favor, digite uma opção válida.");
                    src.next();
                }
            }
        } catch (IllegalStateException e) {
            // Se ocorrer algum erro, exibe uma mensagem de erro e chama o menu novamente
            System.out.println("Ocorreu um erro!");
        }
    }

    private void cadastrarPedidos(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios, Cardapio cardapio) {
        // Obtém a lista de clientes
        ArrayList<Cliente> clientes = cadastroClientes.getClientes();
        // Exibe a lista de clientes cadastrados
        System.out.println("Lista de Clientes Cadastrados: ");
        System.out.printf("%-5s %-20s %-30s %-30s %-20s %-15s\n", "ID", "Nome", "Endereço", "Email", "Telefone", "CPF");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de clientes e exibe cada cliente formatado
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Solicita ao usuário o ID do cliente para registrar o pedido
        System.out.println("Digite o id do cliente para registrar o pedido do mesmo: ");
        int idCliente = src.nextInt();
        src.nextLine();

        Cliente clienteSelecionado = null; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de clientes para verificar se o ID fornecido existe
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                clienteSelecionado = cliente;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado!");
            return; // Para evitar continuar a execução do método
        }

        // Exibe o nome do cliente selecionado se encontrado
        System.out.println("Nome do Cliente: " + clienteSelecionado.getNome());

        // Solicita ao usuário o sabor da pizza
        System.out.println("Selecione a Pizza: " + "\n");
        Pizza pizzaSelecionada = selecionarPizza(cardapio);

        // Solicita ao usuário o tipo de pagamento
        String pagamento = selecionarMetodoPagamento();

        // Cria um novo objeto Pedido e adiciona à lista de pedidos
        Pedido pedido = new Pedido(idCliente, clienteSelecionado, pagamento, pizzaSelecionada);
        pedidos.add(pedido);

        // Exibe uma mensagem de sucesso
        System.out.println("Pedido de " + clienteSelecionado.getNome() + " cadastrado com sucesso!");
    }

    private void listarPedidos(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos, CadastroFuncionarios cadastroFuncionarios) {
        // Exibe a mensagem indicando que os pedidos cadastrados serão listados
        System.out.println("***Pedidos Cadastrados!*** \n");

        // Exibe o cabeçalho da tabela de pedidos
        System.out.println(Pedido.getCabecalhoPedido());
        System.out.println(
                "----------------------------------------------------------");

        // Percorre a lista de pedidos e exibe cada pedido formatado
        for (Pedido pedido : pedidos) {
            System.out.printf("%-5d %-15d %-30s\n",
                    pedido.getIdPedido(), pedido.getId(), pedido.getCliente().getNome());
        }
    }

    private void pesquisarPedido(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos, CadastroFuncionarios cadastroFuncionarios) {
        src.nextLine();

        // Solicita ao usuário que digite o nome do cliente para pesquisar o pedido
        System.out.println("Digite o nome do cliente que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false; // Variável para indicar se o pedido foi encontrado

        // Exibe o cabeçalho da tabela de pedidos
        System.out.println(Pedido.getCabecalhoPedidoEspecifico());
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre a lista de pedidos para localizar o pedido do cliente com o nome
        // fornecido
        for (Pedido pedido : pedidos) {
            String[] espacoNome = pedido.getCliente().getNome().split(" ");

            // Verifica se o nome completo do cliente no pedido corresponde ao nome
            // fornecido
            if (pedido.getCliente().getNome().equals(nome)) {
                System.out.println(pedido); // Exibe os detalhes do pedido encontrado
                encontrado = true;
            }
            // Verifica se a primeira palavra do nome do cliente no pedido corresponde ao
            // nome fornecido
            else if (espacoNome[0].equals(nome)) {
                System.out.println(pedido); // Exibe os detalhes do pedido encontrado
                encontrado = true;
            }
        }

        // Se o pedido não foi encontrado, exibe uma mensagem indicando isso
        if (!encontrado) {
            System.out.println("Pedido nao encontrado!");
        }
    }

    private Pizza selecionarPizza(Cardapio cardapio) {
        cardapio.exibirCardapio();
        System.out.print("Selecione o número da pizza: ");
        int numeroPizza = src.nextInt();
        src.nextLine(); // Limpa o buffer

        if (numeroPizza > 0 && numeroPizza <= cardapio.getPizzas().size()) {
            Pizza pizzaSelecionada = cardapio.getPizzas().get(numeroPizza - 1);
            System.out.println("\nVocê selecionou:");
            System.out.println(pizzaSelecionada);
            return pizzaSelecionada;
        } else {
            System.out.println("Número de pizza inválido! Tente novamente.");
            return selecionarPizza(cardapio);
        }
    }

    private String selecionarMetodoPagamento() {
        String pagamento = "";

        while (pagamento.isEmpty()) {
            // Solicita ao usuário o tipo de pagamento
            System.out.println("Selecione o método de pagamento:");
            System.out.println("1 - PIX");
            System.out.println("2 - CARTÃO");
            System.out.println("3 - DINHEIRO");

            int opcaoPagamento = src.nextInt();
            src.nextLine(); // Limpa o buffer do scanner

            switch (opcaoPagamento) {
                case 1:
                    pagamento = "PIX";
                    break;
                case 2:
                    pagamento = "CARTÃO";
                    break;
                case 3:
                    pagamento = "DINHEIRO";
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, selecione uma opção válida.");
                    break;
            }
        }

        return pagamento;
    }

    private void atualizarPedido(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
    CadastroFuncionarios cadastroFuncionarios, Cardapio cardapio) {

         // Obtém a lista de pedidos
        ArrayList<Pedido> pedidos = cadastroPedidos.getPedidos();
        // Exibe o cabeçalho da tabela de pedidos
        System.out.println(Pedido.getCabecalhoPedidoEspecifico());
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre a lista de pedidos e exibe cada pedido formatado
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }

        // Solicita ao usuário o ID do pedido para registrar o pedido
        System.out.println("Digite o id do pedido que deseja atualizar: ");
        int idpedido = src.nextInt();
        src.nextLine();

        Pedido pedidoSelecionado = null; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de pedidos para verificar se o ID fornecido existe
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idpedido) {
                pedidoSelecionado = pedido;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (pedidoSelecionado != null) {
            // Exibe o nome do pedido selecionado se encontrado
            System.out.println("Nome do cliente: " + pedidoSelecionado.getCliente());
        
        } else {
            System.out.println("Pedido não encontrado!");
            return; // Sai do método, pois o pedido não foi encontrado
        }

        System.out.println("Digite as novas informações do pedido:");

        System.out.println("Novo pagamento: ");
        String pagamento = "";

        while (pagamento.isEmpty()) {
            // Solicita ao usuário o tipo de pagamento
            System.out.println("Selecione o método de pagamento:");
            System.out.println("1 - PIX");
            System.out.println("2 - CARTÃO");
            System.out.println("3 - DINHEIRO");

            int novoPagamento = src.nextInt();
            src.nextLine(); // Limpa o buffer do scanner

            switch (novoPagamento) {
                case 1:
                    pagamento = "PIX";
                    break;
                case 2:
                    pagamento = "CARTÃO";
                    break;
                case 3:
                    pagamento = "DINHEIRO";
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, selecione uma opção válida.");
                    break;
            }
        }

        System.out.println("Nova Pizza: ");
        
        cardapio.exibirCardapio();
        System.out.print("Selecione o número da pizza: ");
        int novaPizza = src.nextInt();
        src.nextLine(); // Limpa o buffer

        if (novaPizza > 0 && novaPizza <= cardapio.getPizzas().size()) {
            Pizza pizzaSelecionada = cardapio.getPizzas().get(novaPizza - 1);
            System.out.println("\nVocê selecionou:");
            System.out.println(pizzaSelecionada);
            pedidoSelecionado.setPizza(pizzaSelecionada);
        } else {
            System.out.println("Número de pizza inválido! Tente novamente.");
            return;
        }

        if(!pagamento.isEmpty()){
        pedidoSelecionado.setPagamento(pagamento);
        }

        System.out.println("pedido atualizado com sucesso!");
        
    }

    private void deletarPedido(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {

        // Obtém a lista de pedidos
        ArrayList<Pedido> pedidos = cadastroPedidos.getPedidos();
       // Exibe o cabeçalho da tabela de pedidos
       System.out.println(Pedido.getCabecalhoPedidoEspecifico());
       System.out.println(
               "-------------------------------------------------------------------------------------------------");

        // Percorre a lista de pedidos e exibe cada pedido formatado
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }

        // Solicita ao usuário o ID do pedido para registrar o pedido
        System.out.println("Digite o id do pedido que deseja deletar: ");
        int idpedido = src.nextInt();
        src.nextLine();

        Pedido pedidoSelecionado = null; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de pedidos para verificar se o ID fornecido existe
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idpedido) {
                pedidoSelecionado = pedido;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (pedidoSelecionado == null) {
            System.out.println("Pedido não encontrado!");
            return; // Sai do método, pois o pedido não foi encontrado
        } 
            
        // Exibe o nome do pedido selecionado se encontrado
        System.out.println("Nome do cliente: " + pedidoSelecionado.getCliente().getNome());

        // Confirma se o usuário deseja deletar o pedido
        System.out.println("Tem certeza que deseja deletar o pedido " + pedidoSelecionado.getCliente().getNome() + "? (S/N)");
        String resposta = src.nextLine().toUpperCase();

        if(resposta.equals("S")){
            int indiceDopedidoRemovido = pedidos.indexOf(pedidoSelecionado);
            pedidos.remove(pedidoSelecionado);
            System.out.println("Pedido removido com sucesso");
            for (Pedido pedido : pedidos.subList(indiceDopedidoRemovido, pedidos.size())) {
                pedido.setIdPedido(pedido.getIdPedido() - 1); 
            }
        } else {
            System.out.println("Pedido não removido");
        }
       
    }
}
