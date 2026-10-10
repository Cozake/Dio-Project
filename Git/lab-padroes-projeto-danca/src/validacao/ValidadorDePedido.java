package validacao;

import modelo.PedidoDeAula;

/**
 * Chain of Responsibility: cada elo faz uma checagem e passa o pedido
 * adiante. Se algo estiver errado, a corrente para na hora.
 */
public abstract class ValidadorDePedido {
    private ValidadorDePedido proximo;

    /** Devolve o próximo elo, para dar para encadear: a.depois(b).depois(c). */
    public ValidadorDePedido depois(ValidadorDePedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public final void validar(PedidoDeAula pedido) {
        checar(pedido);
        if (proximo != null) {
            proximo.validar(pedido);
        }
    }

    protected abstract void checar(PedidoDeAula pedido);
}
