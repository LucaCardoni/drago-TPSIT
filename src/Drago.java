import java.util.Objects;

public class Drago {
    private final String nome;
    private final CategoriaDrago categoria;
    private Principessa principessaImprigionata;
    private Cavaliere uccisore;

    public Drago(String nome, CategoriaDrago categoria) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome del drago non può essere vuoto");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria del drago non può essere nulla");
        }
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDrago getCategoria() {
        return categoria;
    }

    public String getPotereMicidiale() {
        return categoria.getPotereMicidiale();
    }

    public Principessa getPrincipessaImprigionata() {
        return principessaImprigionata;
    }

    public boolean hasPrincipessaImprigionata() {
        return principessaImprigionata != null;
    }

    public void imprigiona(Principessa principessa) {
        if (principessa == null) {
            throw new IllegalArgumentException("La principessa non può essere nulla");
        }
        if (this.principessaImprigionata != null) {
            throw new IllegalStateException("Questo drago tiene già imprigionata una principessa");
        }
        if (principessa.isImprigionata() && principessa.getDragoImprigionante() != this) {
            throw new IllegalStateException("La principessa è già imprigionata da un altro drago");
        }
        this.principessaImprigionata = principessa;
        if (principessa.getDragoImprigionante() != this) {
            principessa.setDragoImprigionante(this);
        }
    }

    public void liberaPrincipessa() {
        if (principessaImprigionata != null) {
            Principessa p = principessaImprigionata;
            principessaImprigionata = null;
            if (p.getDragoImprigionante() == this) {
                p.setDragoImprigionante(null);
            }
        }
    }

    public Cavaliere getUccisore() {
        return uccisore;
    }

    public boolean isUcciso() {
        return uccisore != null;
    }

    public void uccidi(Cavaliere cavaliere) {
        if (cavaliere == null) {
            throw new IllegalArgumentException("Il cavaliere non può essere nullo");
        }
        if (this.uccisore != null) {
            throw new IllegalStateException("Questo drago è già stato ucciso");
        }
        this.uccisore = cavaliere;
        if (!cavaliere.getDraghiUccisi().contains(this)) {
            cavaliere.registraDragoUcciso(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drago)) return false;
        Drago drago = (Drago) o;
        return Objects.equals(nome, drago.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Drago{" + nome + ", categoria=" + categoria + ", potere=" + getPotereMicidiale() + "}";
    }
}
