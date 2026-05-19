public class Mesin {

    private String nomorSeri;
    private int kapasitasCC;

    // Constructor
    public Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    // Menampilkan info mesin
    public void infoMesin() {
        System.out.println(
            "Nomor Seri Mesin : " + nomorSeri
        );

        System.out.println(
            "Kapasitas : " + kapasitasCC + " CC"
        );
    }
}