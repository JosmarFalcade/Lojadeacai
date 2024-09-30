package lojadeacai;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;
public class Lojadeacai {

        public static void main(String[] args) {
            ClienteDAO clienteDAO = new ClienteDAO();
    
            // Adicionando um novo cliente
            Cliente novoCliente = new Cliente(1, "João Silva", "9999-9999", "Rua A, 123");
            clienteDAO.adicionarCliente(novoCliente);
    
            // Listando todos os clientes
            List<Cliente> clientes = clienteDAO.listarClientes();
            for (Cliente cliente : clientes) {
                System.out.println("Cliente: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone());
            }
        }
    }
    