public enum CategoriaDrago {
    SPUTA_FUOCO("Sputa fuoco", "Soffio di fuoco micidiale"),
    SPUTA_GHIACCIO("Sputa ghiaccio", "Soffio di ghiaccio micidiale"),
    LANCIA_ROCCE("Lancia rocce", "Lancio di rocce micidiale");

    private final String nome;
    private final String potereMicidiale;

    CategoriaDrago(String nome, String potereMicidiale) {
        this.nome = nome;
        this.potereMicidiale = potereMicidiale;
    }

    public String getNome() {
        return nome;
    }

    public String getPotereMicidiale() {
        return potereMicidiale;
    }

    @Override
    public String toString() {
        return nome;
    }
}
