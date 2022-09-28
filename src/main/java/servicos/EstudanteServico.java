package servicos;

import dao.EstudanteDAO;
import modelos.Estudante;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class EstudanteServico {

    private static EstudanteDAO dao = new EstudanteDAO();

    public static RespostaGenerica<Estudante> autenticar(String ra, String senha) {
        Estudante estudante = dao.autenticarEstudante(ra, senha);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudante);
    }
}
