import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<PedidoItem> itens;
    private boolean pago;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    void adicionarProduto(Produto produto, int quantidade) {
        PedidoItem pedidoItem = new PedidoItem(produto, quantidade);
        this.itens.add(pedidoItem);
        System.out.println("Produto " + produto.getDescricao() + " adicionado ao pedido!");
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
        return this.itens.stream().map(PedidoItem::getValorTotalItem).reduce(0.0, Double::sum);
    }

    public void resumoPedido() {
        System.out.println("======== Resumo pedido ========");
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Quantidade de itens: " + this.itens.size());
        System.out.println("Valor total do pedido: " + this.getValorTotalPedido());
    }
}
