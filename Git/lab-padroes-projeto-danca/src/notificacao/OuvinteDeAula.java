package notificacao;

import modelo.PlanoDeAula;

/** Observer: quem quiser saber quando uma aula é gerada implementa isto. */
public interface OuvinteDeAula {
    void aulaGerada(PlanoDeAula plano);
}
