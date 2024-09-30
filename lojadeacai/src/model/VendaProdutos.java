package model;
public class VendaProdutos {
    private int codigoVenda;
    private int codigoProduto;
    private int quantidade;

    public VendaProdutos(int codigoVenda, int codigoProduto, int quantidade) {
        this.codigoVenda = codigoVenda;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

