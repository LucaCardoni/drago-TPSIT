import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cavaliere {
    private final String nome;
    private Cavaliere maestro;
    private final List<Cavaliere> allievi;
    private final List<Drago> draghiUccisi;

    public Cavaliere(String nome) {
        this(nome, null);
    }

    public Cavaliere(String nome, Cavaliere maestro) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome del cavaliere non può essere vuoto");
        }
        this.nome = nome;
        this.allievi = new ArrayList<>();
        this.draghiUccisi = new ArrayList<>();
        if (maestro != null) {
            this.maestro = maestro;
            maestro.aggiungiAllievo(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public Cavaliere getMaestro() {
        return maestro;
    }

    public List<Cavaliere> getAllievi() {
        return Collections.unmodifiableList(allievi);
    }

    public List<Drago> getDraghiUccisi() {
        return Collections.unmodifiableList(draghiUccisi);
    }

    public void aggiungiAllievo(Cavaliere allievo) {
        if (allievo == null) {
            throw new IllegalArgumentException("L'allievo non può essere nullo");
        }
        if (allievo == this) {
            throw new IllegalArgumentException("Un cavaliere non può essere allievo di se stesso");
        }
        if (!allievi.contains(allievo)) {
            allievi.add(allievo);
            if (allievo.getMaestro() != this) {
                allievo.setMaestro(this);
            }
        }
    }

    public void rimuoviAllievo(Cavaliere allievo) {
        if (allievi.remove(allievo)) {
            if (allievo.getMaestro() == this) {
                allievo.setMaestro(null);
            }
        }
    }

    public void setMaestro(Cavaliere nuovoMaestro) {
        if (nuovoMaestro == this) {
            throw new IllegalArgumentException("Un cavaliere non può essere maestro di se stesso");
        }
        if (this.maestro != null) {
            this.maestro.allievi.remove(this);
        }
        this.maestro = nuovoMaestro;
        if (nuovoMaestro != null && !nuovoMaestro.allievi.contains(this)) {
            nuovoMaestro.allievi.add(this);
        }
    }

    void setMaestroInternal(Cavaliere m) {
        this.maestro = m;
    }

    public void uccidi(Drago drago) {
        if (drago == null) {
            throw new IllegalArgumentException("Il drago non può essere nullo");
        }
        drago.uccidi(this);
    }

    void registraDragoUcciso(Drago drago) {
        if (drago != null && !draghiUccisi.contains(drago)) {
            draghiUccisi.add(drago);
        }
    }

    public boolean isMaestro() {
        return !allievi.isEmpty();
    }

    public boolean isAllievo() {
        return maestro != null;
    }

    @Override
    public String toString() {
        return "Cavaliere{" + nome + (maestro != null ? ", maestro=" + maestro.getNome() : "") + "}";
    }
}
