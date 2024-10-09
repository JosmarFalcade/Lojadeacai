package lojadeacai;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;
import view.Principal;
public class Lojadeacai {

        public static void main(String[] args) {
            Principal Principal = new Principal();
            Principal.setVisible(true);
            
            
            ClienteDAO clienteDAO = new ClienteDAO();
    
            // Adicionando um novo cliente
            Cliente novoCliente = new Cliente(1, "João Silva", "9999-9999", "Rua A, 123");
            clienteDAO.cadastrarCliente(novoCliente);
    
          /*  // Listando todos os clientes
            List<Cliente> clientes = clienteDAO.listarClientes();
            for (Cliente cliente : clientes) {
                System.out.println("Cliente: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone());
            }*/
        }
    }
    