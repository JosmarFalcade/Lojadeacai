package servicos;

import dao.ClienteDAO;
import dao.DAOFactory;
import model.Cliente;

public class ClienteServicos {

    private ClienteDAO clienteDAO;

    public ClienteServicos() {
        this.clienteDAO = DAOFactory.getClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente != null && cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            clienteDAO.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Dados do cliente inválidos.");
        }
    }

    public ArrayList<Cliente> listarClientes() {
        return clienteDAO.getClientes();
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.getClienteById(id);
    }

    public void atualizarCliente(Cliente cliente) {
        if (cliente != null && cliente.getId() > 0) {
            clienteDAO.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Erro: Dados do cliente inválidos.");
        }
    }

    public boolean deletarCliente(int id) {
        if (id > 0) {
            return clienteDAO.deletarCliente(id);
        }
        System.out.println("Erro: ID do cliente inválido.");
        return false;
    }
}
