package pbodatabase.lelang;

public class MainApp {
    public static void main(String[] args) {
        //pisah daftar berdasarkan kategori
        AuctionList<Potion> potionList = new AuctionList<>();
        AuctionList<Weapon> weaponList = new AuctionList<>();
        AuctionList<Armor> armorList = new AuctionList<>();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== APLIKASI LELANG GAME =====");
            System.out.println("1.Tambah Barang Lelang");
            System.out.println("2.Tampilkan berdasarkan harga total termurah");
            System.out.println("3.Tampilkan berdasarkan harga satuan termurah");
            System.out.println("4.Keluar");

            //exception handling
            try {
                int menu = CLIUtil.getInt("Pilih menu : ");

                switch (menu) {
                    case 1:
                        String kategori = CLIUtil.getString("Masukkan kategori (Potion/Weapon/Armor) : ");
                        String nama = CLIUtil.getString("Nama barang : ");
                        double totalHarga = CLIUtil.getDouble("Total Harga keseluruhan : ");

                        if (kategori.equalsIgnoreCase("Potion")) {
                            int totalUnit = CLIUtil.getInt("Jumlah Unit Potion : ");
                            int hp = CLIUtil.getInt("HP Restore Value : ");
                            int mana = CLIUtil.getInt("Mana Restore Value : ");
                            potionList.tambahBarang(new Potion(nama, totalUnit, totalHarga, hp, mana));
                            System.out.println("Potion berhasil dilelang, Selamat!");

                        } else if (kategori.equalsIgnoreCase("Weapon")) {
                            String type = CLIUtil.getString("Tipe Weapon (Sword/Axe/Spear/Bow) : ");
                            int attack = CLIUtil.getInt("Attack Value : ");
                            //Weapon selalu 1
                            weaponList.tambahBarang(new Weapon(nama, totalHarga, attack, type));
                            System.out.println("Weapon berhasil dilelang, selamat!");

                        } else if (kategori.equalsIgnoreCase("Armor")) {
                            String type = CLIUtil.getString("Tipe Armor (Heavy/Medium/Light) : ");
                            int defense = CLIUtil.getInt("Defense Value : ");
                            //Armor selalu 1 jg
                            armorList.tambahBarang(new Armor(nama, totalHarga, defense, type));
                            System.out.println("Armor berhasil dilelang, selamat!");

                        } else {
                            System.out.println("Kategori tidak valid...");
                        }
                        break;

                    case 2:
                        String kat2 = CLIUtil.getString("Pilih Kategori untuk dilihat (Potion/Weapon/Armor) : ");
                        if (kat2.equalsIgnoreCase("Potion"))
                            AuctionList.printSortedByTotal(potionList.getList());
                        else if (kat2.equalsIgnoreCase("Weapon"))
                            AuctionList.printSortedByTotal(weaponList.getList());
                        else if (kat2.equalsIgnoreCase("Armor"))
                            AuctionList.printSortedByTotal(armorList.getList());
                        else
                            System.out.println("Kategori tidak ditemukan, coba lagi.");
                        break;

                    case 3:
                        String kat3 = CLIUtil.getString("Pilih Kategori untuk dilihat (Potion/Weapon/Armor) : ");
                        if (kat3.equalsIgnoreCase("Potion"))
                            AuctionList.printSortedByUnit(potionList.getList());
                        else if (kat3.equalsIgnoreCase("Weapon"))
                            AuctionList.printSortedByUnit(weaponList.getList());
                        else if (kat3.equalsIgnoreCase("Armor"))
                            AuctionList.printSortedByUnit(armorList.getList());
                        else
                            System.out.println("Kategori tidak ditemukan, coba lagi.");
                        break;

                    case 4:
                        isRunning = false;
                        System.out.println("Exited, terima kasih.");
                        break;

                    default:
                        System.out.println("Menu tidak ada... tolong dicoba lagi.");
                }
            } catch (EmptyInputException | InvalidNumberException | EmptyListException e) {
                System.out.println(">> ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(">> TERJADI KESALAHAN: " + e.getMessage());
            }
        }
    }
}