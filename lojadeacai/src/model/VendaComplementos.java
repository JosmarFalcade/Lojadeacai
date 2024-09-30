package model;

public class VendaComplementos {
    private int codigoVenda;
    private int codigoComplemento;
    private int quantidade;

    public VendaComplementos(int codigoVenda, int codigoComplemento, int quantidade) {
        this.codigoVenda = codigoVenda;
        this.codigoComplemento = codigoComplemento;
        this.quantidade = quantidade;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoComplemento() {
        return codigoComplemento;
    }

    public void setCodigoComplemento(int codigoComplemento) {
        this.codigoComplemento = codigoComplemento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

