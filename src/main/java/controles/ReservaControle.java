package controles;

import java.util.List;
import modelos.Reserva;
import respostas.RespostaGenerica;
import servicos.ReservaServico;

public class ReservaControle {

    public static RespostaGenerica<Reserva> reservar(String ra, String senha, String numeroArmario) {
        return ReservaServico.reservar(ra, senha, numeroArmario);
    }

    public static RespostaGenerica<Reserva> devolver(String ra, String senha, String numeroArmario) {
        return ReservaServico.devolver(ra, senha, numeroArmario);
    }

    public static RespostaGenerica<List<Reserva>> buscarPaginavelPorFiltro(int pagina, String filtro) {
        return ReservaServico.buscarPaginavelPorFiltro(pagina, filtro);
    }
}
