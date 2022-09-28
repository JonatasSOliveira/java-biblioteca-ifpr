package servicos;

import dao.BibliotecarioDAO;
import modelos.Bibliotecario;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;

public class BibliotecarioServico {

    private static final BibliotecarioDAO dao = new BibliotecarioDAO();

    public static RespostaGenerica<Bibliotecario> autenticar(String login, String senha) {
        Bibliotecario bibliotecario = dao.buscarPorLoginESenha(login, senha);
        if (bibliotecario == null) {
            return new RespostaGenerica<>(CodigosResposta.CODIGO_401_NAO_AUTORIZADO,
                    "Bibliotecário não Encontrado");

        }

        return new RespostaGenerica<>(CodigosResposta.CODIGO_200_SUCESSO, bibliotecario,
                "Bibliotecário Autenticado");
    }

}
