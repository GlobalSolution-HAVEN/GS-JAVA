package org.example.Service;

import org.example.DAO.UsuarioDAO;
import org.example.Model.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public List<Usuario> listarTodos() throws Exception {
        return dao.readAll();
    }

    public Usuario buscarPorId(int id) throws Exception {
        for (Usuario u : dao.readAll()) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public void cadastrar(Usuario usuario) throws Exception {
        dao.create(usuario);
    }

    public void atualizar(Usuario usuario) throws Exception {
        dao.update(usuario);
    }

    public void excluir(int id) throws Exception {
        dao.delete(id);
    }
}
