import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di battiti di ali del drago: ");
        int battiti = Integer.parseInt(scanner.nextLine());

        Thread drago = new Thread(new DragoThread(battiti), "Drago");
        drago.start();

        Cacciatore cacciatore = new Cacciatore();

        for (int i = 1; i <= battiti; i++) {
            System.out.println("Sto osservando il drago - osservazione " + i + "/" + battiti);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        cacciatore.colpisciDrago(drago);

        try {
            drago.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Fine del main.");
        scanner.close();
    }
}
