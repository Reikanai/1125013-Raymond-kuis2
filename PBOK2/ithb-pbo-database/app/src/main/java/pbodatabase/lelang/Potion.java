package pbodatabase.lelang;

public class Potion extends Item {
    private int hpRestore;
    private int manaRestore;

    public Potion(String nama, int totalUnit, double totalHarga, int hpRestore, int manaRestore) {
        super(nama, totalUnit, totalHarga);
        this.hpRestore = hpRestore;
        this.manaRestore = manaRestore;
    }
}