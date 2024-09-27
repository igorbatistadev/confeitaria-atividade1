public class PedidoItem {
    private Produto produto;
    private int quantidade;
    private double precoVendaUnitario;

    public PedidoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVendaUnitario = produto.getPreco();
    }

    public String getDescricaoItem() {
        return this.produto.getDescricao();
    }

    public double getValorTotalItem() {
        return this.quantidade * this.precoVendaUnitario;
    }
}
