package validacao;

import modelo.Nivel;
import modelo.PedidoDeAula;

public class ValidadorDeNivelPorDuracao extends ValidadorDePedido {
    @Override
    protected void checar(PedidoDeAula pedido) {
        // Iniciante cansa e perde a condução em aula muito longa.
        if (pedido.nivel() == Nivel.INICIANTE && pedido.duracaoMinutos() > 90) {
            throw new PedidoInvalidoException(
                    "Aula de iniciante com mais de 90 min rende pouco. Divida em duas.");
        }
    }
}
