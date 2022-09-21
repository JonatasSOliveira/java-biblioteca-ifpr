package respostas;

public class RespostaGenerica<T> {
    private Integer codigoResposta = null;
    private T data = null;

    public RespostaGenerica(Integer codigoResposta, T data) {
        this.codigoResposta = codigoResposta;
        this.data = data;
    }

    public Integer getCodigoResposta() {
        return codigoResposta;
    }

    public T getData() {
        return data;
    }
}
