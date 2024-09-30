package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Produto;

public class ProdutoDAO {

    public void cadastrarProduto(Produto p) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO PRODUTOS (Codigo_Produto, Nome_Produto, Preco, Tipo_Produto) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, p.getCodigo());
            pst.setString(2, p.getNome());
            pst.setDouble(3, p.getPreco());
            pst.setString(4, p.getTipoProduto());
            pst.execute();
            System.out.println("Produto cadastrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Produto. \n" + e.getMessage());
        }
    }

    public ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM PRODUTOS";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto p = new produto();
                p.setCodigo(rs.getInt("Codigo_Produto"));
                p.setNome(rs.getString("Nome_Produto"));
                p.setPreco(rs.getDouble("Preco"));
                p.setTipoProduto(rs.getString("Tipo_Produto"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Produtos. \n" + e.getMessage());
        }
        return produtos;
    }

    public Produto getProdutoById(int id) {
        Produto p = new Produto();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM PRODUTOS WHERE Codigo_Produto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p.setCodigo(rs.getInt("Codigo_Produto"));
                p.setNome(rs.getString("Nome_Produto"));
                p.setPreco(rs.getDouble("Preco"));
                p.setTipoProduto(rs.getString("Tipo_Produto"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produto. \n" + e.getMessage());
        }
        return p;
    }

    public void atualizarProduto(Produto p) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE PRODUTOS SET Nome_Produto = ?, Preco = ?, Tipo_Produto = ? WHERE Codigo_Produto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setDouble(2, p.getPreco());
            pst.setString(3, p.getTipoProduto());
            pst.setInt(4, p.getCodigo());
            pst.executeUpdate();
            System.out.println("Produto atualizado.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Produto. \n" + e.getMessage());
        }
    }

    public boolean deletarProduto(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM PRODUTOS WHERE Codigo_Produto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Produto. \n" + e.getMessage());
        }
        return false;
    }
}
