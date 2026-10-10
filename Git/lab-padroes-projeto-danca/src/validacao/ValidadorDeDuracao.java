package validacao;

import modelo.PedidoDeAula;

public class ValidadorDeDuracao extends ValidadorDePedido {
    @Override
    protected void checar(PedidoDeAula pedido) {
        int min = pedido.duracaoMinutos();
        if (min < 30 || min > 120) {
            throw new PedidoInvalidoException(
                    "Duração de " + min + " min fora do permitido (entre 30 e 120).");
        }
    }
}
