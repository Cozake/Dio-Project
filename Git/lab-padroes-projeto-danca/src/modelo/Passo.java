package modelo;

public record Passo(String nome, Nivel nivelMinimo) {
    @Override
    public String toString() {
        return nome + " (" + nivelMinimo.name().toLowerCase() + ")";
    }
}
