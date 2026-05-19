public class Mobil {

    private String merkMobil;
    private String warna;

    // Composition
    private Mesin mesin;

    // Aggregation
    private Ban[] daftarBan;

    // Constructor
    public Mobil(
        String merkMobil,
        String warna,
        String nomorSeri,
        int kapasitasCC
    ) {

        this.merkMobil = merkMobil;
        this.warna = warna;

        // Mesin dibuat langsung di dalam mobil
        mesin = new Mesin(
            nomorSeri,
            kapasitasCC
        );

        // Maksimal 4 ban
        daftarBan = new Ban[4];
    }

    // Memasang ban
    public void pasangSetBan(Ban[] setBan) {

        for (int i = 0; i < setBan.length; i++) {

            if (i < 4) {
                daftarBan[i] = setBan[i];
            }
        }
    }

    // Menampilkan spesifikasi
    public void tampilkanSpesifikasi() {

        System.out.println("=== DATA MOBIL ===");

        System.out.println(
            "Merk : " + merkMobil
        );

        System.out.println(
            "Warna : " + warna
        );

        System.out.println();

        System.out.println("=== DATA MESIN ===");

        mesin.infoMesin();

        System.out.println();

        System.out.println("=== DATA BAN ===");

        for (Ban b : daftarBan) {

            if (b != null) {
                b.infoBan();
            }
        }
    }
}