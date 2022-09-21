package servicos;

import dao.EstudanteDAO;
import dao.ReservaDAO;
import modelos.Armario;
import modelos.Estudante;
import modelos.Reserva;
import respostas.RespostaGenerica;

public class ReservaServico {

    public static final int COD_SUCESSO = 1;
    public static final int COD_ARMARIO_INDISPONIVEL = 2;
    public static final int COD_ESTUDANTE_EMPRESTIMO_PENDENTE = 3;

    public static  final int COD_ERRO = 4;

    private static ReservaDAO dao = new ReservaDAO();

    public static RespostaGenerica emprestar(String ra, String senha, String numeroArmario) {
        RespostaGenerica<Estudante> respostaEstudante = EstudanteServico.autenticar(ra, senha);
        if (respostaEstudante.getData() == null) {
            return new RespostaGenerica(COD_ERRO, null);
        }

        RespostaGenerica<Armario> respostaArmario = ArmarioServico.buscarPorNumero(numeroArmario);

        if (respostaArmario.getData() == null) {
            return new RespostaGenerica(COD_ERRO, null);
        }

        Reserva reservaPendente = dao.buscarPorEstudanteEDevolucaoNull(respostaEstudante.getData());

        if (reservaPendente != null) {
            return new RespostaGenerica(COD_ESTUDANTE_EMPRESTIMO_PENDENTE, null);
        }

        Reserva reserva = new Reserva();
        reserva.setArmario(respostaArmario.getData());
        reserva.setEstudante(respostaEstudante.getData());
        dao.criar(reserva);

        return new RespostaGenerica(COD_SUCESSO, null);
    }

    public static RespostaGenerica armarioDisponivel(String numeroArmario) {
        Reserva reserva = dao.buscarPorArmarioEDevolucaoIsNull(numeroArmario);
        if(reserva == null) {
            return new RespostaGenerica(COD_ARMARIO_INDISPONIVEL, null );
        }
        return new RespostaGenerica(COD_SUCESSO, null);
    }
}
