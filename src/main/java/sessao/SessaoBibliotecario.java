package sessao;

import modelos.Bibliotecario;

public class SessaoBibliotecario {
    private static Bibliotecario bibliotecarioLogado;

    public static Bibliotecario getBibliotecarioLogado() {
        return bibliotecarioLogado;
    }

    public static void setBibliotecarioLogado(Bibliotecario bibliotecarioLogado) {
        SessaoBibliotecario.bibliotecarioLogado = bibliotecarioLogado;
    }    
    
}
