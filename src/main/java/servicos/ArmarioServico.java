package servicos;

import dao.ArmarioDAO;
import java.util.List;
import modelos.Armario;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class ArmarioServico {

    private static final ArmarioDAO dao = new ArmarioDAO();

    public static RespostaGenerica<Armario> buscarPorNumero(String numeroArmario) {
        Armario armario = dao.buscarPorNumero(numeroArmario);
        if (armario == null) {
            return new RespostaGenerica<>(CodigosResposta.CODIGO_400_MAL_FORMULADO, "Armário não Encontrado!");
        }
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, armario);
    }

    public static RespostaGenerica<List<Armario>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        List<Armario> armarios = dao.buscarPaginavelPorFiltro(pagina, filtro);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, armarios);
    }

    public static RespostaGenerica criar(Armario armario) {
        try {
            dao.criar(armario);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

    public static RespostaGenerica atualizar(Armario armario) {
        try {
            dao.atualizar(armario);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

    public static RespostaGenerica excluir(Armario armario) {
        try {
            dao.excluir(armario);
            return new RespostaGenerica(CodigosResposta.CODIGO_200_SUCESSO);
        } catch (Exception e) {
            return new RespostaGenerica(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

}
