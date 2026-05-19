public class Ruangan {
    private String nomorRuangan;
    private int kapasitas;

    public Ruangan(String nomorRuangan, int kapasitas) {
        this.nomorRuangan = nomorRuangan;
        this.kapasitas = kapasitas;
    }

    public void infoRuangan() {
        System.out.println("Nomor Ruangan : " + nomorRuangan);
        System.out.println("Kapasitas : " + kapasitas + " pasien");
    }
}