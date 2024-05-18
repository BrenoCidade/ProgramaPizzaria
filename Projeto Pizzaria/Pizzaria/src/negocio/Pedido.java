package negocio;

public class Pedido {
    
    private static int count = 1;

    private int id;
    private String pizza, pagamento;
    private Cliente cliente;

    public Pedido(String pagamento, String pizza, Cliente cliente) {
        this.id = count;
        this.pagamento = pagamento;
        this.pizza = pizza;
        Pedido.count += 1;
    }

    public Pedido(int id, Cliente cliente, String pagamento, String pizza) {
        this.id = id;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.pizza = pizza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        return "Id: " + this.getId() +
                "\nNome: " + this.cliente.getNome() +
                "\nSabor da pizza: " + this.getPizza() +
                "\nTipo de pagamento: " + this.getPagamento();

    }

    
}
