package servicos;

import dao.DAOFactory;
import dao.VendaDAO;
import model.Venda;

public class VendaServicos {

    private VendaDAO vendaDAO;

    public VendaServicos() {
        this.vendaDAO = DAOFactory.getVendaDAO();
    }

    public void cadastrarVenda(Venda venda) {
        if (venda != null && venda.getCodigoCliente() > 0 && venda.getValorTotal() >= 0) {
            vendaDAO.cadastrarVenda(venda);
            System.out.println("Venda cadastrada com sucesso.");
        } else {
            System.out.println("Erro: Dados da venda inválidos.");
        }
    }

    public ArrayList<Venda> listarVendas() {
        return vendaDAO.getVendas();
    }

    public Venda buscarVendaPorId(int codigoVenda) {
        return vendaDAO.getVendaById(codigoVenda);
    }

    public void atualizarVenda(Venda venda) {
        if (venda != null && venda.getCodigoVenda() > 0) {
            vendaDAO.atualizarVenda(venda);
            System.out.println("Venda atualizada com sucesso.");
        } else {
            System.out.println("Erro: Dados da venda inválidos.");
        }
    }

    public boolean deletarVenda(int codigoVenda) {
        if (codigoVenda > 0) {
            return vendaDAO.deletarVenda(codigoVenda);
        }
        System.out.println("Erro: ID da venda inválido.");
        return false;
    }
}

