package servicos;

import dao.ComplementoDAO;
import dao.DAOFactory;
import java.util.ArrayList;
import model.Complemento;

public class ComplementoServicos {

    private ComplementoDAO complementoDAO = DAOFactory.getComplementoDAO();


    public void cadastrarComplemento(Complemento complemento) {
        complementoDAO.cadastrarComplemento(complemento);
    }

    public ArrayList<Complemento> listarComplementos() {
        return complementoDAO.getComplementos();
    }

    public Complemento buscarComplementoPorId(int id) {
        return complementoDAO.getComplementoById(id);
    }

    public void atualizarComplemento(Complemento complemento) {

        complementoDAO.atualizarComplemento(complemento);

    }

    public boolean deletarComplemento(int id) {
     
            return complementoDAO.deletarComplemento(id);
      
    }
}
