package servicos;

public class ServicosFactory {

    private static ClienteServicos clienteServicos;
    private static ComplementoServicos complementoServicos;
    private static ProdutoServicos produtoServicos;
    private static VendaServicos vendaServicos;
    private static VendaComplementosServicos vendaComplementosServicos;
    private static VendaProdutosServicos vendaProdutosServicos;

    public static ClienteServicos getClienteServicos() {
        if (clienteServicos == null) {
            clienteServicos = new ClienteServicos();
        }
        return clienteServicos;
    }

    public static ComplementoServicos getComplementoServicos() {
        if (complementoServicos == null) {
            complementoServicos = new ComplementoServicos();
        }
        return complementoServicos;
    }

    public static ProdutoServicos getProdutoServicos() {
        if (produtoServicos == null) {
            produtoServicos = new ProdutoServicos();
        }
        return produtoServicos;
    }

    public static VendaServicos getVendaServicos() {
        if (vendaServicos == null) {
            vendaServicos = new VendaServicos();
        }
        return vendaServicos;
    }

    public static VendaComplementosServicos getVendaComplementosServicos() {
        if (vendaComplementosServicos == null) {
            vendaComplementosServicos = new VendaComplementosServicos();
        }
        return vendaComplementosServicos;
    }

    public static VendaProdutosServicos getVendaProdutosServicos() {
        if (vendaProdutosServicos == null) {
            vendaProdutosServicos = new VendaProdutosServicos();
        }
        return vendaProdutosServicos;
    }
}
