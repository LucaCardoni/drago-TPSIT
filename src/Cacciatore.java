public class Cacciatore {
    public void colpisciDrago(Thread drago) {
        if (drago == null) {
            throw new IllegalArgumentException("Il drago non puo' essere nullo");
        }
        System.out.println("Il cacciatore scaglia la freccia contro il drago: " + drago.getName());
        drago.interrupt();
    }
}
