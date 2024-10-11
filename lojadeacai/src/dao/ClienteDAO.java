package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Cliente;

public class ClienteDAO {

    public void cadastrarCliente(Cliente c) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO CLIENTES (Codigo_Cliente, Nome_Cliente, Telefone, Endereco) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigo());
            pst.setString(2, c.getNome());
            pst.setString(3, c.getTelefone());
            pst.setString(4, c.getEndereco());
            pst.execute();
            System.out.println("Cliente cadastrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Cliente. \n" + e.getMessage());
        }
    }

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM CLIENTES";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente( rs.getInt("Codigo_Cliente"), rs.getString("Nome_Cliente"), rs.getString("Telefone"), rs.getString("Endereco"));
                
                clientes.add(c);
//                Cliente c = new Cliente();
//                c.setCodigo(rs.getInt("Codigo_Cliente"));
//                c.setNome(rs.getString("Nome_Cliente"));
//                c.setTelefone(rs.getString("Telefone"));
//                c.setEndereco(rs.getString("Endereco"));
//                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Clientes. \n" + e.getMessage());
        }
        return clientes;
    }

    public Cliente getClienteById(int id) {
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM CLIENTES WHERE Codigo_Cliente = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setCodigo(rs.getInt("Codigo_Cliente"));
                c.setNome(rs.getString("Nome_Cliente"));
                c.setTelefone(rs.getString("Telefone"));
                c.setEndereco(rs.getString("Endereco"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Cliente. \n" + e.getMessage());
        }
        return c;
    }

    public void atualizarCliente(Cliente c) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE CLIENTES SET Nome_Cliente = ?, Telefone = ?, Endereco = ? WHERE Codigo_Cliente = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getTelefone());
            pst.setString(3, c.getEndereco());
            pst.setInt(4, c.getCodigo());
            pst.executeUpdate();
            System.out.println("Cliente atualizado.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Cliente. \n" + e.getMessage());
        }
    }

    public boolean deletarCliente(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM CLIENTES WHERE Codigo_Cliente = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Cliente. \n" + e.getMessage());
        }
        return false;
    }
}
