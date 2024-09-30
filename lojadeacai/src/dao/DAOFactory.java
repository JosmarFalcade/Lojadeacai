package dao;

public class DAOFactory {

    public static ClienteDAO getClienteDAO() {
        return new ClienteDAO();
    }

    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoDAO();
    }

    public static ComplementoDAO getComplementoDAO() {
        return new ComplementoDAO();
    }

    public static VendaDAO getVendaDAO() {
        return new VendaDAO();
    }

    public static VendaProdutosDAO getVendaProdutosDAO() {
        return new VendaProdutosDAO();
    }

    public static VendaComplementosDAO getVendaComplementosDAO() {
        return new VendaComplementosDAO();
    }
}
