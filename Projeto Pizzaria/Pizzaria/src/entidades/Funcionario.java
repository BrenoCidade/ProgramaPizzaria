package entidades;
import java.text.NumberFormat;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private int count = 4;
    private int id;
    private double salario;
    private String funcao;

    public Funcionario (String nome, String email, String telefone, String cpf, double salario, String funcao) {
        super(nome, email, telefone, cpf);
        this.salario = salario;
        this.funcao = funcao;
        this.id = count;
        count++;
    }

    public Funcionario (String nome, String telefone, String cpf, double salario, String funcao) {
        super(nome, telefone, cpf);
        this.salario = salario;
        this.funcao = funcao;
        this.id = count;
        count++;
    }

    public Funcionario (int id, String nome, String email, String telefone, String cpf, double salario, String funcao) {
        super(nome, email, telefone, cpf);
        this.salario = salario;
        this.funcao = funcao;
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     // Método para retornar o cabeçalho formatado para exibição de Funcionarios especificos
     public static String getCabecalhoFuncionarioEspecifico() {
        return String.format("%-5s %-20s %-30s %-30s %-20s %-15s %-20s", "Id", "Nome", "Endereco", "Telefone",
                "CPF", "Salario", "Funcao");
    }

    // Método para retornar o cabeçalho formatado para exibição de Funcionarios
    public static String getCabecalhoFuncionario() {
        return String.format("%-5s %-20s %-30s", "Id", "Nome", "Email");
    }

    // Para retornar uma representação formatada do Funcionario
    public String toString() {
        Locale localBrasil = Locale.getDefault();
        NumberFormat formatoMoedaBrasil = NumberFormat.getCurrencyInstance(localBrasil);
        String salarioFormatado = formatoMoedaBrasil.format(salario);
        return String.format("%-5d %-20s %-30s %-30s %-20s %-15s %-20s", id, nome, email, telefone, cpf, salarioFormatado, funcao);
    }

    
}
