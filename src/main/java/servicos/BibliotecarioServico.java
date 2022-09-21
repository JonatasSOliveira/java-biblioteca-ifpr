package servicos;

import dao.BibliotecarioDAO;
import modelos.Bibliotecario;
import respostas.RespostaGenerica;

public class BibliotecarioServico {

    public static final Integer COD_LOGIN_INVALIDO = 1;
    public static final Integer COD_LOGIN_VALIDO = 2;
    private static BibliotecarioDAO dao = new BibliotecarioDAO();

    public static RespostaGenerica<Bibliotecario> autenticar(String login, String senha) {
        Bibliotecario bibliotecario = dao.buscarPorLoginESenha(login, senha);
        if (bibliotecario == null) {
            return new RespostaGenerica<Bibliotecario>(COD_LOGIN_INVALIDO, null);

        }

        return new RespostaGenerica<Bibliotecario>(COD_LOGIN_VALIDO, bibliotecario);
    }

}
