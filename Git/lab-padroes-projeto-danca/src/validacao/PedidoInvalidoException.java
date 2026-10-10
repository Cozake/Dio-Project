package validacao;

public class PedidoInvalidoException extends RuntimeException {
    public PedidoInvalidoException(String motivo) {
        super(motivo);
    }
}
