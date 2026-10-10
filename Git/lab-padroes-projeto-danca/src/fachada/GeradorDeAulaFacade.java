package fachada;

import java.util.Map;
import modelo.PedidoDeAula;
import modelo.PlanoDeAula;
import notificacao.OuvinteDeAula;
import notificacao.PublicadorDeAulas;
import passos.FabricaDeForro;
import passos.FabricaDePassos;
import passos.FabricaDeSamba;
import passos.FabricaDeZouk;
import ritmo.EstrategiaDeRitmo;
import ritmo.Forro;
import ritmo.Samba;
import ritmo.Zouk;
import validacao.PedidoInvalidoException;
import validacao.ValidadorDeAlunos;
import validacao.ValidadorDeDuracao;
import validacao.ValidadorDeNivelPorDuracao;
import validacao.ValidadorDePedido;

/**
 * Facade: o Main só chama gerar(). Escolher o ritmo, validar, montar
 * os passos e avisar os ouvintes fica escondido aqui dentro.
 */
public class GeradorDeAulaFacade {

    private final Map<String, EstrategiaDeRitmo> ritmos = Map.of(
            "samba", new Samba(),
            "forro", new Forro(),
            "zouk", new Zouk());

    private final Map<String, FabricaDePassos> fabricas = Map.of(
            "samba", new FabricaDeSamba(),
            "forro", new FabricaDeForro(),
            "zouk", new FabricaDeZouk());

    private final ValidadorDePedido validacao;
    private final PublicadorDeAulas publicador = new PublicadorDeAulas();

    public GeradorDeAulaFacade() {
        // A ordem importa: checo duração primeiro porque é a validação mais barata.
        ValidadorDePedido inicio = new ValidadorDeDuracao();
        inicio.depois(new ValidadorDeAlunos())
              .depois(new ValidadorDeNivelPorDuracao());
        this.validacao = inicio;
    }

    public void inscrever(OuvinteDeAula ouvinte) {
        publicador.inscrever(ouvinte);
    }

    public PlanoDeAula gerar(PedidoDeAula pedido) {
        String chave = pedido.ritmo().toLowerCase();
        EstrategiaDeRitmo estrategia = ritmos.get(chave);
        if (estrategia == null) {
            throw new PedidoInvalidoException("Ritmo desconhecido: " + pedido.ritmo());
        }

        validacao.validar(pedido);

        int quantidade = Math.max(1,
                pedido.duracaoMinutos() / estrategia.minutosPorPasso(pedido.nivel()));

        PlanoDeAula plano = new PlanoDeAula(
                estrategia.nome(),
                pedido.nivel(),
                pedido.duracaoMinutos(),
                estrategia.bpm(pedido.nivel()),
                estrategia.contagem(),
                fabricas.get(chave).montarSequencia(pedido.nivel(), quantidade),
                pedido.alunos());

        publicador.publicar(plano);
        return plano;
    }
}
