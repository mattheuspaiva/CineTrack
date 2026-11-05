package br.com.cinetrack.model;

public class Filme {

        private String titulo;
        private String genero;
        private int ano;
        private double avaliacao;
        private String status;
        private String observacoes;

        public Filme() {
        }

        public Filme(String titulo, String genero, int ano,
                     double avaliacao, String status,
                     String observacoes) {
            this.titulo = titulo;
            this.genero = genero;
            this.ano = ano;
            this.avaliacao = avaliacao;
            this.status = status;
            this.observacoes = observacoes;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public double getAvaliacao() {
            return avaliacao;
        }

        public void setAvaliacao(double avaliacao) {
            this.avaliacao = avaliacao;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getObservacoes() {
            return observacoes;
        }

        public void setObservacoes(String observacoes) {
            this.observacoes = observacoes;
        }
    }


