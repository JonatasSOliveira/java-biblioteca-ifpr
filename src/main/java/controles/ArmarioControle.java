package controles;

import java.util.List;
import modelos.Armario;
import respostas.RespostaGenerica;
import servicos.ArmarioServico;

public class ArmarioControle {

    public static RespostaGenerica<List<Armario>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        return ArmarioServico.buscarPaginavelPorFiltro(pagina, filtro);
    }

    public static RespostaGenerica criar(Armario bibliotecario) {
        return ArmarioServico.criar(bibliotecario);
    }

    public static RespostaGenerica atualizar(Armario bibliotecario) {
        return ArmarioServico.atualizar(bibliotecario);
    }
    
    public static RespostaGenerica excluir(Armario bibliotecario) {
        return ArmarioServico.excluir(bibliotecario);
    }
}
