package notificacao;

import modelo.PlanoDeAula;

/** Simula o envio de mensagem para cada aluno (aqui só imprime). */
public class AvisoNoWhatsApp implements OuvinteDeAula {
    @Override
    public void aulaGerada(PlanoDeAula plano) {
        for (String aluno : plano.alunos()) {
            System.out.println("[WhatsApp] Oi, " + aluno + "! Sua aula de " + plano.ritmo()
                    + " está confirmada (" + plano.duracaoMinutos() + " min).");
        }
    }
}
