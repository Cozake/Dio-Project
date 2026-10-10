package passos;

import java.util.List;
import modelo.Nivel;
import modelo.Passo;

public class FabricaDeForro extends FabricaDePassos {
    @Override
    protected List<Passo> criarCatalogo() {
        return List.of(
                new Passo("Básico", Nivel.INICIANTE),
                new Passo("Troca de lados", Nivel.INICIANTE),
                new Passo("Giro simples da dama", Nivel.INTERMEDIARIO),
                new Passo("Cruzado", Nivel.INTERMEDIARIO),
                new Passo("Giro duplo com troca", Nivel.AVANCADO));
    }
}
