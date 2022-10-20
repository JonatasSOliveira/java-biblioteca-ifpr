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
}
