package br.com.cinetrack.dao;

import br.com.cinetrack.model.Filme;
import br.com.cinetrack.util.RavenDBUtil;

import net.ravendb.client.documents.session.IDocumentSession;

import java.util.List;

public class FilmeDAO {


    public String cadastrar(Filme filme) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            sessao.store(filme);
            sessao.saveChanges();

            return sessao.advanced().getDocumentId(filme);
        }
    }

    public List<Filme> listarTodos() {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            return sessao.query(Filme.class)
                    .toList();
        }
    }

    public boolean atualizar(String id, Filme filmeAtualizado) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            Filme filme = sessao.load(Filme.class, id);

            if (filme == null) {
                return false;
            }

            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setGenero(filmeAtualizado.getGenero());
            filme.setAno(filmeAtualizado.getAno());
            filme.setAvaliacao(filmeAtualizado.getAvaliacao());
            filme.setStatus(filmeAtualizado.getStatus());
            filme.setObservacoes(filmeAtualizado.getObservacoes());

            sessao.saveChanges();

            return true;
        }
    }

    public boolean excluir(String id) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            Filme filme = sessao.load(Filme.class, id);

            if (filme == null) {
                return false;
            }

            sessao.delete(filme);
            sessao.saveChanges();

            return true;
        }
    }

    public List<Filme> pesquisarPorTitulo(String titulo) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            return sessao.query(Filme.class)
                    .whereStartsWith("titulo", titulo)
                    .toList();
        }
    }

    public List<Filme> pesquisarPorGenero(String genero) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            return sessao.query(Filme.class)
                    .whereEquals("genero", genero)
                    .toList();
        }
    }

    public List<Filme> pesquisarPorAno(int ano) {

        try (IDocumentSession sessao =
                     RavenDBUtil.getStore().openSession()) {

            return sessao.query(Filme.class)
                    .whereEquals("ano", ano)
                    .toList();
        }
    }
}
