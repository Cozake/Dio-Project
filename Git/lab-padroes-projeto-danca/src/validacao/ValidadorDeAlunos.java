package validacao;

import modelo.PedidoDeAula;

public class ValidadorDeAlunos extends ValidadorDePedido {
    @Override
    protected void checar(PedidoDeAula pedido) {
        int total = pedido.alunos().size();
        if (total < 2) {
            throw new PedidoInvalidoException("Dança de par precisa de pelo menos 2 alunos.");
        }
        if (total % 2 != 0) {
            throw new PedidoInvalidoException(
                    "Número ímpar de alunos (" + total + "): alguém ficaria sem par.");
        }
    }
}
