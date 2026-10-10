package passos;

import java.util.List;
import modelo.Nivel;
import modelo.Passo;

public class FabricaDeSamba extends FabricaDePassos {
    @Override
    protected List<Passo> criarCatalogo() {
        return List.of(
                new Passo("Básico de ida e volta", Nivel.INICIANTE),
                new Passo("Caminhada", Nivel.INICIANTE),
                new Passo("Pêndulo", Nivel.INTERMEDIARIO),
                new Passo("Tesoura", Nivel.INTERMEDIARIO),
                new Passo("Bota-fogo", Nivel.INTERMEDIARIO),
                new Passo("Oito com giro", Nivel.AVANCADO));
    }
}
