package pbodatabase.lelang;

import java.util.ArrayList;
import java.util.List;

//Generic Class & Bounded Type (nerima anak dari class Item aja)
public class AuctionList<T extends Item> {
    private List<T> listBarang = new ArrayList<>();

    public void tambahBarang(T barang) {
        listBarang.add(barang);
    }


    public List<T> getList() {
        return listBarang;
    }

    //disini Generic Method (buat priny + sort list Item krng tau)
    public static <E extends Item> void printSortedByTotal(List<E> items) throws EmptyListException {

    }

    //disini Generic method
    public static <E extends Item> void printSortedByUnit(List<E> items) throws EmptyListException {
    }
}