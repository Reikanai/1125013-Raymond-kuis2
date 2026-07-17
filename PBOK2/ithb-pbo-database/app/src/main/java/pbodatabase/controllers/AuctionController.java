package pbodatabase.controllers;

import pbodatabase.models.*;
import pbodatabase.repositories.AuctionList;
import pbodatabase.exceptions.EmptyListException;

public class AuctionController {
    private AuctionList<Potion> potionList = new AuctionList<>();
    private AuctionList<Weapon> weaponList = new AuctionList<>();
    private AuctionList<Armor> armorList = new AuctionList<>();

    public void addPotion(String nama, double totalHarga, int totalUnit, int hp, int mana) {
        potionList.tambahBarang(new Potion(nama, totalUnit, totalHarga, hp, mana));
    }

    public void addWeapon(String nama, double totalHarga, int attack, String type) {
        weaponList.tambahBarang(new Weapon(nama, totalHarga, attack, type));
    }

    public void addArmor(String nama, double totalHarga, int defense, String type) {
        armorList.tambahBarang(new Armor(nama, totalHarga, defense, type));
    }

    public void showSortedByTotal(String kategori) throws EmptyListException {
        if (kategori.equalsIgnoreCase("Potion"))
            AuctionList.printSortedByTotal(potionList.getList());
        else if (kategori.equalsIgnoreCase("Weapon"))
            AuctionList.printSortedByTotal(weaponList.getList());
        else if (kategori.equalsIgnoreCase("Armor"))
            AuctionList.printSortedByTotal(armorList.getList());
        else
            System.out.println("Kategori tidak valid... coba lagi");
    }

    public void showSortedByUnit(String kategori) throws EmptyListException {
        if (kategori.equalsIgnoreCase("Potion"))
            AuctionList.printSortedByUnit(potionList.getList());
        else if (kategori.equalsIgnoreCase("Weapon"))
            AuctionList.printSortedByUnit(weaponList.getList());
        else if (kategori.equalsIgnoreCase("Armor"))
            AuctionList.printSortedByUnit(armorList.getList());
        else
            System.out.println("Kategori tidak valid... coba lagi");
    }
}