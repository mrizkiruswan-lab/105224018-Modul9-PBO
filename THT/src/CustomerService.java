//class CustomerService
//digunakan untuk asosiasi dengan Nasabah
public class CustomerService {

    private String namaCS;

    //constructor
    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }

    //method menerima keluhan
    public void terimaKeluhan(Nasabah nasabah, String keluhan) {

        System.out.println("\n===== CUSTOMER SERVICE =====");
        System.out.println("CS " + namaCS + " menerima keluhan dari "
                + nasabah.getNama());

        System.out.println("Isi Keluhan : " + keluhan);
    }
}