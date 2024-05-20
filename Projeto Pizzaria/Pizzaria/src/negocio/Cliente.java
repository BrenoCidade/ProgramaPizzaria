package negocio;

public class Cliente {

    private static int count = 8;

    private int id;
    private String nome, endereco, email, telefone, cpf;

    public Cliente(String nome, String endereco, String email, String telefone, String cpf) {
        this.id = count;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        Cliente.count += 1;
    }

    public Cliente(int id, String nome, String endereco, String email, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public static String getCabecalhoCliente() {
        return String.format("%-5s %-20s %-30s %-30s %-20s %-15s", "Id", "Nome", "Endereco", "Email", "Telefone", "CPF");
    }

    public String toString() {
        return String.format("%-5d %-20s %-30s %-30s %-20s %-15s", id, nome, endereco, email, telefone, cpf);
    }

}
