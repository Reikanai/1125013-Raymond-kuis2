package pbodatabase.models;

public class Armor extends Item {
    private int defenseValue;
    private String type; //Heavy, Medium, Light

    public Armor(String nama, double totalHarga, int defenseValue, String type) {
        super(nama, 1, totalHarga);//armor 1 unit selalu
        this.defenseValue = defenseValue;
        this.type = type;
    }
}