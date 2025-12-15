package controller;

import model.Veiculo;
import model.VeiculoDAO;
import java.util.ArrayList;

public class VeiculoController {

    private VeiculoDAO dao = new VeiculoDAO();

    public void cadastrar(Veiculo v) {
        dao.inserir(v);
    }

    public ArrayList<Veiculo> listar() {
        return dao.listar();
    }

    public Veiculo buscar(int id) {
        for (Veiculo v : dao.listar()) {
            if (v.getId() == id)
                return v;
        }
        return null;
    }

    public void editar(Veiculo v) {
        dao.atualizar(v);
    }

    public void excluir(int id) {
        dao.excluir(id);
    }
}
