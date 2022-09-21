package controles;

import modelos.Bibliotecario;
import respostas.RespostaGenerica;
import servicos.BibliotecarioServico;

public class BibliotecarioControle {

    public static RespostaGenerica<Bibliotecario> autenticar(String login, String senha) {
        return BibliotecarioServico.autenticar(login, senha);
    }        
}
