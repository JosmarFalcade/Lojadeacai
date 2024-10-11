package servicos;

import dao.DAOFactory;
import dao.VendaProdutosDAO;
import java.util.ArrayList;
import model.VendaProdutos;

public class VendaProdutosServicos {

    private VendaProdutosDAO vendaProdutosDAO;

    public VendaProdutosServicos() {
        this.vendaProdutosDAO = DAOFactory.getVendaProdutosDAO();
    }

    public void cadastrarVendaProduto(VendaProdutos vendaProduto) {

        vendaProdutosDAO.cadastrarVendaProduto(vendaProduto);

    }

    public ArrayList<VendaProdutos> listarVendaProdutos(int codigoVenda) {
        return vendaProdutosDAO.getVendaProdutosByVenda(codigoVenda);
    }

    public void atualizarVendaProduto(VendaProdutos vendaProduto) {

        vendaProdutosDAO.atualizarVendaProduto(vendaProduto);

    }

    public boolean deletarVendaProduto(int codigoVenda, int codigoProduto) {

        return vendaProdutosDAO.deletarVendaProduto(codigoVenda, codigoProduto);
    }
}
