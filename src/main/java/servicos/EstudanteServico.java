package servicos;

import dao.EstudanteDAO;
import java.util.List;
import modelos.Estudante;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class EstudanteServico {

    private static EstudanteDAO dao = new EstudanteDAO();

    public static RespostaGenerica<Estudante> autenticar(String ra, String senha) {
        Estudante estudante = dao.buscarPorRaESenha(ra, senha);
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudante);
    }
    
    public static RespostaGenerica<List<Estudante>> buscarTodos() {
        List<Estudante> estudantes = dao.buscarTodos();
        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, estudantes);
    }
}
