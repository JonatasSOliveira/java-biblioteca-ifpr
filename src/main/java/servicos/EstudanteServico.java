package servicos;

import dao.EstudanteDAO;
import java.util.List;
import modelos.Estudante;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class EstudanteServico {

    private static EstudanteDAO dao = new EstudanteDAO();

    public static RespostaGenerica<Estudante> autenticar(String ra, String senha) {
        Estudante estudante = dao.buscarPorRaESenha(ra, senha);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudante);
    }

    public static RespostaGenerica<List<Estudante>> buscarTodos() {
        List<Estudante> estudantes = dao.buscarTodos();
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudantes);
    }

    public static RespostaGenerica<List<Estudante>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        List<Estudante> estudantes = dao.buscarPaginavelPorFiltro(pagina, filtro);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudantes);
    }

    public static RespostaGenerica criar(Estudante estudante) {
        try {
            dao.criar(estudante);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

    public static RespostaGenerica atualizar(Estudante estudante) {
        try {
            dao.atualizar(estudante);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

    public static RespostaGenerica excluir(Estudante estudante) {
        try {
            dao.excluir(estudante);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }
}
