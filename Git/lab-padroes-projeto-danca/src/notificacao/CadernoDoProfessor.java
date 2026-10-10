package notificacao;

import java.util.ArrayList;
import java.util.List;
import modelo.PlanoDeAula;

/** Guarda o histórico das aulas geradas, como um caderno de planejamento. */
public class CadernoDoProfessor implements OuvinteDeAula {
    private final List<String> historico = new ArrayList<>();

    @Override
    public void aulaGerada(PlanoDeAula plano) {
        historico.add(plano.ritmo() + " / " + plano.nivel().name().toLowerCase()
                + " / " + plano.passos().size() + " passos");
        System.out.println("[Caderno] Anotado. Aulas planejadas até agora: " + historico.size());
    }

    public List<String> historico() {
        return List.copyOf(historico);
    }
}
