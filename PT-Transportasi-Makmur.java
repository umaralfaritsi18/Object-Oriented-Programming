// Kelas Dasar
class Mobil {
    private String merk;
    private String model;
    private int tahun;
    private double harga;
    private boolean statusTerjual;

    public Mobil(String merk, String model, int tahun, double harga) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.harga = harga;
        this.statusTerjual = false; // Default belum terjual
    }

    // Menampilkan detail umum mobil
    public void tampilkanDetail() {
        System.out.println("Merk: " + merk);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
        System.out.println("Harga: Rp " + harga);
        System.out.println("Status: " + (statusTerjual ? "Terjual" : "Tersedia"));
    }

    // Tandai mobil terjual
    public void tandaiTerjual() {
        this.statusTerjual = true;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double hargaBaru) {
        this.harga = hargaBaru;
    }
}

// Kelas Turunan: Mobil Mewah
class MobilMewah extends Mobil {
    private double diskon;

    public MobilMewah(String merk, String model, int tahun, double harga) {
        super(merk, model, tahun, harga);
        this.diskon = 0.1; // Diskon 10%
    }

    // Menghitung harga setelah diskon
    public double hitungHargaDiskon() {
        return getHarga() * (1 - diskon);
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Harga Setelah Diskon: Rp " + hitungHargaDiskon());
    }
}

// Kelas Turunan: Mobil Operasional
class MobilOperasional extends Mobil {
    public MobilOperasional(String merk, String model, int tahun, double harga) {
        super(merk, model, tahun, harga);
    }

    // Informasi tambahan untuk mobil operasional
    public void kalkulasiEfisiensi() {
        System.out.println("Efisiensi bahan bakar optimal untuk operasional sehari-hari.");
    }
}

// Kelas Turunan: Mobil Koleksi
class MobilKoleksi extends Mobil {
    private String nilaiHistoris;

    public MobilKoleksi(String merk, String model, int tahun, double harga, String nilaiHistoris) {
        super(merk, model, tahun, harga);
        this.nilaiHistoris = nilaiHistoris;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Nilai Historis: " + nilaiHistoris);
    }
}

// Kelas Utama
public class PTTransportasiMakmur {
    public static void main(String[] args) {
        // Mobil Mewah
        MobilMewah bmw = new MobilMewah("BMW", "7 Series", 2020, 1500000000);
        System.out.println("=== Mobil Mewah ===");
        bmw.tampilkanDetail();

        // Mobil Operasional
        MobilOperasional avanza = new MobilOperasional("Toyota", "Avanza", 2018, 200000000);
        System.out.println("\n=== Mobil Operasional ===");
        avanza.tampilkanDetail();
        avanza.kalkulasiEfisiensi();

        // Mobil Koleksi
        MobilKoleksi ford = new MobilKoleksi("Ford", "Model T", 1920, 500000000, "Mobil klasik pertama produksi massal");
        System.out.println("\n=== Mobil Koleksi ===");
        ford.tampilkanDetail();
    }
}