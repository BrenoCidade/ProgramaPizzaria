package main;

import java.util.Scanner;

import java.util.ArrayList;

import negocio.Cliente;

public class cadastroClientes {
    private static Scanner src = new Scanner(System.in);

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    static {
        clientes.add(new Cliente(1, "FELIPE", "Avenida Luis Viana", "felipe@gmail.com", "(71) 97171-5146", "62201965030"));
        clientes.add(new Cliente(2, "LORENA", "Pituba", "lorena@gmail.com", "(71) 98230-7228", "32577984073"));
        clientes.add(new Cliente(3, "BRENO CIDADE", "Tancredo Neves", "breno@gmail.com", "(71) 96702-8546", "01578745080"));
        clientes.add(new Cliente(4, "CAIO", "Itaigara", "caio@gmail.com", "(71) 98640-6759", "89247616093"));
        clientes.add(new Cliente(5, "ARTHUR", "Mussurunga", "arthur@gmail.com", "(71) 97497-0095", "40511362056"));
        clientes.add(new Cliente(6, "EDUARDA", "Piatã", "eduarda@gmail.com", "(71) 97174-6881", "63370537028"));
        clientes.add(new Cliente(7, "BRUNO", "Avenida Orlando Gomes", "bruno@gmail.com", "(71) 98637-1674", "58929896073"));
    }

    public static void menuCadastrarCliente() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("---------------------------Cadastro Clientes------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("*******Selecione a operacao que deseja realizar*******");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   Opcao 1 - Cadastrar   |");
        System.out.println("|   Opcao 2 - Listar Todos Clientes   |");
        System.out.println("|   Opcao 3 - Pesquisar Cliente   |");
        System.out.println("|   Opcao 4 - Voltar ao menu principal   |");

        int opcao = src.nextInt();
        src.nextLine();

        switch (opcao) {
            case 1:
                cadastrarClientes();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                pesquisarCliente();
                break;
            case 4:
                Principal.menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida");
                menuCadastrarCliente();
                break;
        }
    }

    private static void cadastrarClientes() {

        System.out.print("Nome do cliente: ");
        String nome = src.nextLine().toUpperCase();

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
        clientes.add(cliente);

        System.out.println(cliente.getNome() + " cadastrado com sucesso!");

        menuCadastrarCliente();
    }

    private static void listarClientes() {

        System.out.println("Cliente Cadastrados! \n");

        System.out.println(Cliente.getCabecalhoCliente());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        for (Cliente cliente : clientes) {
            System.out.printf("%-5d %-20s %-30s %-30s %-20s %-15s\n",
            cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
        }

        menuCadastrarCliente();
    }

    private static void pesquisarCliente() {
        System.out.println("Digite o nome do cliente que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false;

        System.out.println(Cliente.getCabecalhoCliente());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        for (Cliente cliente : clientes) {
            String [] espacoNome = cliente.getNome().split(" ");

            if (cliente.getNome().equals(nome)) {
                System.out.println(cliente);
                encontrado = true;
            }

            else if (espacoNome[0].equals(nome)) {
                System.out.println(cliente);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente nao encontrado!");
        }

        menuCadastrarCliente();
    }
}
