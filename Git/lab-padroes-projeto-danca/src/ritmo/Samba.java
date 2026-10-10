package ritmo;

import modelo.Nivel;

public class Samba implements EstrategiaDeRitmo {
    @Override public String nome() { return "samba"; }

    @Override public int bpm(Nivel nivel) {
        return switch (nivel) {
            case INICIANTE -> 90;
            case INTERMEDIARIO -> 100;
            case AVANCADO -> 110;
        };
    }

    @Override public String contagem() { return "1-2-3-4 (marcação em 2 tempos fortes)"; }

    @Override public int minutosPorPasso(Nivel nivel) {
        return nivel == Nivel.INICIANTE ? 12 : 8;
    }
}
