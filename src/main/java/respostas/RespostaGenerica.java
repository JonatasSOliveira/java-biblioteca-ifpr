package respostas;

public class RespostaGenerica<T> {
    private CodigosResposta codigoResposta = null;
    private T data = null;

    public RespostaGenerica(CodigosResposta codigoResposta, T data) {
        this.codigoResposta = codigoResposta;
        this.data = data;
    }

    public CodigosResposta getCodigoResposta() {
        return codigoResposta;
    }

    public T getData() {
        return data;
    }
}
