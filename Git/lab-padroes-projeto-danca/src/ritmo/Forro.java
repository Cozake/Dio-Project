package ritmo;

import modelo.Nivel;

public class Forro implements EstrategiaDeRitmo {
    @Override public String nome() { return "forro"; }

    @Override public int bpm(Nivel nivel) {
        return switch (nivel) {
            case INICIANTE -> 100;
            case INTERMEDIARIO -> 115;
            case AVANCADO -> 125;
        };
    }

    @Override public String contagem() { return "1-2-3 / 4-5-6 (lento-lento-rápido)"; }

    @Override public int minutosPorPasso(Nivel nivel) {
        return nivel == Nivel.INICIANTE ? 10 : 7;
    }
}
