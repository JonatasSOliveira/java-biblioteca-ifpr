package controles;

import modelos.Reserva;
import respostas.RespostaGenerica;
import servicos.ReservaServico;

public class ReservaControle {

    public static RespostaGenerica<Reserva> reservar(String ra, String senha, String numeroArmario) {
        return ReservaServico.reservar(ra, senha, numeroArmario);
    }

    public static RespostaGenerica<Reserva> devolver(String ra, String senha, String numeroArmario) {

    }
}
