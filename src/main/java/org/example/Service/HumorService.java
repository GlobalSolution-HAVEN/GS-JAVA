package org.example.Service;

import org.example.DAO.HumorDAO;
import org.example.Model.Humor;

import java.util.List;

public class HumorService {

    private HumorDAO dao = new HumorDAO();

    public List<Humor> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Humor buscarPorId(int id) throws Exception {
        for (Humor h : dao.readAll()) {
            if (h.getId() == id) return h;
        }
        return null;
    }

    public void cadastrar(Humor humor) throws Exception {
        dao.create(humor);
    }

    public void atualizar(Humor humor) throws Exception {
        dao.update(humor);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
