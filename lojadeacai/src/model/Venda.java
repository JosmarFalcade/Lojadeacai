package model;

import java.util.Date;

public class Venda {
    private int codigo;
    private int codigoCliente;
    private Date dataVenda;
    private double valorTotal;

    public Venda(int codigo, int codigoCliente, Date dataVenda, double valorTotal) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
