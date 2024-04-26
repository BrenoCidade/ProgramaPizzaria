package negocio;

public class Pedido {
    
    private static int count = 1;

    private int id, pagamento;
    private String pizza, nomePessoa;

    public Pedido(int pagamento, String pizza, String nomePessoa) {
        this.id = count;
        this.pagamento = pagamento;
        this.pizza = pizza;
        this.nomePessoa = nomePessoa;
        Pedido.count += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.getNomePessoa() +
                "\nSabor da pizza: " + this.getPizza() +
                "\nTipo de pagamento: " + this.getPagamento();

    }

    
}
