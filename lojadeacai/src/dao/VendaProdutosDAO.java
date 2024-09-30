package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.VendaProdutos;

public class VendaProdutosDAO {

    public void cadastrarVendaProduto(VendaProdutos vp) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO VENDA_PRODUTOS (Codigo_Venda, Codigo_Produto, Quantidade) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vp.getCodigoVenda());
            pst.setInt(2, vp.getCodigoProduto());
            pst.setInt(3, vp.getQuantidade());
            pst.execute();
            System.out.println("VendaProduto cadastrada.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar VendaProduto. \n" + e.getMessage());
        }
    }

    public ArrayList<VendaProdutos> getVendaProdutosByVenda(int codigoVenda) {
        ArrayList<VendaProdutos> vendaProdutos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM VENDA_PRODUTOS WHERE Codigo_Venda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigoVenda);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VendaProdutos vp = new VendaProdutos();
                vp.setCodigoVenda(rs.getInt("Codigo_Venda"));
                vp.setCodigoProduto(rs.getInt("Codigo_Produto"));
                vp.setQuantidade(rs.getInt("Quantidade"));
                vendaProdutos.add(vp);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar VendaProdutos. \n" + e.getMessage());
        }
        return vendaProdutos;
    }

    public void atualizarVendaProduto(VendaProdutos vp) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE VENDA_PRODUTOS SET Quantidade = ? WHERE Codigo_Venda = ? AND Codigo_Produto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vp.getQuantidade());
            pst.setInt(2, vp.getCodigoVenda());
            pst.setInt(3, vp.getCodigoProduto());
            pst.executeUpdate();
            System.out.println("VendaProduto atualizada.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar VendaProduto. \n" + e.getMessage());
        }
    }

    public boolean deletarVendaProduto(int codigoVenda, int codigoProduto) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM VENDA_PRODUTOS WHERE Codigo_Venda = ? AND Codigo_Produto = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigoVenda);
            pst.setInt(2, codigoProduto);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar VendaProduto. \n" + e.getMessage());
        }
        return false;
    }
}
