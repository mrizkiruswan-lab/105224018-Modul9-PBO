public class Main {

    public static void main(String[] args) {

        Dokter d1 = new Dokter(
            "Dr. Ruswan",
            "Penyakit Dalam"
        );

        Dokter d2 = new Dokter(
            "Dr. Naufal",
            "Dokter Anak"
        );

        Pasien p1 = new Pasien(
            "Budi",
            20
        );

        Pasien p2 = new Pasien(
            "Sabet",
            19
        );

        d1.periksaPasien(p1);

        System.out.println();

        RumahSakit rs = new RumahSakit(
            "RS Sehat Selalu"
        );
        
        rs.tambahDokter(d1, 0);
        rs.tambahDokter(d2, 1);

        rs.tampilkanRuangan();

        rs.tampilkanDokter();

        rs = null;

        System.out.println();
        System.out.println("Rumah sakit dihapus");

        System.out.println(
            d1.getNama() + " masih ada di sistem"
        );
    }
}