package org.example.DAO;

import jakarta.inject.Inject;
import org.example.Model.Humor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HumorDAO {
@Inject
    DataSource dataSource;
    public void create(Humor h) throws SQLException {
        String sql = "INSERT INTO humor (id, id_usuario, nivel_humor, nivel_energia, sentimento, observacao, data_registro, periodo_dia, origem_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, h.getId());
            ps.setInt(2, h.getIdUsuario());
            ps.setInt(3, h.getNivelHumor());
            ps.setInt(4, h.getNivelEnergia());
            ps.setString(5, h.getSentimento());
            ps.setString(6, h.getObservacao());
            ps.setString(7, h.getDataRegistro());
            ps.setString(8, h.getPeriodoDia());
            ps.setString(9, h.getOrigemRegistro());

            ps.executeUpdate();
        }
    }

    public List<Humor> readAll() throws SQLException {
        List<Humor> lista = new ArrayList<>();
        String sql = "SELECT * FROM humor";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Humor h = new Humor(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getInt("nivel_humor"),
                        rs.getInt("nivel_energia"),
                        rs.getString("sentimento"),
                        rs.getString("observacao"),
                        rs.getString("data_registro"),
                        rs.getString("periodo_dia"),
                        rs.getString("origem_registro")
                );
                lista.add(h);
            }
        }
        return lista;
    }

    public void update(Humor h) throws SQLException {
        String sql = "UPDATE humor SET id_usuario = ?, nivel_humor = ?, nivel_energia = ?, sentimento = ?, observacao = ?, data_registro = ?, periodo_dia = ?, origem_registro = ? WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, h.getIdUsuario());
            ps.setInt(2, h.getNivelHumor());
            ps.setInt(3, h.getNivelEnergia());
            ps.setString(4, h.getSentimento());
            ps.setString(5, h.getObservacao());
            ps.setString(6, h.getDataRegistro());
            ps.setString(7, h.getPeriodoDia());
            ps.setString(8, h.getOrigemRegistro());
            ps.setInt(9, h.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM humor WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Humor> buscarPorSentimento(String sentimento) throws SQLException {
        List<Humor> lista = new ArrayList<>();
        String sql = "SELECT * FROM humor WHERE LOWER(sentimento) LIKE ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + sentimento.toLowerCase() + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Humor h = new Humor(
                            rs.getInt("id"),
                            rs.getInt("id_usuario"),
                            rs.getInt("nivel_humor"),
                            rs.getInt("nivel_energia"),
                            rs.getString("sentimento"),
                            rs.getString("observacao"),
                            rs.getString("data_registro"),
                            rs.getString("periodo_dia"),
                            rs.getString("origem_registro")
                    );
                    lista.add(h);
                }
            }
        }
        return lista;
    }
}
