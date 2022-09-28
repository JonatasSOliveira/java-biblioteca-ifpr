package servicos;

import dao.ReservaDAO;
import modelos.Armario;
import modelos.Estudante;
import modelos.Reserva;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class ReservaServico {

    private static final ReservaDAO dao = new ReservaDAO();

    public static RespostaGenerica<Reserva> emprestar(String ra, String senha, String numeroArmario) {
        try {
            RespostaGenerica<Estudante> respostaEstudante = EstudanteServico.autenticar(ra, senha);
            Estudante estudante = respostaEstudante.getData();

            if (estudante == null) {
                return new RespostaGenerica<>(CodigosResposta.CODIGO_401_NAO_AUTORIZADO, null);
            }

            RespostaGenerica<Armario> respostaArmario = ArmarioServico.buscarPorNumero(numeroArmario);
            Reserva reservaPendente = dao.buscarPorEstudanteEDevolucaoNull(estudante);

            if (reservaPendente != null) {
                return new RespostaGenerica<>(CodigosResposta.CODIGO_409_CONFLITO, null);
            }

            Reserva reserva = new Reserva();
            reserva.setArmario(respostaArmario.getData());
            reserva.setEstudante(estudante);
            dao.criar(reserva);

            return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespostaGenerica<>(CodigosResposta.CODIGO_500_ERRO_INTERNO, null);
        }
    }

    public static RespostaGenerica<Boolean> armarioDisponivel(String numeroArmario) {
        Reserva reserva = dao.buscarPorArmarioEDevolucaoIsNull(numeroArmario);
        if (reserva == null) {
            return new RespostaGenerica<>(CodigosResposta.CODIGO_409_CONFLITO, false);
        }
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, true);
    }
}
