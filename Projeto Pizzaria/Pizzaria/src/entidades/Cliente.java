package entidades;

public class Cliente extends Pessoa{

    // Variável para gerar IDs únicos para cada cliente
    private static int count = 1;

    // Atributos de um cliente
    private int id;
    private String endereco;

    // Construtor para criar um novo cliente com ID automático
    public Cliente (String nome, String endereco, String email, String telefone, String cpf) {
        super(nome, endereco, email, cpf);
        this.id = count;
        this.endereco = endereco;
        this.cpf = cpf;
        Cliente.count += 1;
    }

    // Construtor para criar um novo cliente com ID pré-definido
    /*public Cliente(int id, String nome, String endereco, String email, String telefone, String cpf) {
        super(nome, email, telefone, cpf);
        this.id = id;
        this.endereco = endereco;
        this.cpf = cpf;
    }*/

    // Métodos getters e setters para acessar e modificar os atributos do cliente
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método para retornar o cabeçalho formatado para exibição de clientes especificos
    public static String getCabecalhoClienteEspecifico() {
        return String.format("%-5s %-20s %-30s %-30s %-20s %-15s", "Id", "Nome", "Endereco", "Email", "Telefone",
                "CPF");
    }

    // Método para retornar o cabeçalho formatado para exibição de clientes
    public static String getCabecalhoCliente() {
        return String.format("%-5s %-20s %-30s", "Id", "Nome", "Endereco");
    }

    // Para retornar uma representação formatada do cliente
    public String toString() {
        return String.format("%-5d %-20s %-30s %-30s %-20s %-15s", id, nome, endereco, email, telefone, cpf);
    }
}
