package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.VendaComplementos;

public class VendaComplementosDAO {

    public void cadastrarVendaComplemento(VendaComplementos vc) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO VENDA_COMPLEMENTOS (Codigo_Venda, Codigo_Complemento, Quantidade) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vc.getCodigoVenda());
            pst.setInt(2, vc.getCodigoComplemento());
            pst.setInt(3, vc.getQuantidade());
            pst.execute();
            System.out.println("VendaComplemento cadastrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar VendaComplemento. \n" + e.getMessage());
        }
    }

    public ArrayList<VendaComplementos> getVendaComplementosByVenda(int codigoVenda) {
        ArrayList<VendaComplementos> vendaComplementos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM VENDA_COMPLEMENTOS WHERE Codigo_Venda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigoVenda);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VendaComplementos vc = new VendaComplementos ( rs.getInt("Quantidade"), rs.getInt("Codigo_Venda"), rs.getInt("Codigo_Complemento"));
                vendaComplementos.add(vc);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar VendaComplementos. \n" + e.getMessage());
        }
        return vendaComplementos;
    }

    public void atualizarVendaComplemento(VendaComplementos vc) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE VENDA_COMPLEMENTOS SET Quantidade = ? WHERE Codigo_Venda = ? AND Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vc.getQuantidade());
            pst.setInt(2, vc.getCodigoVenda());
            pst.setInt(3, vc.getCodigoComplemento());
            pst.executeUpdate();
            System.out.println("VendaComplemento atualizado.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar VendaComplemento. \n" + e.getMessage());
        }
    }

    public boolean deletarVendaComplemento(int codigoVenda, int codigoComplemento) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM VENDA_COMPLEMENTOS WHERE Codigo_Venda = ? AND Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigoVenda);
            pst.setInt(2, codigoComplemento);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar VendaComplemento. \n" + e.getMessage());
        }
        return false;
    }
}
