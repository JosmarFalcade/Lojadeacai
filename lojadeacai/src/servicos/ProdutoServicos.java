package servicos;

import dao.DAOFactory;
import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

public class ProdutoServicos {

    private ProdutoDAO produtoDAO = DAOFactory.getProdutoDAO();


    public void cadastrarProduto(Produto produto) {

        produtoDAO.cadastrarProduto(produto);

    }

    public ArrayList<Produto> listarProdutos() {
        return produtoDAO.getProdutos();
    }

    public Produto buscarProdutoPorId(int id) {
        return produtoDAO.getProdutoById(id);
    }

    public void atualizarProduto(Produto produto) {

        produtoDAO.atualizarProduto(produto);

    }

    public boolean deletarProduto(int id) {

        return produtoDAO.deletarProduto(id);

    }
}
