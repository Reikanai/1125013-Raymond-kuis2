package pbodatabase.views;

import pbodatabase.controllers.AuctionController;
import pbodatabase.utils.CLIUtil;
import pbodatabase.exceptions.*;

public class AuctionView {
    private AuctionController controller;

    public AuctionView(AuctionController controller) {
        this.controller = controller;
    }

    public void displayMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n===== APLIKASI LELANG GAME =====");
            System.out.println("1.Tambah Barang Lelang");
            System.out.println("2.Tampilkan berdasarkan harga total termurah");
            System.out.println("3.Tampilkan berdasarkan harga satuan termurah");
            System.out.println("4 Keluar");

            try {
                int menu = CLIUtil.getInt("Pilih menu : ");

                switch (menu) {
                    case 1:
                        menuTambahBarang();
                        break;
                    case 2:
                        menuTampilTotal();
                        break;
                    case 3:
                        menuTampilSatuan();
                        break;
                    case 4:
                        isRunning = false;
                        System.out.println("Exited, terimakasih!");
                        break;
                    default:
                        System.out.println("Menu tidak ada... mohon coba lagi.");
                }
            } catch (EmptyInputException | InvalidNumberException | EmptyListException e) {
                System.out.println(">> ERROR : " + e.getMessage());
            } catch (Exception e) {
                System.out.println(">> Fatal ERROR : " + e.getMessage());
            }
        }
    }

    private void menuTambahBarang() throws EmptyInputException, InvalidNumberException {
        String kategori = CLIUtil.getString("Masukkan kategori (Potion/Weapon/Armor) : ");
        String nama = CLIUtil.getString("Nama barang : ");
        double totalHarga = CLIUtil.getDouble("Total Harga keseluruhan : ");

        if (kategori.equalsIgnoreCase("Potion")) {
            int totalUnit = CLIUtil.getInt("Jumlah Unit Potion : ");
            int hp = CLIUtil.getInt("HP Restore Value : ");
            int mana = CLIUtil.getInt("Mana Restore Value : ");

            controller.addPotion(nama, totalHarga, totalUnit, hp, mana);
            System.out.println("Potion berhasil dilelang, selamat!");

        } else if (kategori.equalsIgnoreCase("Weapon")) {
            String type = CLIUtil.getString("Tipe Weapon (Sword/Axe/Spear/Bow) : ");
            int attack = CLIUtil.getInt("Attack Value : ");
            controller.addWeapon(nama, totalHarga, attack, type);
            System.out.println("Weapon berhasil dilelang, selamat!");

        } else if (kategori.equalsIgnoreCase("Armor")) {
            String type = CLIUtil.getString("Tipe Armor (Heavy/Medium/Light) : ");
            int defense = CLIUtil.getInt("Defense Value : ");
            controller.addArmor(nama, totalHarga, defense, type);
            System.out.println("Armor berhasil dilelang, selamat!");
        } else {
            System.out.println("Kategori tidak valid... coba lagi");
        }
    }

    private void menuTampilTotal() throws EmptyInputException, EmptyListException {
        String kat = CLIUtil.getString("Pilih Kategori untuk dilihat (Potion/Weapon/Armor) : ");
        controller.showSortedByTotal(kat);
    }

    private void menuTampilSatuan() throws EmptyInputException, EmptyListException {
        String kat = CLIUtil.getString("Pilih Kategori untuk dilihat (Potion/Weapon/Armor) : ");
        controller.showSortedByUnit(kat);
    }
}