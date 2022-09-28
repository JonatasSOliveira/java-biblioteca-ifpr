package respostas;

public class RespostaGenerica<T> {
    private CodigosResposta codigoResposta = null;
    private T data = null;
    private String mensagem = null;


    public RespostaGenerica(CodigosResposta codigoResposta) {
        if (codigoResposta == CodigosResposta.CODIGO_500_ERRO_INTERNO) {
            this.mensagem = "Erro Interno!";
        }
        this.codigoResposta = codigoResposta;
    }

    public RespostaGenerica(CodigosResposta codigoResposta, T data) {
        this.codigoResposta = codigoResposta;
        this.data = data;
    }

    public RespostaGenerica(CodigosResposta codigoResposta, String mensagem) {
        this.codigoResposta = codigoResposta;
        this.mensagem = mensagem;
    }


    public RespostaGenerica(CodigosResposta codigoResposta, T data, String mensagem) {
        this.codigoResposta = codigoResposta;
        this.data = data;
        this.mensagem = mensagem;
    }

    public CodigosResposta getCodigoResposta() {
        return codigoResposta;
    }

    public T getData() {
        return data;
    }

    public String getMensagem() {
        return mensagem;
    }
}
