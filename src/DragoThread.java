public class DragoThread implements Runnable {
    private final int battiti;
    private volatile boolean vivo = true;

    public DragoThread(int battiti) {
        if (battiti <= 0) {
            throw new IllegalArgumentException("I battiti di ali devono essere maggiori di zero");
        }
        this.battiti = battiti;
    }

    @Override
    public void run() {
        String nome = Thread.currentThread().getName();
        try {
            for (int i = 1; i <= battiti; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println(nome + " sta volando - battito d'ali " + i + "/" + battiti);
                Thread.sleep(1200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        vivo = false;
        if (Thread.currentThread().isInterrupted()) {
            System.out.println(nome + " e' stato colpito dal cacciatore e muore definitivamente.");
        } else {
            System.out.println(nome + " ha completato tutti i battiti di ali e si posa.");
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getBattiti() {
        return battiti;
    }
}
