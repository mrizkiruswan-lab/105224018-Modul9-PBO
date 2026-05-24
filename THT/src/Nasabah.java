//class Nasabah
//menggunakan agregasi dengan array rekening
public class Nasabah {

    private String nama;
    private String nik;

    //array untuk menampung maksimal 3 rekening
    private Rekening[] daftarRekening = new Rekening[3];

    //constructor
    public Nasabah(String nama, String nik) {
        this.nama = nama;
        this.nik = nik;
    }

    //method tambah rekening
    public void tambahRekening(Rekening rekening) {

        for (int i = 0; i < daftarRekening.length; i++) {

            //jika slot kosong
            if (daftarRekening[i] == null) {
                daftarRekening[i] = rekening;

                System.out.println("Rekening berhasil ditambahkan ke profil nasabah");
                return;
            }
        }

        System.out.println("Maksimal rekening sudah penuh!");
    }

    //menampilkan daftar rekening
    public void tampilkanRekening() {

        System.out.println("\n===== DAFTAR REKENING =====");

        for (int i = 0; i < daftarRekening.length; i++) {

            if (daftarRekening[i] != null) {
                System.out.println("Index Rekening : " + i);
                daftarRekening[i].tampilInfo();
                System.out.println();
            }
        }
    }

    //getter rekening berdasarkan index
    public Rekening getRekening(int index) {

        if (index >= 0 && index < daftarRekening.length) {
            return daftarRekening[index];
        }

        return null;
    }

    //getter nama
    public String getNama() {
        return nama;
    }
}