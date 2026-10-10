package modelo;

public enum Nivel {
    INICIANTE, INTERMEDIARIO, AVANCADO;

    /** Diz se este nível já alcança o nível mínimo exigido por um passo. */
    public boolean alcanca(Nivel minimo) {
        return this.ordinal() >= minimo.ordinal();
    }
}
