public class Montir {

    private String idMontir;
    private String nama;

    //constructor
    public Montir(
        String idMontir,
        String nama
    ) {

        this.idMontir = idMontir;
        this.nama = nama;
    }

    //quality Control
    public void lakukanQualityControl(
        Mobil m
    ) {

        System.out.println();
        System.out.println(
            "Montir " + nama +
            " sedang memeriksa mobil."
        );

        m.tampilkanSpesifikasi();
    }
}