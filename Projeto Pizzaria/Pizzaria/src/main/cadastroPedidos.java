package main;

import java.util.Scanner;

import negocio.Pedido;

public class cadastroPedidos {

    private static Scanner src = new Scanner(System.in);
    private static final int maxPedidos = 100;
    private static Pedido[] pedidos = new Pedido[maxPedidos];
    private static int totalPedidos = 0;
    
    public static void main(String[] args) {
        menu2();
    }
    public static void menu2() {
        
        while (true) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("---------------------------Cadastro Pedidos------------------------");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Nome do Cliente: ");
            String nome = src.next();
            System.out.println("Sabor da Pizza:");
            String sabor = src.next();
            System.out.println("Tipo de pagamento:");
            String pagamento = src.next();
            
            System.out.println("Deseja continuar cadastrando pedidos (S/N): ");
            String resposta = src.next().toLowerCase();

            if(resposta.equals("n")){
                break;
            }
        }
    }
}

