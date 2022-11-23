package sessao;

import java.time.LocalDateTime;
import modelos.Bibliotecario;

public class SessaoBibliotecario {

    private static Bibliotecario bibliotecarioLogado;
    private static LocalDateTime dataHoraLogin;

    public static Bibliotecario getBibliotecarioLogado() {
        return bibliotecarioLogado;
    }

    public static void setBibliotecarioLogado(Bibliotecario bibliotecarioLogado) {
        SessaoBibliotecario.dataHoraLogin = LocalDateTime.now();
        SessaoBibliotecario.bibliotecarioLogado = bibliotecarioLogado;
    }

}
