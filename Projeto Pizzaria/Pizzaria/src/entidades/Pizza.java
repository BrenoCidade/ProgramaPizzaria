package entidades;
import java.text.NumberFormat;
import java.util.Locale;

public class Pizza {
    private String nome;
    private double preco;
    private String[] ingredientes;

    public Pizza(String nome, double preco, String[] ingredientes) {
        this.nome = nome;
        this.preco = preco;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        Locale localBrasil = Locale.getDefault();
        NumberFormat formatoMoedaBrasil = NumberFormat.getCurrencyInstance(localBrasil);
        String precoFormatado = formatoMoedaBrasil.format(preco);
        return "Pizza: " + nome + ", Preço: " + precoFormatado + ", Ingredientes: " + String.join(", ", ingredientes);
    }
}
