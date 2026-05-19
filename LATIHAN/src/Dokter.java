public class Dokter {
    private String nama;
    private String spesialisasi;

    public Dokter(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }

    public String getNama() {
        return nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void periksaPasien(Pasien pasien) {
        System.out.println("=== Pemeriksaan Pasien ===");
        System.out.println("Dokter : " + nama);
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("Pasien : " + pasien.getNama());
        System.out.println("Umur Pasien : " + pasien.getUmur());
    }
}