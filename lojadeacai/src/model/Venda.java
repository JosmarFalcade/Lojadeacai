package model;

import java.time.LocalDate;

public class Venda {
    private int codigo;
    private int codigoCliente;
    private LocalDate dataVenda;
    private double valorTotal;

    public Venda() {
    }
    
    

    public Venda(int codigo, int codigoCliente, LocalDate dataVenda, double valorTotal) {
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

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
