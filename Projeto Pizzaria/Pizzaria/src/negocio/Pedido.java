package negocio;

public class Pedido {
    
    private static int count = 1;

    private int id, idPedido;
    private String pizza, pagamento;
    private Cliente cliente;

    public Pedido(int id, Cliente cliente, String pagamento, String pizza) {
        this.idPedido = count++;
        this.id = id;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.pizza = pizza;
    }

    public int getIdPedido() {
        return idPedido;
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

    public static String getCabecalhoPedido() {
        return String.format("%-5s %-15s %-30s %-30s %-20s", "Id", "Id do Cliente", "Cliente", "Pizza", "Pagamento");
    }

    public String toString() {
        return String.format("%-5d %-15d %-30s %-30s %-20s", idPedido, id, cliente.getNome(), pizza, pagamento);
    }

    
}
