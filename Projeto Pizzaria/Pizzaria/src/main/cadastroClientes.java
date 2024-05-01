package main;

import java.util.Scanner;

import negocio.Cliente;

public class cadastroClientes {
    private static Scanner src = new Scanner(System.in);
    private static final int maxClientes = 100;
    private static Cliente[] clientes = new Cliente[maxClientes];
    private static int totalClientes = 0;

    private static Cliente cliente1 = new Cliente(1, "Felipe", "Avenida Luis Viana", "felipe@gmail.com",
            "(71) 97171-5146", "62201965030");
    private static Cliente cliente2 = new Cliente(2, "Lorena", "Pituba", "lorena@gmail.com", "(71) 98230-7228",
            "32577984073");
    private static Cliente cliente3 = new Cliente(3, "Breno", "Tancredo Neves", "breno@gmail.com", "(71) 96702-8546",
            "01578745080");
    private static Cliente cliente4 = new Cliente(4, "Caio", "Itaigara", "caio@gmail.com", "(71) 98640-6759",
            "89247616093");
    private static Cliente cliente5 = new Cliente(5, "Arthur", "Mussurunga", "arthur@gmail.com", "(71) 97497-0095",
            "40511362056");
    private static Cliente cliente6 = new Cliente(6, "Eduarda", "Piatã", "eduarda@gmail.com", "(71) 97174-6881",
            "63370537028");
    private static Cliente cliente7 = new Cliente(7, "Bruno", "Avenida Orlando Gomes", "bruno@gmail.com",
            "(71) 98637-1674", "58929896073");

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

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);
        System.out.println(cliente5);
        System.out.println(cliente6);
        System.out.println(cliente7);
        if (totalClientes > 0) {

            for (int i = 0; i < totalClientes; i++) {
                System.out.println(clientes[i] + "\n");
            }
        }
        menu();
    }
}