public class RumahSakit {

    private String namaRS;
    //composition
    private Ruangan[] daftarRuangan;
    //aggregation
    private Dokter[] daftarDokter;

    public RumahSakit(String namaRS) {
        this.namaRS = namaRS;

        daftarRuangan = new Ruangan[2];

        daftarRuangan[0] = new Ruangan("R-01", 10);
        daftarRuangan[1] = new Ruangan("R-02", 15);

        daftarDokter = new Dokter[2];
    }

    public void tambahDokter(Dokter dokter, int index) {
        daftarDokter[index] = dokter;
    }

    public void tampilkanRuangan() {

        System.out.println("=== Daftar Ruangan ===");

        for (Ruangan r : daftarRuangan) {
            r.infoRuangan();
            System.out.println();
        }
    }

    public void tampilkanDokter() {

        System.out.println("=== Daftar Dokter Bertugas ===");

        for (Dokter d : daftarDokter) {

            if (d != null) {
                System.out.println(
                    d.getNama() + " - " + d.getSpesialisasi()
                );
            }
        }
    }
}