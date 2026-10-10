package modelo;

import java.util.List;

public record PlanoDeAula(String ritmo, Nivel nivel, int duracaoMinutos, int bpm,
                          String contagem, List<Passo> passos, List<String> alunos) {

    public void imprimir() {
        System.out.println("=== Aula de " + ritmo + " | " + nivel.name().toLowerCase()
                + " | " + duracaoMinutos + " min ===");
        System.out.println("Música: ~" + bpm + " BPM | Contagem: " + contagem);
        System.out.println("Alunos: " + String.join(", ", alunos));
        System.out.println("Passos:");
        for (int i = 0; i < passos.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + passos.get(i));
        }
    }
}
