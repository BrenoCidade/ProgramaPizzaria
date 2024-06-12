package entidades;

public class Pedido {
    
    // Variável para gerar IDs únicos para cada pedido
    private static int count = 1;

    // Atributos de um pedido
    private int id, idPedido;
    private String pagamento;
    private Cliente cliente;
    private Pizza pizza;

    // Construtor para criar um novo pedido com ID automático
    public Pedido(int id, Cliente cliente, String pagamento, Pizza pizza) {
        this.idPedido = count++;
        this.id = id;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.pizza = pizza;
    }

    // Métodos getters e setters para acessar e modificar os atributos do pedido
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para retornar o cabeçalho formatado para exibição de pedidos
    public static String getCabecalhoPedido() {
        return String.format("%-5s %-15s %-30s", "Id", "Id do Cliente", "Cliente");
    }

    // Método para retornar o cabeçalho formatado para exibição de pedidos especificos
    public static String getCabecalhoPedidoEspecifico() {
        return String.format("%-5s %-15s %-30s %-30s %-20s", "Id", "Id do Cliente", "Cliente", "Pizza", "Pagamento");
    }

    // Para retornar uma representação formatada do pedido
    public String toString() {
        return String.format("%-5d %-15d %-30s %-30s %-20s", idPedido, id, cliente.getNome(), pizza.getNome(), pagamento);
    }

}
