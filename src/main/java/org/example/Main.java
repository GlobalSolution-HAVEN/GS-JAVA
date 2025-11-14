package org.example;

import org.example.DAO.*;
import org.example.Model.*;

public class Main {
    public static void main(String[] args) {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = new Usuario(
                    1,
                    "Eduardo Augusto",
                    "eduardo@haven.com",
                    "senha123",
                    "11988887777",
                    "2025-01-15",
                    "ATIVO",
                    "COLABORADOR",
                    "Tecnologia"
            );

            usuarioDAO.create(usuario);

            System.out.println("\n--- LISTAR USUÁRIOS ---");
            for (Usuario u : usuarioDAO.readAll()) {
                System.out.println("Usuário: " + u.getNome());
            }

            usuario.setNome("Eduardo A.");
            usuarioDAO.update(usuario);

            System.out.println("\n--- BUSCA USUÁRIO POR NOME ---");
            for (Usuario u : usuarioDAO.buscarPorNome("edu")) {
                System.out.println("Busca Usuário: " + u.getNome());
            }



            HumorDAO humorDAO = new HumorDAO();
            Humor humor = new Humor(
                    1,
                    1,              // idUsuario
                    4,              // nível humor
                    3,              // nível energia
                    "Neutro",
                    "Dia normal",
                    "2025-01-15",
                    "MANHA",
                    "APP"
            );

            humorDAO.create(humor);

            System.out.println("\n--- LISTAR HUMOR ---");
            for (Humor h : humorDAO.readAll()) {
                System.out.println("Humor: " + h.getSentimento());
            }

            humor.setSentimento("Motivado");
            humorDAO.update(humor);

            System.out.println("\n--- BUSCA HUMOR POR SENTIMENTO ---");
            for (Humor h : humorDAO.buscarPorSentimento("mot")) {
                System.out.println("Busca Humor: " + h.getSentimento());
            }



            ConteudoDAO conteudoDAO = new ConteudoDAO();
            Conteudo conteudo = new Conteudo(
                    1,
                    "Alongamento de Pescoço",
                    "VIDEO",
                    "ALONGAMENTO",
                    "https://video1.com",
                    120,
                    "LEVE",
                    "FISICO",
                    "PT-BR",
                    1
            );

            conteudoDAO.create(conteudo);

            System.out.println("\n--- LISTAR CONTEÚDOS ---");
            for (Conteudo c : conteudoDAO.readAll()) {
                System.out.println("Conteúdo: " + c.getTitulo());
            }

            conteudo.setTitulo("Alongamento Cervical");
            conteudoDAO.update(conteudo);

            System.out.println("\n--- BUSCA CONTEÚDO POR CATEGORIA ---");
            for (Conteudo c : conteudoDAO.buscarPorCategoria("along")) {
                System.out.println("Busca Conteúdo: " + c.getTitulo());
            }



            LembreteDAO lembreteDAO = new LembreteDAO();
            Lembrete lembrete = new Lembrete(
                    1,
                    1,                  // idUsuario
                    "FISICA",
                    "Hora de alongar!",
                    "09:00",
                    "DIARIO",
                    "APP",
                    1,
                    "2025-01-15"
            );

            lembreteDAO.create(lembrete);

            System.out.println("\n--- LISTAR LEMBRETES ---");
            for (Lembrete l : lembreteDAO.readAll()) {
                System.out.println("Lembrete: " + l.getMensagem());
            }

            lembrete.setMensagem("Alongamento agora!");
            lembreteDAO.update(lembrete);

            System.out.println("\n--- BUSCA LEMBRETE POR TIPO ---");
            for (Lembrete l : lembreteDAO.buscarPorTipo("fis")) {
                System.out.println("Busca Lembrete: " + l.getMensagem());
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
