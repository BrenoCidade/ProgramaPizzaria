package controle;

import java.util.ArrayList;
import java.util.List;

import entidades.Pizza;

public class Cardapio {
    private List<Pizza> pizzas;

    public Cardapio() {
        pizzas = new ArrayList<>();
        // Adicionando algumas pizzas pré-definidas
        adicionarPizza(new Pizza("Margherita", 25.00, new String[]{"Tomate", "Queijo", "Manjericão"}));
        adicionarPizza(new Pizza("Calabresa", 30.00, new String[]{"Calabresa", "Cebola", "Azeitonas"}));
        adicionarPizza(new Pizza("Quatro Queijos", 35.00, new String[]{"Mussarela", "Parmesão", "Gorgonzola", "Catupiry"}));
        adicionarPizza(new Pizza("Pepperoni", 32.00, new String[]{"Pepperoni", "Queijo"}));
        adicionarPizza(new Pizza("Frango com Catupiry", 33.00, new String[]{"Frango", "Catupiry", "Milho"}));
        adicionarPizza(new Pizza("Portuguesa", 34.00, new String[]{"Presunto", "Cebola", "Ovo", "Azeitonas"}));
        adicionarPizza(new Pizza("Vegetariana", 31.00, new String[]{"Tomate", "Pimentão", "Cebola", "Azeitonas"}));
        adicionarPizza(new Pizza("Havaiana", 29.00, new String[]{"Presunto", "Abacaxi", "Queijo"}));
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void exibirCardapio() {
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + ". " + pizzas.get(i).getNome());
        }
    }
}
