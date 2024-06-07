package funcionarios;

import java.util.Scanner;

import clientes.cadastroClientes;
import main.Principal;
import pedidos.cadastroPedidos;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class cadastroFuncionarios {
    // Cria um objeto Scanner
    private Scanner src = new Scanner(System.in);

    // Cria uma lista de Funcionarios para armazenar os objetos Funcionario
    private ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();

    // Criando um método get para chamar os pedidos do array
    public ArrayList<Funcionario> getFuncionarios() {
        return Funcionarios;
    }

    // Funcionarios pré-setados com alguns dados
    public cadastroFuncionarios() {
        Funcionarios.add(new Funcionario(1, "FELIPE", "felipe@gmail.com", "(71) 97171-5146", "62201965030", 2000, "Atendente"));
        Funcionarios.add(new Funcionario(2, "LORENA", "lorena@gmail.com", "(71) 98230-7228", "32577984073", 5000, "Gerente"));
        Funcionarios.add(new Funcionario(3, "BRENO CIDADE", "breno@gmail.com", "(71) 96702-8546", "01578745080", 2000,
                "Atendente"));
    }

    // Método que exibe o menu de cadastro de Funcionarios
    public void menuCadastrarFuncionarios(cadastroClientes cadastro, cadastroPedidos cadastro2,
            cadastroFuncionarios cadastro3) {
        try {
            while (true) {
                // Exibe o cabeçalho do menu
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("---------------------------Cadastro Funcionarios------------------------");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("*******Selecione a operacao que deseja realizar*******");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("|   Opcao 1 - Cadastrar   |");
                System.out.println("|   Opcao 2 - Listar Todos Funcionarios   |");
                System.out.println("|   Opcao 3 - Pesquisar Funcionario   |");
                System.out.println("|   Opcao 4 - Voltar ao menu principal   |");

                try {
                    // Lê a opção escolhida pelo usuário
                    int opcao = src.nextInt();
                    src.nextLine();

                    switch (opcao) {
                        case 1:
                            // Se a opção for 1, chama o método para cadastrar um Funcionario
                            cadastrarFuncionarios(cadastro, cadastro2, cadastro3);
                            break;
                        case 2:
                            // Se a opção for 2, chama o método para listar todos os Funcionarios
                            listarFuncionarios(cadastro, cadastro2, cadastro3);
                            break;
                        case 3:
                            // Se a opção for 3, chama o método para pesquisar um Funcionario
                            pesquisarFuncionario(cadastro, cadastro2, cadastro3);
                            break;
                        case 4:
                            // Se a opção for 4, volta ao menu principal
                            Principal.menuPrincipal(cadastro, cadastro2, cadastro3);
                            break;
                        default:
                            // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                            System.out.println("Opcao invalida");
                            menuCadastrarFuncionarios(cadastro, cadastro2, cadastro3);
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

    public void cadastrarFuncionarios(cadastroClientes cadastro, cadastroPedidos cadastro2,
            cadastroFuncionarios cadastro3) {
        // Solicita e lê o nome do Funcionario
        System.out.print("Nome do Funcionario: ");
        String nome = src.nextLine().toUpperCase(); // Converte o nome para letras maiúsculas

        // Solicita e lê o CPF do Funcionario
        System.out.println("CPF do Funcionario: ");
        String cpf = src.next();

        // Solicita e lê o email do Funcionario
        System.out.println("Email do Funcionario: ");
        String email = src.next();
        src.nextLine();

        // Solicita e lê o telefone do Funcionario
        System.out.println("Telefone do Funcionario: ");
        String telefone = src.nextLine();

        // Solicita e lê o endereço do Funcionario
        System.out.println("Salario do Funcionario: ");
        double salario = src.nextDouble();
        src.nextLine();

        // Solicita e lê a funcao do Funcionario
        System.out.println("Funcao do Funcionario: ");
        String funcao = src.nextLine();

        // Cria um novo objeto Funcionario com os dados fornecidos
        Funcionario Funcionario = new Funcionario(nome, email, telefone, cpf, salario, funcao);

        // Adiciona o novo Funcionario à lista de Funcionarios
        Funcionarios.add(Funcionario);

        // Confirma o cadastro do Funcionario
        System.out.println(Funcionario.getNome() + " cadastrado com sucesso!");
    }

    private void listarFuncionarios(cadastroClientes cadastro, cadastroPedidos cadastro2,
            cadastroFuncionarios cadastro3) {
        // Exibe a mensagem indicando que os Funcionarios cadastrados serão listados
        System.out.println("Funcionario Cadastrados! \n");

        // Exibe o cabeçalho da tabela de Funcionarios
        System.out.println(Funcionario.getCabecalhoFuncionario());
        System.out.println(
                "----------------------------------------------------------");

        // Percorre a lista de Funcionarios e exibe cada Funcionario em um formato
        // tabulado
        for (Funcionario Funcionario : Funcionarios) {
            System.out.printf("%-5d %-20s %-30s\n",
                    Funcionario.getId(), Funcionario.getNome(), Funcionario.getEmail());
        }

    }

    private void pesquisarFuncionario(cadastroClientes cadastro, cadastroPedidos cadastro2,
            cadastroFuncionarios cadastro3) {
        // Solicita ao usuário que digite o nome do Funcionario que deseja pesquisar
        System.out.println("Digite o nome do Funcionario que deseja pesquisar: ");
        String nome = src.nextLine().toUpperCase();

        boolean encontrado = false; // Variável para indicar se o Funcionario foi encontrado

        // Exibe o cabeçalho da tabela de Funcionarios
        System.out.println(Funcionario.getCabecalhoFuncionarioEspecifico());
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de Funcionarios para localizar o Funcionario com o nome
        // fornecido
        for (Funcionario Funcionario : Funcionarios) {
            // Divide o nome do Funcionario em palavras para verificar o nome parcial
            String[] espacoNome = Funcionario.getNome().split(" ");

            // Verifica se o nome completo do Funcionario corresponde ao nome fornecido
            if (Funcionario.getNome().equals(nome)) {
                System.out.println(Funcionario); // Exibe os detalhes do Funcionario encontrado
                encontrado = true;
            }
            // Verifica se a primeira palavra do nome do Funcionario corresponde ao nome
            // fornecido
            else if (espacoNome[0].equals(nome)) {
                System.out.println(Funcionario); // Exibe os detalhes do Funcionario encontrado
                encontrado = true;
            }
        }

        // Se o Funcionario não foi encontrado, exibe uma mensagem indicando isso
        if (!encontrado) {
            System.out.println("Funcionario nao encontrado!");
        }
    }
}
