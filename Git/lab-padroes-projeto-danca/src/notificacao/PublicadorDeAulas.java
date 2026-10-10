package notificacao;

import java.util.ArrayList;
import java.util.List;
import modelo.PlanoDeAula;

/** O "sujeito" do Observer: guarda os ouvintes e avisa todos de uma vez. */
public class PublicadorDeAulas {
    private final List<OuvinteDeAula> ouvintes = new ArrayList<>();

    public void inscrever(OuvinteDeAula ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void publicar(PlanoDeAula plano) {
        ouvintes.forEach(o -> o.aulaGerada(plano));
    }
}
