package servicos;

import dao.ArmarioDAO;
import modelos.Armario;
import respostas.RespostaGenerica;

public class ArmarioServico {

    public static final Integer COD_LOGIN_INVALIDO = 1;
    public static final Integer COD_LOGIN_VALIDO = 2;

    private static ArmarioDAO dao = new ArmarioDAO();

    public static RespostaGenerica<Armario> buscarPorNumero(String numeroArmario) {
        Armario armario = dao.buscarPorNumero(numeroArmario);
        if (armario == null) {
            return new RespostaGenerica<Armario>(COD_LOGIN_INVALIDO, null);
        }
        return new RespostaGenerica<Armario>(COD_LOGIN_VALIDO, armario);
    }

}
