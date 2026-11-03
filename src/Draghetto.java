public class Draghetto {
    private String nome;
    private int energia;
    private int fame;

    public Draghetto(String nome) {
        this.nome = nome;
        energia = 100;
        fame = 30;
    }

    public void mangia() {
        fame = Math.max(0, fame - 20);
        System.out.println(nome + " sgranocchia un marshmallow vulcanico! Fame ridotta.");
    }

    public void vola(int numBattiti) {
        for (int i = 0; i < numBattiti; i++) {
            energia = Math.max(0, energia - 1);
            fame = Math.min(100, fame + 1);
            System.out.println("sto volando");
        }
    }

    public void gioca() {
        energia = Math.max(0, energia - 20);
        fame = Math.min(100, fame + 15);
        System.out.println(nome + " fa un salto mortale e sputa una fiammella! Divertimento puro!");
    }

    public void riposa() {
        energia = Math.min(100, energia + 40);
        System.out.println(nome + " si appallottola e fa un pisolino... Zzz...");
    }

    public void mostraStato() {
        System.out.println("Nome: " + nome);
        System.out.println("Energia: " + energia);
        System.out.println("Fame: " + fame);
        System.out.println();
    }

    
}



