public class Main {
    public static void main(String[] args) {

        Produto boloPote = new Produto("Bolo de pote de Chocolate", 13.00);
        Produto poteLolita = new Produto("Pote com 10 unidades de Lolita", 7.00);

        Cliente cliente = new Cliente("Fernando Kenji");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(boloPote, 2);
        pedido.adicionarProduto(poteLolita, 1);

        double totalPedido = pedido.getValorTotalPedido();
        System.out.println("Total do pedido: " + totalPedido);

        if (pedido.pedidoEstaPago()) {
            System.out.println("Pedido Pago");
        } else {
            System.out.println("Pagamento pendente");
        }

        pedido.realizarPagamento();

        if (pedido.pedidoEstaPago()) {
            System.out.println("Pedido Finalizado!");
        } else {
            System.out.println("Pagamento não realizado, pedido cancelado!");
        }
    }
}