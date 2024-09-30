package model;

public class Complemento {
    private int codigo;
    private String nome;
    private double precoAdicional;

    public Complemento(int codigo, String nome, double precoAdicional) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoAdicional = precoAdicional;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoAdicional() {
        return precoAdicional;
    }

    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }
}
