import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principessa {
    private final String nome;
    private Drago dragoImprigionante;

    public Principessa(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome della principessa non può essere vuoto");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Drago getDragoImprigionante() {
        return dragoImprigionante;
    }

    public boolean isImprigionata() {
        return dragoImprigionante != null;
    }

    void setDragoImprigionante(Drago drago) {
        this.dragoImprigionante = drago;
    }

    @Override
    public String toString() {
        return "Principessa{" + nome + (isImprigionata() ? ", imprigionata da " + dragoImprigionante.getNome() : "") + "}";
    }
}
