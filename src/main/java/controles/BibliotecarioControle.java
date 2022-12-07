package controles;

import java.util.List;
import modelos.Bibliotecario;
import respostas.RespostaGenerica;
import servicos.BibliotecarioServico;

public class BibliotecarioControle {

    public static RespostaGenerica<Bibliotecario> autenticar(String login, String senha) {
        return BibliotecarioServico.autenticar(login, senha);
    }

    public static RespostaGenerica<List<Bibliotecario>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        return BibliotecarioServico.buscarPaginavelPorFiltro(pagina, filtro);
    }

    public static RespostaGenerica criar(Bibliotecario bibliotecario) {
        return BibliotecarioServico.criar(bibliotecario);
    }

    public static RespostaGenerica atualizar(Bibliotecario bibliotecario) {
        return BibliotecarioServico.atualizar(bibliotecario);
    }
    
    public static RespostaGenerica excluir(Bibliotecario bibliotecario) {
        return BibliotecarioServico.excluir(bibliotecario);
    }
}
