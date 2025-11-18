package org.example.Service;

import org.example.DAO.ConteudoDAO;
import org.example.Model.Conteudo;
import java.util.List;

public class ConteudoService {

    private ConteudoDAO dao = new ConteudoDAO();

    public List<Conteudo> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Conteudo buscarPorId(int id) throws Exception {
        for (Conteudo c : dao.readAll()) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void cadastrar(Conteudo conteudo) throws Exception {
        dao.create(conteudo);
    }

    public void atualizar(Conteudo conteudo) throws Exception {
        dao.update(conteudo);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
