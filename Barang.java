import java.util.Scanner;

public class Barang {
    private String nama;
    private int jumlahStok;
    private double harga;

    // Constructor
    public Barang(String nama, int jumlahStok, double harga) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }

    // Getters
    public String getNama() {
        return nama;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public double getHarga() {
        return harga;
    }

    // Setter for jumlahStok
    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    // Method to update stock
    public static void updateStok(Barang[] inventaris, String nama, int jumlahBaru) {
        boolean found = false;
        for (Barang barang : inventaris) {
            if (barang != null && barang.getNama().equalsIgnoreCase(nama)) {
                barang.setJumlahStok(jumlahBaru);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Barang tidak ditemukan!");
        }
    }

    // Method to search item
    public static void cariBarang(Barang[] inventaris, String nama) {
        boolean found = false;
        for (Barang barang : inventaris) {
            if (barang != null && barang.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Hasil pencarian:");
                System.out.println("Nama: " + barang.getNama() + 
                                 ", Jumlah Stok: " + barang.getJumlahStok() + 
                                 ", Harga: " + barang.getHarga());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Barang tidak ditemukan!");
        }
    }

    // Method to display inventory
    public static void tampilkanInventaris(Barang[] inventaris) {
        System.out.println("\nInventaris Toko:");
        for (int i = 0; i < inventaris.length; i++) {
            if (inventaris[i] != null) {
                System.out.println((i + 1) + ". Nama: " + inventaris[i].getNama() + 
                                 ", Jumlah Stok: " + inventaris[i].getJumlahStok() + 
                                 ", Harga: " + inventaris[i].getHarga());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create inventory array with capacity 10
        Barang[] inventaris = new Barang[10];

        // Add 3 items to array
        inventaris[0] = new Barang("Pensil", 50, 2000);
        inventaris[1] = new Barang("Buku", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 500);

        // Display initial inventory
        tampilkanInventaris(inventaris);

        // Update stock
        System.out.print("\nMasukkan nama barang yang ingin diupdate: ");
        String namaUpdate = scanner.nextLine();
        System.out.print("Masukkan jumlah stok baru: ");
        int stokBaru = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        updateStok(inventaris, namaUpdate, stokBaru);
        tampilkanInventaris(inventaris);

        // Search for item
        System.out.print("\nMasukkan nama barang yang dicari: ");
        String namaCari = scanner.nextLine();
        cariBarang(inventaris, namaCari);

        scanner.close();
    }
}