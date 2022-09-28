package controles;

import modelos.Reserva;
import respostas.RespostaGenerica;
import servicos.ReservaServico;

public class ReservaControle {

    public static RespostaGenerica<Reserva> emprestar(String ra, String senha, String numeroArmario) {
        return ReservaServico.emprestar(ra, senha, numeroArmario);
    }
}
