package main;

import java.util.Scanner;
import java.util.ArrayList;
import negocio.Cliente;

public class cadastroClientes {
    // Cria um objeto Scanner para ser usado em todo o programa
    private static Scanner src = new Scanner(System.in);

    // Cria uma lista de clientes para armazenar os objetos Cliente
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    // Bloco estático para inicializar a lista de clientes com alguns dados
    // fictícios
    static {
        clientes.add(
                new Cliente(1, "FELIPE", "Avenida Luis Viana", "felipe@gmail.com", "(71) 97171-5146", "62201965030"));
        clientes.add(new Cliente(2, "LORENA", "Pituba", "lorena@gmail.com", "(71) 98230-7228", "32577984073"));
        clientes.add(
                new Cliente(3, "BRENO CIDADE", "Tancredo Neves", "breno@gmail.com", "(71) 96702-8546", "01578745080"));
        clientes.add(new Cliente(4, "CAIO", "Itaigara", "caio@gmail.com", "(71) 98640-6759", "89247616093"));
        clientes.add(new Cliente(5, "ARTHUR", "Mussurunga", "arthur@gmail.com", "(71) 97497-0095", "40511362056"));
        clientes.add(new Cliente(6, "EDUARDA", "Piatã", "eduarda@gmail.com", "(71) 97174-6881", "63370537028"));
        clientes.add(
                new Cliente(7, "BRUNO", "Avenida Orlando Gomes", "bruno@gmail.com", "(71) 98637-1674", "58929896073"));
    }

    // Método que exibe o menu de cadastro de clientes
    public static void menuCadastrarCliente() {
        // Exibe o cabeçalho do menu
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Clientes------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar Todos Clientes   |");
        System.out.println("|   Opcao 3 - Pesquisar Cliente   |");
        System.out.println("|   Opcao 4 - Voltar ao menu principal   |");

        // Lê a opção escolhida pelo usuário
        int opcao = src.nextInt();
        src.nextLine();

        switch (opcao) {
            case 1:
                // Se a opção for 1, chama o método para cadastrar um cliente
                cadastrarClientes();
                break;
            case 2:
                // Se a opção for 2, chama o método para listar todos os clientes
                listarClientes();
                break;
            case 3:
                // Se a opção for 3, chama o método para pesquisar um cliente
                pesquisarCliente();
                break;
            case 4:
                // Se a opção for 4, volta ao menu principal
                Principal.menuPrincipal();
                break;
            default:
                // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                System.out.println("Opcao invalida");
                menuCadastrarCliente();
                break;
        }
    }

    private static void cadastrarClientes() {
        // Solicita e lê o nome do cliente
        System.out.print("Nome do cliente: ");
        String nome = src.nextLine().toUpperCase(); // Converte o nome para letras maiúsculas

        // Solicita e lê o CPF do cliente
        System.out.println("CPF do cliente: ");
        String cpf = src.next();

        // Solicita e lê o email do cliente
        System.out.println("Email do cliente: ");
        String email = src.next();
        src.nextLine();

        // Solicita e lê o telefone do cliente
        System.out.println("Telefone do cliente: ");
        String telefone = src.nextLine();

        // Solicita e lê o endereço do cliente
        System.out.println("Endereco do cliente: ");
        String endereco = src.nextLine();

        // Cria um novo objeto Cliente com os dados fornecidos
        Cliente cliente = new Cliente(nome, endereco, email, telefone, cpf);

        // Adiciona o novo cliente à lista de clientes
        clientes.add(cliente);

        // Confirma o cadastro do cliente
        System.out.println(cliente.getNome() + " cadastrado com sucesso!");

        // Retorna ao menu de cadastro de clientes
        menuCadastrarCliente();
    }

    private static void listarClientes() {
        // Exibe a mensagem indicando que os clientes cadastrados serão listados
        System.out.println("Cliente Cadastrados! \n");

        // Exibe o cabeçalho da tabela de clientes
        System.out.println(Cliente.getCabecalhoCliente());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de clientes e exibe cada cliente em um formato tabulado
        for (Cliente cliente : clientes) {
            System.out.printf("%-5d %-20s %-30s %-30s %-20s %-15s\n",
                    cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getEmail(),
                    cliente.getTelefone(), cliente.getCpf());
        }

        // Após listar todos os clientes, volta ao menu de cadastro de clientes
        menuCadastrarCliente();
    }

    private static void pesquisarCliente() {
        // Solicita ao usuário que digite o nome do cliente que deseja pesquisar
        System.out.println("Digite o nome do cliente que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false; // Variável para indicar se o cliente foi encontrado

        // Exibe o cabeçalho da tabela de clientes
        System.out.println(Cliente.getCabecalhoCliente());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de clientes para localizar o cliente com o nome fornecido
        for (Cliente cliente : clientes) {
            // Divide o nome do cliente em palavras para verificar o nome parcial
            String[] espacoNome = cliente.getNome().split(" ");

            // Verifica se o nome completo do cliente corresponde ao nome fornecido
            if (cliente.getNome().equals(nome)) {
                System.out.println(cliente); // Exibe os detalhes do cliente encontrado
                encontrado = true;
            }
            // Verifica se a primeira palavra do nome do cliente corresponde ao nome
            // fornecido
            else if (espacoNome[0].equals(nome)) {
                System.out.println(cliente); // Exibe os detalhes do cliente encontrado
                encontrado = true;
            }
        }

        // Se o cliente não foi encontrado, exibe uma mensagem indicando isso
        if (!encontrado) {
            System.out.println("Cliente nao encontrado!");
        }

        // Após a pesquisa, volta ao menu de cadastro de clientes
        menuCadastrarCliente();
    }
}
