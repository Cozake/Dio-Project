package modelo;

import java.util.List;

/** O que o professor informa para gerar uma aula. */
public record PedidoDeAula(String ritmo, Nivel nivel, int duracaoMinutos, List<String> alunos) {
}
