package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Lembrete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LembreteDAO {

    public void create(Lembrete l) throws SQLException {
        String sql = "INSERT INTO lembrete (id, id_usuario, tipo_pausa, mensagem, horario, frequencia, canal_envio, ativo, data_criacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, l.getId());
            ps.setInt(2, l.getIdUsuario());
            ps.setString(3, l.getTipoPausa());
            ps.setString(4, l.getMensagem());
            ps.setString(5, l.getHorario());
            ps.setString(6, l.getFrequencia());
            ps.setString(7, l.getCanalEnvio());
            ps.setInt(8, l.getAtivo());
            ps.setString(9, l.getDataCriacao());

            ps.executeUpdate();
        }
    }

    public List<Lembrete> readAll() throws SQLException {
        List<Lembrete> lista = new ArrayList<>();
        String sql = "SELECT * FROM lembrete";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Lembrete l = new Lembrete(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getString("tipo_pausa"),
                        rs.getString("mensagem"),
                        rs.getString("horario"),
                        rs.getString("frequencia"),
                        rs.getString("canal_envio"),
                        rs.getInt("ativo"),
                        rs.getString("data_criacao")
                );
                lista.add(l);
            }
        }
        return lista;
    }

    public void update(Lembrete l) throws SQLException {
        String sql = "UPDATE lembrete SET id_usuario = ?, tipo_pausa = ?, mensagem = ?, horario = ?, frequencia = ?, canal_envio = ?, ativo = ?, data_criacao = ? WHERE id = ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, l.getIdUsuario());
            ps.setString(2, l.getTipoPausa());
            ps.setString(3, l.getMensagem());
            ps.setString(4, l.getHorario());
            ps.setString(5, l.getFrequencia());
            ps.setString(6, l.getCanalEnvio());
            ps.setInt(7, l.getAtivo());
            ps.setString(8, l.getDataCriacao());
            ps.setInt(9, l.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM lembrete WHERE id = ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Lembrete> buscarPorTipo(String tipo) throws SQLException {
        List<Lembrete> lista = new ArrayList<>();
        String sql = "SELECT * FROM lembrete WHERE LOWER(tipo_pausa) LIKE ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + tipo.toLowerCase() + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lembrete l = new Lembrete(
                            rs.getInt("id"),
                            rs.getInt("id_usuario"),
                            rs.getString("tipo_pausa"),
                            rs.getString("mensagem"),
                            rs.getString("horario"),
                            rs.getString("frequencia"),
                            rs.getString("canal_envio"),
                            rs.getInt("ativo"),
                            rs.getString("data_criacao")
                    );
                    lista.add(l);
                }
            }
        }
        return lista;
    }
}
