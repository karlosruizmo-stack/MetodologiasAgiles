import java.util.Random;

public class Personaje {
    private String nombre;
    private int vida;
    private int mana;
    private final int VIDA_MAX;
    private Random random = new Random();

    public Personaje(String nombre, int vida, int mana) {
        this.nombre = nombre;
        this.vida = vida;
        this.VIDA_MAX = vida;
        this.mana = mana;
    }


    public void atacarFisico(Personaje enemigo) {
        if (random.nextInt(100) < 30) {
            System.out.println(nombre + " fallo.");
        } else {
            int daño = 15 + random.nextInt(10);
            System.out.println(nombre + " golpea a " + enemigo.getNombre() + " por " + daño + " de daño.");
            enemigo.recibirDaño(daño);
        }
    }


    public void usarMagia(Personaje enemigo) {
        if (this.mana >= 20) {
            int daño = 25 + random.nextInt(15);
            this.mana -= 20;
            System.out.println(nombre + " lanza un hechizo a " + enemigo.getNombre() + " por " + daño + " de daño!");
            enemigo.recibirDaño(daño);
        } else {
            System.out.println(nombre + " no tienes suficiente maná.");
        }
    }


    public void curar() {
        if (this.mana >= 15) {
            int cura = 20;
            this.vida = Math.min(this.vida + cura, VIDA_MAX);
            this.mana -= 15;
            System.out.println(nombre + " te curas " + vida);
        } else {
            System.out.println(nombre + " no tiene maná para curarse.");
        }
    }

    public void restaurarMana(int cantidad) {
        this.mana += cantidad;
    }

    public void recibirDaño(int daño) {
        this.vida -= daño;
    }


    public boolean estaVivo() { return vida > 0; }
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
}
