package passos;

import java.util.List;
import modelo.Nivel;
import modelo.Passo;

public class FabricaDeZouk extends FabricaDePassos {
    @Override
    protected List<Passo> criarCatalogo() {
        return List.of(
                new Passo("Base lateral", Nivel.INICIANTE),
                new Passo("Ondulação de corpo", Nivel.INICIANTE),
                new Passo("Giro da dama", Nivel.INTERMEDIARIO),
                new Passo("Troca de eixo", Nivel.INTERMEDIARIO),
                new Passo("Movimento de cabeça", Nivel.AVANCADO));
    }
}
