package org.example.Service;

import org.example.DAO.LembreteDAO;
import org.example.Model.Lembrete;

import java.util.List;

public class LembreteService {

    private LembreteDAO dao = new LembreteDAO();

    public List<Lembrete> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Lembrete buscarPorId(int id) throws Exception {
        for (Lembrete l : dao.readAll()) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public void cadastrar(Lembrete lembrete) throws Exception {
        dao.create(lembrete);
    }

    public void atualizar(Lembrete lembrete) throws Exception {
        dao.update(lembrete);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
