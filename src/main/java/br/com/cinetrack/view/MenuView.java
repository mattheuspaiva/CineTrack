package br.com.cinetrack.view;

import br.com.cinetrack.model.Filme;
import br.com.cinetrack.service.FilmeService;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);
    private FilmeService filmeService = new FilmeService();

    public void exibirMenu() {

        int opcao;

        do {
            System.out.println("\n========== CINETRACK ==========");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Listar filmes");
            System.out.println("3 - Atualizar filme");
            System.out.println("4 - Excluir filme");
            System.out.println("\n========== PESQUISA ==========");
            System.out.println("5 - Pesquisar filme por título");
            System.out.println("6 - Pesquisar filme por gênero");
            System.out.println("7 - Pesquisar filme por ano");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    listarFilmes();
                    break;
                case 3:
                    atualizarFilme();
                    break;
                case 4:
                    excluirFilme();
                    break;
                case 5:
                    pesquisarFilmePorTitulo();
                    break;
                case 6:
                    pesquisarFilmePorGenero();
                    break;
                case 7:
                    pesquisarFilmePorAno();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarFilme() {

        System.out.println("\n--- CADASTRAR FILME ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        System.out.print("Avaliação (0 a 10): ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Status: ");
        String status = scanner.nextLine();

        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();

        Filme filme = new Filme(
                titulo, genero, ano,
                avaliacao, status, observacoes
        );

        String id = filmeService.cadastrar(filme);

        System.out.println("Filme cadastrado com sucesso!");
        System.out.println("ID gerado: " + id);
    }

    private void listarFilmes() {

        System.out.println("\n--- LISTA DE FILMES ---");

        List<Filme> filmes = filmeService.listarTodos();

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println("----------------------------");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Ano: " + filme.getAno());
            System.out.println("Avaliação: " + filme.getAvaliacao());
            System.out.println("Status: " + filme.getStatus());
            System.out.println("Observações: " + filme.getObservacoes());
        }
    }

    private void atualizarFilme() {

        System.out.println("\n--- ATUALIZAR FILME ---");

        System.out.print("Digite o ID do filme: ");
        String id = scanner.nextLine();

        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Novo gênero: ");
        String genero = scanner.nextLine();

        System.out.print("Novo ano: ");
        int ano = scanner.nextInt();

        System.out.print("Nova avaliação: ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Novo status: ");
        String status = scanner.nextLine();

        System.out.print("Novas observações: ");
        String observacoes = scanner.nextLine();

        Filme filme = new Filme(titulo,genero,ano,avaliacao,status,observacoes);

        boolean atualizado = filmeService.atualizar(id, filme);

        if (atualizado) {
            System.out.println("Filme atualizado com sucesso!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    private void excluirFilme() {

        System.out.println("\n--- EXCLUIR FILME ---");

        System.out.print("Digite o ID do filme: ");
        String id = scanner.nextLine();

        System.out.print("Confirma a exclusão? (S/N): ");
        String confirmacao = scanner.nextLine();

        boolean excluido = filmeService.excluir(id);

        if (excluido) {
            System.out.println("Filme excluído com sucesso!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    private void pesquisarFilmePorTitulo() {

        System.out.println("\n--- PESQUISAR FILME ---");

        System.out.print("Pesquisar por titulo: ");
        String titulo = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorTitulo(titulo);

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println("----------------------------");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Ano: " + filme.getAno());
            System.out.println("Avaliação: " + filme.getAvaliacao());
            System.out.println("Status: " + filme.getStatus());
            System.out.println("Observações: " + filme.getObservacoes());
        }
    }

    private void pesquisarFilmePorGenero() {

        System.out.println("\n--- PESQUISAR FILME POR GÊNERO ---");

        System.out.print("Digite o gênero: ");
        String genero = scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorGenero(genero);

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado para esse gênero.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println("----------------------------");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Ano: " + filme.getAno());
            System.out.println("Avaliação: " + filme.getAvaliacao());
            System.out.println("Status: " + filme.getStatus());
            System.out.println("Observações: " + filme.getObservacoes());
        }
    }

    private void pesquisarFilmePorAno() {

        System.out.println("\n--- PESQUISAR FILME POR ANO ---");

        System.out.print("Digite o ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        List<Filme> filmes = filmeService.pesquisarPorAno(ano);

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado para esse ano.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println("----------------------------");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Ano: " + filme.getAno());
            System.out.println("Avaliação: " + filme.getAvaliacao());
            System.out.println("Status: " + filme.getStatus());
            System.out.println("Observações: " + filme.getObservacoes());
        }
    }
}

