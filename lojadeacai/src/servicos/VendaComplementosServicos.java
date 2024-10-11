package servicos;

import dao.DAOFactory;
import dao.VendaComplementosDAO;
import java.util.ArrayList;
import model.VendaComplementos;

public class VendaComplementosServicos {

    private VendaComplementosDAO vendaComplementosDAO = DAOFactory.getVendaComplementosDAO();

    public void cadastrarVendaComplemento(VendaComplementos vendaComplemento) {

        vendaComplementosDAO.cadastrarVendaComplemento(vendaComplemento);

    }

    public ArrayList<VendaComplementos> listarVendaComplementos(int codigoVenda) {
        return vendaComplementosDAO.getVendaComplementosByVenda(codigoVenda);
    }

    public void atualizarVendaComplemento(VendaComplementos vendaComplemento) {

        vendaComplementosDAO.atualizarVendaComplemento(vendaComplemento);

    }

    public boolean deletarVendaComplemento(int codigoVenda, int codigoComplemento) {

        return vendaComplementosDAO.deletarVendaComplemento(codigoVenda, codigoComplemento);
    }
}
