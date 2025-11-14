package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Conteudo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConteudoDAO {

    public void create(Conteudo c) throws SQLException {
        String sql = "INSERT INTO conteudo (id, titulo, tipo, categoria, url, duracao_segundos, dificuldade, foco, idioma, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getTitulo());
            ps.setString(3, c.getTipo());
            ps.setString(4, c.getCategoria());
            ps.setString(5, c.getUrl());
            ps.setInt(6, c.getDuracaoSegundos());
            ps.setString(7, c.getDificuldade());
            ps.setString(8, c.getFoco());
            ps.setString(9, c.getIdioma());
            ps.setInt(10, c.getAtivo());

            ps.executeUpdate();
        }
    }

    public List<Conteudo> readAll() throws SQLException {
        List<Conteudo> lista = new ArrayList<>();
        String sql = "SELECT * FROM conteudo";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Conteudo c = new Conteudo(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("tipo"),
                        rs.getString("categoria"),
                        rs.getString("url"),
                        rs.getInt("duracao_segundos"),
                        rs.getString("dificuldade"),
                        rs.getString("foco"),
                        rs.getString("idioma"),
                        rs.getInt("ativo")
                );
                lista.add(c);
            }
        }
        return lista;
    }

    public void update(Conteudo c) throws SQLException {
        String sql = "UPDATE conteudo SET titulo = ?, tipo = ?, categoria = ?, url = ?, duracao_segundos = ?, dificuldade = ?, foco = ?, idioma = ?, ativo = ? WHERE id = ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getTipo());
            ps.setString(3, c.getCategoria());
            ps.setString(4, c.getUrl());
            ps.setInt(5, c.getDuracaoSegundos());
            ps.setString(6, c.getDificuldade());
            ps.setString(7, c.getFoco());
            ps.setString(8, c.getIdioma());
            ps.setInt(9, c.getAtivo());
            ps.setInt(10, c.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM conteudo WHERE id = ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Conteudo> buscarPorCategoria(String categoria) throws SQLException {
        List<Conteudo> lista = new ArrayList<>();
        String sql = "SELECT * FROM conteudo WHERE LOWER(categoria) LIKE ?";

        try (Connection conn = Conexao.recuperaConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + categoria.toLowerCase() + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Conteudo c = new Conteudo(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("tipo"),
                            rs.getString("categoria"),
                            rs.getString("url"),
                            rs.getInt("duracao_segundos"),
                            rs.getString("dificuldade"),
                            rs.getString("foco"),
                            rs.getString("idioma"),
                            rs.getInt("ativo")
                    );
                    lista.add(c);
                }
            }
        }
        return lista;
    }
}
