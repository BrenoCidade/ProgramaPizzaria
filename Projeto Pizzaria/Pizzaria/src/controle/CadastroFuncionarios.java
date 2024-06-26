package controle;

import java.util.Scanner;

import entidades.Funcionario;
import main.Principal;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class CadastroFuncionarios {
    // Cria um objeto Scanner
    private Scanner src = new Scanner(System.in);

    // Cria uma lista de Funcionarios para armazenar os objetos Funcionario
    private ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();

    // Criando um método get para chamar os pedidos do array
    public ArrayList<Funcionario> getFuncionarios() {
        return Funcionarios;
    }

    // Funcionarios pré-setados com alguns dados
    public CadastroFuncionarios() {
        Funcionarios.add(new Funcionario(1, "FELIPE", "felipe@gmail.com", "(71) 97171-5146", "62201965030", 2000, "Atendente"));
        Funcionarios.add(new Funcionario(2, "LORENA", "lorena@gmail.com", "(71) 98230-7228", "32577984073", 5000, "Gerente"));
        Funcionarios.add(new Funcionario(3, "BRENO CIDADE", "breno@gmail.com", "(71) 96702-8546", "01578745080", 2000,
                "Atendente"));
    }

    // Método que exibe o menu de cadastro de Funcionarios
    public void menuCadastrarFuncionarios(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios, Cardapio cardapio) {
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
                System.out.println("|   Opcao 4 - Atualizar Funcionario   |");
                System.out.println("|   Opcao 5 - Deletar Funcionario   |");
                System.out.println("|   Opcao 6 - Voltar ao menu principal   |");

                try {
                    // Lê a opção escolhida pelo usuário
                    int opcao = src.nextInt();
                    src.nextLine();

                    switch (opcao) {
                        case 1:
                            // Se a opção for 1, chama o método para cadastrar um Funcionario
                            cadastrarFuncionarios(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 2:
                            // Se a opção for 2, chama o método para listar todos os Funcionarios
                            listarFuncionarios(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 3:
                            // Se a opção for 3, chama o método para pesquisar um Funcionario
                            pesquisarFuncionario(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 4:
                            // Se a opção for 4, chama o método para atualizar um Funcionario
                            atualizarFuncionario(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 5:
                            // Se a opção for 5, chama o método para deletar um Funcionario
                            deletarFuncionario(cadastroClientes, cadastroPedidos, cadastroFuncionarios);
                            break;
                        case 6:
                            // Se a opção for 6, volta ao menu principal
                            Principal.menuPrincipal(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
                            break;
                        default:
                            // Se a opção for inválida, exibe uma mensagem de erro e chama o menu novamente
                            System.out.println("Opcao invalida");
                            menuCadastrarFuncionarios(cadastroClientes, cadastroPedidos, cadastroFuncionarios, cardapio);
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

    public void cadastrarFuncionarios(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {
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

    private void listarFuncionarios(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {
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

    private void pesquisarFuncionario(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {
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
            if (Funcionario.getNome().toUpperCase().contains(nome)) {
                System.out.println(Funcionario); // Exibe os detalhes do Funcionario encontrado
                encontrado = true;
            }
            // Verifica se a primeira palavra do nome do Funcionario corresponde ao nome
            // fornecido
            else if (espacoNome[0].toUpperCase().contains(nome)) {
                System.out.println(Funcionario); // Exibe os detalhes do Funcionario encontrado
                encontrado = true;
            }
        }

        // Se o Funcionario não foi encontrado, exibe uma mensagem indicando isso
        if (!encontrado) {
            System.out.println("Funcionario nao encontrado!");
        }
    }

    private void atualizarFuncionario(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
    CadastroFuncionarios cadastroFuncionarios) {
         // Obtém a lista de funcionarios
        ArrayList<Funcionario> funcionarios = cadastroFuncionarios.getFuncionarios();
        // Exibe a lista de funcionarios cadastrados
        System.out.println("Lista de funcionarios Cadastrados: ");
        System.out.printf("%-5s %-20s %-30s %-30s %-20s %-15s\n", "ID", "Nome", "Endereço", "Email", "Telefone", "CPF");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de funcionarios e exibe cada funcionario formatado
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        // Solicita ao usuário o ID do funcionario para registrar o pedido
        System.out.println("Digite o id do funcionario que deseja atualizar: ");
        int idFuncionario = src.nextInt();
        src.nextLine();

        Funcionario funcionarioSelecionado = null; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de funcionarios para verificar se o ID fornecido existe
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == idFuncionario) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (funcionarioSelecionado == null) {
            System.out.println("Funcionario não encontrado!");
            return; // Para evitar continuar a execução do método
        }

        // Exibe o nome do funcionario selecionado se encontrado
        System.out.println("Nome do funcionario: " + funcionarioSelecionado.getNome());

        System.out.println("Digite as novas informações do funcionario:");

        System.out.println("Novo nome: ");
        String novoNome = src.nextLine().toUpperCase();

        System.out.println("Novo email: ");
        String novoEmail = src.nextLine();

        System.out.println("Novo telefone: ");
        String novoTelefone = src.nextLine();

        System.out.println("Novo salario: ");
        String novoSalarioInput = src.nextLine();
        Double novoSalario = novoSalarioInput.isEmpty() ? null : Double.parseDouble(novoSalarioInput);

        System.out.println("Nova funcao: ");
        String novaFuncao= src.nextLine();

        if(!novoNome.isEmpty()){
            funcionarioSelecionado.setNome(novoNome);
        }

        if(!novoEmail.isEmpty()){
        funcionarioSelecionado.setEmail(novoEmail);
        }

        if(!novoTelefone.isEmpty()){
        funcionarioSelecionado.setTelefone(novoTelefone);
        }

        if(novoSalario != null && novoSalario != 0.0){
            funcionarioSelecionado.setSalario(novoSalario);
        }

        if(!novaFuncao.isEmpty()){
            funcionarioSelecionado.setTelefone(novaFuncao);
        }
    
        System.out.println("funcionario atualizado com sucesso!");
        
    }

    private void deletarFuncionario(CadastroClientes cadastroClientes, CadastroPedidos cadastroPedidos,
            CadastroFuncionarios cadastroFuncionarios) {

        // Obtém a lista de funcionarios
        ArrayList<Funcionario> funcionarios = cadastroFuncionarios.getFuncionarios();
        // Exibe a lista de funcionarios cadastrados
        System.out.println("Lista de funcionarios Cadastrados: ");
        System.out.printf("%-5s %-20s %-30s %-30s %-20s %-15s\n", "ID", "Nome", "Endereço", "Email", "Telefone", "CPF");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        // Percorre a lista de funcionarios e exibe cada funcionario formatado
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        // Solicita ao usuário o ID do funcionario para registrar o pedido
        System.out.println("Digite o id do funcionario que deseja atualizar: ");
        int idFuncionario = src.nextInt();
        src.nextLine();

        Funcionario funcionarioSelecionado = null; // Variável para verificar se o ID foi encontrado

        // Percorre a lista de funcionarios para verificar se o ID fornecido existe
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == idFuncionario) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }

        // Se o ID não foi encontrado, exibe uma mensagem e retorna ao menu de pedidos
        if (funcionarioSelecionado == null) {
            System.out.println("Funcionario não encontrado!");
            return; // Para evitar continuar a execução do método
        }

        // Exibe o nome do funcionario selecionado se encontrado
        System.out.println("Nome do funcionario: " + funcionarioSelecionado.getNome());

        // Confirma se o usuário deseja deletar o funcionario
        System.out.println("Tem certeza que deseja deletar o funcionario " + funcionarioSelecionado.getNome() + "? (S/N)");
        String resposta = src.nextLine().toUpperCase();

        if(resposta.equals("S")){
            int indiceDofuncionarioRemovido = funcionarios.indexOf(funcionarioSelecionado);
            funcionarios.remove(funcionarioSelecionado);
            System.out.println("funcionario removido com sucesso");
            for (Funcionario funcionario : funcionarios.subList(indiceDofuncionarioRemovido, funcionarios.size())) {
                funcionario.setId(funcionario.getId() - 1); 
            }
        } else {
            System.out.println("funcionario não removido");
        }
       
    }
}
