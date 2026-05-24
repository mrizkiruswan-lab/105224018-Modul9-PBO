//abstract class Rekening
//mengimplementasikan interface Otorisasi
public abstract class Rekening implements Otorisasi {

    //atribut dibuat protected/private untuk menerapkan enkapsulasi
    protected String nomorRekening;
    protected String namaPemilik;
    private double saldo;
    protected int pin;

    //composition
    //setiap rekening otomatis memiliki BukuMutasi
    protected BukuMutasi bukuMutasi;

    //constructor
    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, int pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;

        //object BukuMutasi otomatis dibuat di dalam constructor
        this.bukuMutasi = new BukuMutasi();

        System.out.println("Rekening berhasil dibuat untuk " + namaPemilik);
    }

    //getter saldo
    public double getSaldo() {
        return saldo;
    }

    //method setor
    public void setor(double jumlah) {
        saldo += jumlah;

        //mencatat transaksi ke mutasi
        bukuMutasi.catatTransaksi(
                "Setor uang sebesar Rp" + jumlah +
                " | Saldo sekarang: Rp" + saldo
        );
    }

    //method protected agar hanya class turunan yang bisa mengubah saldo
    protected void kurangiSaldo(double jumlah) {
        saldo -= jumlah;
    }

    //method verifikasi PIN dari interface
    @Override
    public boolean verifikasiPIN(int pin) {
        return this.pin == pin;
    }

    //abstract method tarik
    //akan dioverride oleh class turunan
    public abstract void tarik(double jumlah);

    //menampilkan info rekening
    public void tampilInfo() {
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Saldo          : Rp" + getSaldo());
    }
}