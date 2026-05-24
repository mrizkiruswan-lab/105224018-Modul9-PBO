//class RekeningPrioritas
//inheritance dari Rekening
public class RekeningPrioritas extends Rekening {

    //saldo minimum yang wajib tersisa
    private final double MINIMUM_SALDO = 1000000;

    //constructor
    public RekeningPrioritas(String nomorRekening, String namaPemilik,
                              double saldoAwal, int pin) {

        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    //override method tarik
    @Override
    public void tarik(double jumlah) {

        //validasi saldo minimum
        if ((getSaldo() - jumlah) >= MINIMUM_SALDO) {

            //mengurangi saldo
            kurangiSaldo(jumlah);

            //catat mutasi
            bukuMutasi.catatTransaksi(
                    "Tarik tunai prioritas Rp" + jumlah +
                    " | Saldo sekarang: Rp" + getSaldo()
            );

        } else {
            System.out.println("Penarikan gagal!");
            System.out.println("Rekening prioritas wajib menyisakan saldo minimum Rp"
                    + MINIMUM_SALDO);
        }
    }
}