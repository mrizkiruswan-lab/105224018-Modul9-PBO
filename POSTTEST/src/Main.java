public class Main {

    public static void main(String[] args) {
        //membuat 4 Ban Mandiri
        Ban b1 = new Ban("Michelin", 17);
        Ban b2 = new Ban("Michelin", 17);
        Ban b3 = new Ban("Michelin", 17);
        Ban b4 = new Ban("Michelin", 17);

        //array ban
        Ban[] setBan = {
            b1, b2, b3, b4
        };

        //membuat Mobil
        Mobil mobil1 = new Mobil(
            "Toyota",
            "Hitam",
            "MSN001",
            1500
        );

        //pasang ban
        mobil1.pasangSetBan(setBan);

        //membuat Montir
        Montir montir1 = new Montir(
            "M001",
            "Ilham Hitam"
        );

        //inspeksi Mobil
        montir1.lakukanQualityControl(
            mobil1
        );
        //simulasi mobil gagal uji
        mobil1 = null;

        System.out.println();
        System.out.println(
            "Mobil gagal uji dan dihancurkan"
        );

        //ban masih ada
        System.out.println();
        System.out.println(
            "Ban masih tersimpan di gudang:"
        );

        b1.infoBan();
        
        // Mesin ikut hilang
        System.out.println();
        System.out.println(
            "Objek mesin ikut hilang karena composition"
        );
    }
}