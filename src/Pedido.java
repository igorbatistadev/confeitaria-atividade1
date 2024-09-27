import java.util.ArrayList;
import java.util.List;

public class Pedido {
    Cliente cliente;
    List<PedidoItem> itens;
    boolean pago;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    void adicionarProduto(Produto produto, int quantidade) {
        PedidoItem pedidoItem = new PedidoItem(produto, quantidade);
        this.itens.add(pedidoItem);
        System.out.println("Produto " + produto.descricao + " adicionado ao pedido!");
    }

    void realizarPagamento() {
        System.out.println("Realizando Pagamento");
        this.pago = true;
        System.out.println("Pagamento realizado!");
    }

    boolean pedidoEstaPago() {
        return this.pago;
    }

    double getValorTotalPedido() {
        double total = 0;
        for (PedidoItem pedidoItem : this.itens) {
            total += pedidoItem.getValorTotalItem();
        }
        return total;
//        return this.itens.stream().map(PedidoItem::getValorTotalItem).reduce(0.0, Double::sum);
    }
}
