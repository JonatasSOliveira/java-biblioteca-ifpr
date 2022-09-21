package servicos;

import dao.EstudanteDAO;
import modelos.Estudante;
import respostas.RespostaGenerica;

public class EstudanteServico {
    public static final Integer COD_SUCESSO = 2;
    private static EstudanteDAO dao = new EstudanteDAO();

    public static RespostaGenerica<Estudante> autenticar(String ra, String senha) {
        Estudante estudante = dao.autenticarEstudante(ra, senha);
        return new RespostaGenerica<Estudante>(COD_SUCESSO, estudante);
    }
}
