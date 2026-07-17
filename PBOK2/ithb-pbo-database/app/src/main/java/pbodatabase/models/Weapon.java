package pbodatabase.models;

public class Weapon extends Item {
    private int attackValue;
    private String type; // Sword, Axe, Spear, Bow

    public Weapon(String nama, double totalHarga, int attackValue, String type) {
        // Weapon selalu 1 unit
        super(nama, 1, totalHarga);
        this.attackValue = attackValue;
        this.type = type;
    }
}