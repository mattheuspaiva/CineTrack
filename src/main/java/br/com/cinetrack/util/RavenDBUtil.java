package br.com.cinetrack.util;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

public class RavenDBUtil {

    private static final String URL = "http://127.0.0.1:56698";
    private static final String BANCO = "CineTrack";

    private static final IDocumentStore STORE;

    static {
        STORE = new DocumentStore(new String[]{URL}, BANCO);

        STORE.initialize();
    }

    public static IDocumentStore getStore() {
        return STORE;
    }

    public static void fecharConexao() {
        STORE.close();
    }
}
