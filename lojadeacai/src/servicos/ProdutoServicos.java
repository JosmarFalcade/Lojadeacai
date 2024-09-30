package servicos;

import dao.DAOFactory;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoServicos {

    private ProdutoDAO produtoDAO;

    public ProdutoServicos() {
        this.produtoDAO = DAOFactory.getProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) {
        if (produto != null && produto.getNomeProduto() != null && !produto.getNomeProduto().isEmpty()) {
            produtoDAO.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Dados do produto inválidos.");
        }
    }

    public ArrayList<Produto> listarProdutos() {
        return produtoDAO.getProdutos();
    }

    public Produto buscarProdutoPorId(int id) {
        return produtoDAO.getProdutoById(id);
    }

    public void atualizarProduto(Produto produto) {
        if (produto != null && produto.getCodigoProduto() > 0) {
            produtoDAO.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Erro: Dados do produto inválidos.");
        }
    }

    public boolean deletarProduto(int id) {
        if (id > 0) {
            return produtoDAO.deletarProduto(id);
        }
        System.out.println("Erro: ID do produto inválido.");
        return false;
    }
}
