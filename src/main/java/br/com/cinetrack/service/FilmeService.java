package br.com.cinetrack.service;

import br.com.cinetrack.dao.FilmeDAO;
import br.com.cinetrack.model.Filme;

import java.util.List;

public class FilmeService {

    private FilmeDAO filmeDAO = new FilmeDAO();

    public String cadastrar(Filme filme) {

        if (filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo.");
        }

        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }

        if (filme.getGenero() == null || filme.getGenero().trim().isEmpty()) {
            throw new IllegalArgumentException("O gênero é obrigatório.");
        }

        if (filme.getAno() <= 0) {
            throw new IllegalArgumentException("O ano deve ser maior que zero.");
        }

        if (filme.getAvaliacao() < 0 || filme.getAvaliacao() > 10) {
            throw new IllegalArgumentException("A avaliação deve estar entre 0 e 10.");
        }

        if (filme.getStatus() == null || filme.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("O status é obrigatório.");
        }

        if (!filme.getStatus().equalsIgnoreCase("Assistido")
                && !filme.getStatus().equalsIgnoreCase("Assistindo")
                && !filme.getStatus().equalsIgnoreCase("Quero assistir")) {
            throw new IllegalArgumentException("Status inválido.");
        }

        return filmeDAO.cadastrar(filme);
    }

    public List<Filme> listarTodos() {
        return filmeDAO.listarTodos();
    }

    public boolean atualizar(String id, Filme filme) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("O ID é obrigatório.");
        }

        if (filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo.");
        }

        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }

        if (filme.getGenero() == null || filme.getGenero().trim().isEmpty()) {
            throw new IllegalArgumentException("O gênero é obrigatório.");
        }

        if (filme.getAno() <= 0) {
            throw new IllegalArgumentException("O ano deve ser maior que zero.");
        }

        if (filme.getAvaliacao() < 0 || filme.getAvaliacao() > 10) {
            throw new IllegalArgumentException("A avaliação deve estar entre 0 e 10.");
        }

        if (filme.getStatus() == null || filme.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("O status é obrigatório.");
        }

        if (!filme.getStatus().equalsIgnoreCase("Assistido")
                && !filme.getStatus().equalsIgnoreCase("Assistindo")
                && !filme.getStatus().equalsIgnoreCase("Quero assistir")) {
            throw new IllegalArgumentException("Status inválido.");
        }

        return filmeDAO.atualizar(id, filme);
    }

    public boolean excluir(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("O ID é obrigatório.");
        }

        return filmeDAO.excluir(id);
    }

    public List<Filme> pesquisarPorTitulo(String titulo) {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe um título para pesquisar.");
        }

        return filmeDAO.pesquisarPorTitulo(titulo.trim());
    }

    public List<Filme> pesquisarPorGenero(String genero) {

        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe um gênero para pesquisar.");
        }

        return filmeDAO.pesquisarPorGenero(genero.trim());
    }

    public List<Filme> pesquisarPorAno(int ano) {

        if (ano <= 0) {
            throw new IllegalArgumentException("Informe um ano válido.");
        }

        return filmeDAO.pesquisarPorAno(ano);
    }
}