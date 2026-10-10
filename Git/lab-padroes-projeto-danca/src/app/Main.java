package app;

import fachada.GeradorDeAulaFacade;
import java.util.List;
import modelo.Nivel;
import modelo.PedidoDeAula;
import notificacao.AvisoNoWhatsApp;
import notificacao.CadernoDoProfessor;
import validacao.PedidoInvalidoException;

public class Main {
    public static void main(String[] args) {
        GeradorDeAulaFacade gerador = new GeradorDeAulaFacade();
        gerador.inscrever(new AvisoNoWhatsApp());
        gerador.inscrever(new CadernoDoProfessor());

        List<PedidoDeAula> pedidos = List.of(
                new PedidoDeAula("zouk", Nivel.INICIANTE, 60, List.of("Ana", "Bruno", "Carla", "Diego")),
                new PedidoDeAula("forro", Nivel.INTERMEDIARIO, 60, List.of("Elisa", "Fábio")),
                new PedidoDeAula("samba", Nivel.INICIANTE, 120, List.of("Gabi", "Hugo")),
                new PedidoDeAula("samba", Nivel.AVANCADO, 90, List.of("Iara", "João", "Karen")));

        for (PedidoDeAula pedido : pedidos) {
            System.out.println();
            try {
                gerador.gerar(pedido).imprimir();
            } catch (PedidoInvalidoException e) {
                System.out.println("Pedido recusado (" + pedido.ritmo() + "): " + e.getMessage());
            }
        }
    }
}
