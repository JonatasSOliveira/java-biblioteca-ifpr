package servicos;

import dao.ReservaDAO;
import java.util.List;
import modelos.Armario;
import modelos.Estudante;
import modelos.Reserva;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class ReservaServico {

    private static final ReservaDAO dao = new ReservaDAO();

    public static RespostaGenerica<Reserva> reservar(String ra, String senha, String numeroArmario) {
        try {
            RespostaGenerica<Estudante> respostaEstudante = EstudanteServico.autenticar(ra, senha);
            Estudante estudante = respostaEstudante.getData();

            if (estudante == null) {
                return new RespostaGenerica<>(CodigosResposta.CODIGO_401_NAO_AUTORIZADO,
                        "Estudante não autenticado");
            }

            RespostaGenerica<Armario> respostaArmario = ArmarioServico.buscarPorNumero(numeroArmario);
            Armario armario = respostaArmario.getData();

            if (armario == null) {
                return new RespostaGenerica<>(CodigosResposta.CODIGO_400_MAL_FORMULADO,
                        "Armário não encontrado");
            }


            Reserva reservaPendente = dao.buscarPorEstudanteEDevolucaoNull(estudante);

            if (reservaPendente != null) {
                return new RespostaGenerica<>(CodigosResposta.CODIGO_409_CONFLITO, "Reserva Pendente");
            }

            Reserva reserva = new Reserva();
            reserva.setArmario(respostaArmario.getData());
            reserva.setEstudante(estudante);
            dao.criar(reserva);

            return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO,
                    "Reserva realizada com Sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespostaGenerica<>(CodigosResposta.CODIGO_500_ERRO_INTERNO);
        }
    }

    public static RespostaGenerica<Boolean> armarioDisponivel(String numeroArmario) {
        Reserva reserva = dao.buscarPorArmarioEDevolucaoIsNull(numeroArmario);
        if (reserva == null) {
            return new RespostaGenerica<>(CodigosResposta.CODIGO_409_CONFLITO, false,
                    "Armário Indisponível");
        }
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, true);
    }
    
    public static RespostaGenerica<Reserva> devolver (String ra, String senha, String numeroArmario) {
        return new RespostaGenerica<>(CodigosResposta.CODIGO_500_ERRO_INTERNO);
    }
    
     public static RespostaGenerica<List<Reserva>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        List<Reserva> reserva = dao.buscarPaginavelPorFiltro(pagina, filtro);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, reserva);
    }
}
