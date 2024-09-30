package servicos;

import dao.DAOFactory;
import dao.VendaComplementosDAO;

public class VendaComplementosServicos {

    private VendaComplementosDAO vendaComplementosDAO;

    public VendaComplementosServicos() {
        this.vendaComplementosDAO = DAOFactory.getVendaComplementosDAO();
    }

    public void cadastrarVendaComplemento(VendaComplemento vendaComplemento) {
        if (vendaComplemento != null && vendaComplemento.getCodigoVenda() > 0 && vendaComplemento.getCodigoComplemento() > 0) {
            vendaComplementosDAO.cadastrarVendaComplemento(vendaComplemento);
            System.out.println("Complemento da venda cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Dados do complemento da venda inválidos.");
        }
    }

    public ArrayList<VendaComplemento> listarVendaComplementos(int codigoVenda) {
        return vendaComplementosDAO.getVendaComplementos(codigoVenda);
    }

    public VendaComplemento buscarVendaComplementoPorId(int codigoVenda, int codigoComplemento) {
        return vendaComplementosDAO.getVendaComplementoById(codigoVenda, codigoComplemento);
    }

    public void atualizarVendaComplemento(VendaComplemento vendaComplemento) {
        if (vendaComplemento != null) {
            vendaComplementosDAO.atualizarVendaComplemento(vendaComplemento);
            System.out.println("Complemento da venda atualizado com sucesso.");
        } else {
            System.out.println("Erro: Dados do complemento da venda inválidos.");
        }
    }

    public boolean deletarVendaComplemento(int codigoVenda, int codigoComplemento) {
        if (codigoVenda > 0 && codigoComplemento > 0) {
            return vendaComplementosDAO.deletarVendaComplemento(codigoVenda, codigoComplemento);
        }
        System.out.println("Erro: ID da venda ou complemento inválido.");
        return false;
    }
}
