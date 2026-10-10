package passos;

import java.util.List;
import modelo.Nivel;
import modelo.Passo;

/**
 * Factory Method: a montagem da sequência é igual para todo ritmo,
 * mas o catálogo de passos (o que é criado) muda em cada subclasse.
 */
public abstract class FabricaDePassos {

    /** O factory method: cada ritmo diz quais passos existem. */
    protected abstract List<Passo> criarCatalogo();

    public List<Passo> montarSequencia(Nivel nivel, int quantidade) {
        return criarCatalogo().stream()
                .filter(p -> nivel.alcanca(p.nivelMinimo()))
                .limit(quantidade)
                .toList();
    }
}
