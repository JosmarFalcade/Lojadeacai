package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Complemento;

public class ComplementoDAO {

    public void cadastrarComplemento(Complemento com) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO COMPLEMENTOS (CodigoComplemento, NomeComplemento, PrecoAdicional) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, com.getCodigo());
            pst.setString(2, com.getNome());
            pst.setDouble(3, com.getPrecoAdicional());
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
                Complemento com = new Complemento( rs.getInt("CodigoComplemento"), rs.getString("NomeComplemento"), rs.getDouble("PrecoAdicional"));
                
                complementos.add(com);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Complementos. \n" + e.getMessage());
        }
        return complementos;
    }

    public Complemento getComplementoById(int id) {
        Complemento com = new Complemento();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM COMPLEMENTOS WHERE Codigo_Complemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                com.setCodigo(rs.getInt("CodigoComplemento"));
                com.setNome(rs.getString("NomeComplemento"));
                com.setPrecoAdicional(rs.getDouble("PrecoAdicional"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Complemento. \n" + e.getMessage());
        }
        return com;
    }

    public void atualizarComplemento(Complemento com) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE COMPLEMENTOS SET NomeComplemento = ?, PrecoAdicional = ? WHERE CodigoComplemento = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, com.getNome());
            pst.setDouble(2, com.getPrecoAdicional());
            pst.setInt(3, com.getCodigo());
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
