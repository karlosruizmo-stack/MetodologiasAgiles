import java.util.Scanner;

public class JuegoCombate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje p1 = new Personaje("Guerrero", 100, 40);
        Personaje p2 = new Personaje("Mago Oscuro", 80, 60);

        while (p1.estaVivo() && p2.estaVivo()) {
            ejecutarTurno(sc, p1, p2);
            if (!p2.estaVivo()) break;

            ejecutarTurno(sc, p2, p1);


            p1.restaurarMana(5);
            p2.restaurarMana(5);
        }

        String ganador = p1.estaVivo() ? p1.getNombre() : p2.getNombre();
        System.out.println("\nGana " + ganador + " ");
    }

    public static void ejecutarTurno(Scanner sc, Personaje activo, Personaje oponente) {
        System.out.println("\nTurno de " + activo.getNombre() + " (Vida: " + activo.getVida() + " | Mana: " + activo.getMana() + ")");
        System.out.println("1. Ataque Físico | 2. Magia | 3. Curar");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> activo.atacarFisico(oponente);
            case 2 -> activo.usarMagia(oponente);
            case 3 -> activo.curar();
            default -> System.out.println("Pierdes el turno por distraído.");
        }
    }
}
