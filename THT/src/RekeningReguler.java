//class RekeningReguler
//inheritance dari class Rekening
public class RekeningReguler extends Rekening {

    //biaya admin setiap tarik uang
    private final double BIAYA_ADMIN = 2500;

    //constructor
    public RekeningReguler(String nomorRekening, String namaPemilik,
                            double saldoAwal, int pin) {

        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    //override method tarik
    @Override
    public void tarik(double jumlah) {

        //total yang dipotong = uang tarik + admin
        double total = jumlah + BIAYA_ADMIN;

        //validasi saldo cukup atau tidak
        if (getSaldo() >= total) {

            //mengurangi saldo
            kurangiSaldo(total);

            //catat mutasi
            bukuMutasi.catatTransaksi(
                    "Tarik tunai reguler Rp" + jumlah +
                    " + admin Rp" + BIAYA_ADMIN +
                    " | Saldo sekarang: Rp" + getSaldo()
            );

        } else {
            System.out.println("Saldo tidak mencukupi!");
        }
    }
}