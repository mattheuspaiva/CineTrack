package br.com.cinetrack;

import br.com.cinetrack.util.RavenDBUtil;
import br.com.cinetrack.view.MenuView;

public class Main {

    public static void main(String[] args) {

        try {

            RavenDBUtil.getStore();

            System.out.println("Conectado ao RavenDB com sucesso!");

            MenuView menu = new MenuView();
            menu.exibirMenu();

        } catch (Exception e) {
            System.out.println("Erro na aplicação: " + e.getMessage());

        } finally {
            RavenDBUtil.fecharConexao();
        }
    }

}
