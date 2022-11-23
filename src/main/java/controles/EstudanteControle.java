package controles;

import java.util.List;
import modelos.Estudante;
import respostas.RespostaGenerica;
import servicos.EstudanteServico;

public class EstudanteControle {

    public static RespostaGenerica<Estudante> autenticar(String ra, String senha) {
        return EstudanteServico.autenticar(ra, senha);
    }

    public static RespostaGenerica<List<Estudante>> buscarTodos() {
        return EstudanteServico.buscarTodos();
    }

    public static RespostaGenerica<List<Estudante>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        return EstudanteServico.buscarPaginavelPorFiltro(pagina, filtro);
    }

    public static RespostaGenerica criar(Estudante estudante) {
        return EstudanteServico.criar(estudante);
    }

    public static RespostaGenerica atualizar(Estudante estudante) {
        return EstudanteServico.atualizar(estudante);
    }

    public static RespostaGenerica excluir(Estudante estudante) {
        return EstudanteServico.excluir(estudante);
    }
}
