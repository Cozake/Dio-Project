package ritmo;

import modelo.Nivel;

public class Zouk implements EstrategiaDeRitmo {
    @Override public String nome() { return "zouk"; }

    @Override public int bpm(Nivel nivel) {
        return switch (nivel) {
            case INICIANTE -> 80;
            case INTERMEDIARIO -> 90;
            case AVANCADO -> 100;
        };
    }

    @Override public String contagem() { return "1-2-3 / 4-5-6 (ondulação no tempo 1)"; }

    // Zouk pede mais tempo por passo: a condução e a ondulação demoram para entrar.
    @Override public int minutosPorPasso(Nivel nivel) {
        return nivel == Nivel.INICIANTE ? 15 : 10;
    }
}
