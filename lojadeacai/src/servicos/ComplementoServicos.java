package servicos;

import dao.ComplementoDAO;
import dao.DAOFactory;
import model.Complemento;

public class ComplementoServicos {

    private ComplementoDAO complementoDAO;

    public ComplementoServicos() {
        this.complementoDAO = DAOFactory.getComplementoDAO();
    }

    public void cadastrarComplemento(Complemento complemento) {
        if (complemento != null && complemento.getNomeComplemento() != null && !complemento.getNomeComplemento().isEmpty()) {
            complementoDAO.cadastrarComplemento(complemento);
            System.out.println("Complemento cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Dados do complemento inválidos.");
        }
    }

    public ArrayList<Complemento> listarComplementos() {
        return complementoDAO.getComplementos();
    }

    public Complemento buscarComplementoPorId(int id) {
        return complementoDAO.getComplementoById(id);
    }

    public void atualizarComplemento(Complemento complemento) {
        if (complemento != null && complemento.getCodigoComplemento() > 0) {
            complementoDAO.atualizarComplemento(complemento);
            System.out.println("Complemento atualizado com sucesso.");
        } else {
            System.out.println("Erro: Dados do complemento inválidos.");
        }
    }

    public boolean deletarComplemento(int id) {
        if (id > 0) {
            return complementoDAO.deletarComplemento(id);
        }
        System.out.println("Erro: ID do complemento inválido.");
        return false;
    }
}
