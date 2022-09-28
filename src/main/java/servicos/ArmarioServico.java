package servicos;

import dao.ArmarioDAO;
import modelos.Armario;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class ArmarioServico {

    private static final ArmarioDAO dao = new ArmarioDAO();

    public static RespostaGenerica<Armario> buscarPorNumero(String numeroArmario) {
        Armario armario = dao.buscarPorNumero(numeroArmario);
        if (armario == null) {
            return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, null);
        }
        return new RespostaGenerica<>(CodigosResposta.CODIGO_401_NAO_AUTORIZADO, armario);
    }

}
