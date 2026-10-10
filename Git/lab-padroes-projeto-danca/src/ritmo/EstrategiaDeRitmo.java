package ritmo;

import modelo.Nivel;

/**
 * Strategy: cada ritmo tem seu jeito de definir andamento, contagem
 * e quanto tempo a turma precisa para fixar um passo.
 */
public interface EstrategiaDeRitmo {
    String nome();

    int bpm(Nivel nivel);

    String contagem();

    /** Quantos minutos, em média, a turma leva para fixar um passo neste nível. */
    int minutosPorPasso(Nivel nivel);
}
