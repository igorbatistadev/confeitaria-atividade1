public class PedidoItem {
    Produto produto;
    int quantidade;
    double precoVendaUnitario;

    public PedidoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVendaUnitario = produto.preco;
    }

    public double getValorTotalItem() {
        return this.quantidade * this.precoVendaUnitario;
    }
}
