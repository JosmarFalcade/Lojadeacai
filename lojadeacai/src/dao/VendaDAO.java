package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Venda;

public class VendaDAO {

    public void cadastrarVenda(Venda v) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO VENDAS (Codigo_Venda, Codigo_Cliente, Data_Venda, Valor_Total) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, v.getCodigo());
            pst.setInt(2, v.getCodigoCliente());
            pst.setDate(3, Date.valueOf(v.getDataVenda())); // Assumindo que a data é do tipo LocalDate
            pst.setDouble(4, v.getValorTotal());
            pst.execute();
            System.out.println("Venda cadastrada.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Venda. \n" + e.getMessage());
        }
    }

    public ArrayList<Venda> getVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM VENDAS";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Venda v = new Venda();
                v.setCodigo(rs.getInt("Codigo_Venda"));
                v.setCodigoCliente(rs.getInt("Codigo_Cliente"));
                v.setDataVenda(rs.getDate("Data_Venda").toLocalDate());
                v.setValorTotal(rs.getDouble("Valor_Total"));
                vendas.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Vendas. \n" + e.getMessage());
        }
        return vendas;
    }

    public Venda getVendaById(int id) {
        Venda v = new Venda();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM VENDAS WHERE Codigo_Venda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                v.setCodigo(rs.getInt("Codigo_Venda"));
                v.setCodigoCliente(rs.getInt("Codigo_Cliente"));
                v.setDataVenda(rs.getDate("Data_Venda").toLocalDate());
                v.setValorTotal(rs.getDouble("Valor_Total"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Venda. \n" + e.getMessage());
        }
        return v;
    }

    public void atualizarVenda(Venda v) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE VENDAS SET Codigo_Cliente = ?, Data_Venda = ?, Valor_Total = ? WHERE Codigo_Venda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, v.getCodigoCliente());
            pst.setDate(2, Date.valueOf(v.getDataVenda()));
            pst.setDouble(3, v.getValorTotal());
            pst.setInt(4, v.getCodigo());
            pst.executeUpdate();
            System.out.println("Venda atualizada.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Venda. \n" + e.getMessage());
        }
    }

    public boolean deletarVenda(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM VENDAS WHERE Codigo_Venda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Venda. \n" + e.getMessage());
        }
        return false;
    }
}
