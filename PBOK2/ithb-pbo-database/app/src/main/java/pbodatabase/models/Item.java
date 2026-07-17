package pbodatabase.models;

public abstract class Item {
    protected String nama;
    protected int totalUnit;
    protected double totalHarga;

    
    public Item(String nama, int totalUnit, double totalHarga) {
        this.nama = nama;
        this.totalUnit = totalUnit;
        this.totalHarga = totalHarga;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public double getHargaSatuan() {
        return totalHarga / totalUnit;
    }

    @Override
    public String toString() {
        return nama + ", total unit " + totalUnit + ", total harga " + totalHarga;
    }
}