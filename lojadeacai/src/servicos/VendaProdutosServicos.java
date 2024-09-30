package servicos;

import dao.DAOFactory;
import dao.VendaProdutosDAO;

public class VendaProdutosServicos {

    private VendaProdutosDAO vendaProdutosDAO;

    public VendaProdutosServicos() {
        this.vendaProdutosDAO = DAOFactory.getVendaProdutosDAO();
    }

    public void cadastrarVendaProduto(VendaProduto vendaProduto) {
        if (vendaProduto != null && vendaProduto.getCodigoVenda() > 0 && vendaProduto.getCodigoProduto() > 0) {
            vendaProdutosDAO.cadastrarVendaProduto(vendaProduto);
            System.out.println("Produto da venda cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Dados do produto da venda inválidos.");
        }
    }

    public ArrayList<VendaProduto> listarVendaProdutos(int codigoVenda) {
        return vendaProdutosDAO.getVendaProdutos(codigoVenda);
    }

    public VendaProduto buscarVendaProdutoPorId(int codigoVenda, int codigoProduto) {
        return vendaProdutosDAO.getVendaProdutoById(codigoVenda, codigoProduto);
    }

    public void atualizarVendaProduto(VendaProduto vendaProduto) {
        if (vendaProduto != null) {
            vendaProdutosDAO.atualizarVendaProduto(vendaProduto);
            System.out.println("Produto da venda atualizado com sucesso.");
        } else {
            System.out.println("Erro: Dados do produto da venda inválidos.");
        }
    }

    public boolean deletarVendaProduto(int codigoVenda, int codigoProduto) {
        if (codigoVenda > 0 && codigoProduto > 0) {
            return vendaProdutosDAO.deletarVendaProduto(codigoVenda, codigoProduto);
        }
        System.out.println("Erro: ID da venda ou produto inválido.");
        return false;
    }
}
