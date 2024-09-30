package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Complemento;

public class ComplementoDAO {

    public void cadastrarComplemento(Complemento c) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO COMPLEMENTOS (Codigo_Complemento, Nome_Complemento, Preco_Adicional) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigo());
            pst.setString(2, c.getNome());
            pst.setDouble(3, c.getPrecoAdicional());
            pst.execute();
            System.out.println("Complemento cadastrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Complemento. \n" + e.getMessage());
        }
    }

    public ArrayList<Complemento> getComplementos() {
        ArrayList<Complemento> complementos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM COMPLEMENTOS";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Complemento c = new Complemento();
                c.setCodigo(rs.getInt("Codigo_Complemento"));
                c.setNome(rs.getString("Nome_Complemento"));
                c.setPrecoAdicional(rs.getDouble("Preco_Adicional"));
                complementos.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Complementos. \n" + e.getMessage());
        }
        return complementos;
    }

    public Complemento getComplementoById(int id) {
        Complemento c = new Complemento();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM COMPLEMENTOS WHERE Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setCodigo(rs.getInt("Codigo_Complemento"));
                c.setNome(rs.getString("Nome_Complemento"));
                c.setPrecoAdicional(rs.getDouble("Preco_Adicional"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Complemento. \n" + e.getMessage());
        }
        return c;
    }

    public void atualizarComplemento(Complemento c) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE COMPLEMENTOS SET Nome_Complemento = ?, Preco_Adicional = ? WHERE Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setDouble(2, c.getPrecoAdicional());
            pst.setInt(3, c.getCodigo());
            pst.executeUpdate();
            System.out.println("Complemento atualizado.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Complemento. \n" + e.getMessage());
        }
    }

    public boolean deletarComplemento(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM COMPLEMENTOS WHERE Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Complemento. \n" + e.getMessage());
        }
        return false;
    }
}
