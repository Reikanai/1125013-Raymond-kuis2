package pbodatabase.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pbodatabase.exceptions.EmptyListException;
import pbodatabase.models.Item;

//Generic Class & Bounded Type (cuma terima anak class Item)
public class AuctionList<T extends Item> {
    private List<T> listBarang = new ArrayList<>();

    public void tambahBarang(T barang) {
        listBarang.add(barang);
    }


    public List<T> getList() {
        return listBarang;
    }

    //Generic Method
    public static <E extends Item> void printSortedByTotal(List<E> items) throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Daftar barang lelang dikategori ini masih kosong.");
        }

        List<E> temp = new ArrayList<>(items);

        //List Util + Anonymous Inner Class bagian Comparator
        Collections.sort(temp, new Comparator<E>() {
            @Override
            public int compare(E a, E b) {
                return Double.compare(a.getTotalHarga(), b.getTotalHarga());
            }
        });

        System.out.println("=== Urutan Harga Total Keseluruhan Termurah ===");
        for (E item : temp) {
            System.out.println(item.toString());
        }
    }

    //Generic Method
    public static <E extends Item> void printSortedByUnit(List<E> items) throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Daftar barang lelang dikategori ini masih kosong.");
        }

        List<E> temp = new ArrayList<>(items);

        //Anonymous Inner Class
        Collections.sort(temp, new Comparator<E>() {
            @Override
            public int compare(E a, E b) {
                return Double.compare(a.getHargaSatuan(), b.getHargaSatuan());
            }
        });

        System.out.println("=== Urutan Harga Satuan Termurah ===");
        for (E item : temp) {
            System.out.println(item.toString() + " (harga satuan @" + item.getHargaSatuan() + ")");
        }
    }
}