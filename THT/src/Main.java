import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Nasabah nasabah = null;

        CustomerService cs = new CustomerService("Amanda");

        int pilihan;

        do {

            System.out.println("\n===== SISTEM NEOBANK =====");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Buka Rekening");
            System.out.println("3. Lihat Rekening");
            System.out.println("4. Setor Uang");
            System.out.println("5. Tarik Uang");
            System.out.println("6. Hubungi Customer Service");
            System.out.println("7. Tutup Profil Nasabah");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                // Registrasi Nasabah
                case 1:

                    System.out.print("Masukkan nama nasabah : ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan NIK : ");
                    String nik = input.nextLine();

                    nasabah = new Nasabah(nama, nik);

                    System.out.println("Nasabah berhasil diregistrasi!");
                    break;

                // Membuka rekening
                case 2:

                    if (nasabah == null) {
                        System.out.println("Registrasi nasabah terlebih dahulu!");
                        break;
                    }

                    System.out.println("\nJenis Rekening");
                    System.out.println("1. Rekening Reguler");
                    System.out.println("2. Rekening Prioritas");
                    System.out.print("Pilih jenis rekening : ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Nomor Rekening : ");
                    String norek = input.nextLine();

                    System.out.print("Saldo Awal : ");
                    double saldoAwal = input.nextDouble();

                    System.out.print("PIN Rekening : ");
                    int pin = input.nextInt();

                    Rekening rekening;

                    // Polimorfisme
                    // Parent class bisa menyimpan object child class
                    if (jenis == 1) {

                        rekening = new RekeningReguler(
                                norek,
                                nasabah.getNama(),
                                saldoAwal,
                                pin
                        );

                    } else {

                        rekening = new RekeningPrioritas(
                                norek,
                                nasabah.getNama(),
                                saldoAwal,
                                pin
                        );
                    }

                    // Aggregation
                    // Rekening dimasukkan ke data nasabah
                    nasabah.tambahRekening(rekening);

                    break;

                // Menampilkan rekening
                case 3:

                    if (nasabah == null) {

                        System.out.println("Belum ada nasabah!");

                    } else {

                        nasabah.tampilkanRekening();
                    }

                    break;

                // Setor uang
                case 4:

                    if (nasabah == null) {

                        System.out.println("Belum ada nasabah!");
                        break;
                    }

                    nasabah.tampilkanRekening();

                    System.out.print("Pilih index rekening : ");
                    int indexSetor = input.nextInt();

                    Rekening rekeningSetor = nasabah.getRekening(indexSetor);

                    if (rekeningSetor != null) {

                        System.out.print("Masukkan PIN : ");
                        int pinSetor = input.nextInt();

                        // Interface Otorisasi
                        if (rekeningSetor.verifikasiPIN(pinSetor)) {

                            System.out.print("Jumlah setor : ");
                            double jumlahSetor = input.nextDouble();

                            // Method setor dari class Rekening
                            rekeningSetor.setor(jumlahSetor);

                        } else {

                            System.out.println("PIN salah!");
                        }

                    } else {

                        System.out.println("Rekening tidak ditemukan!");
                    }

                    break;

                // Tarik uang
                case 5:

                    if (nasabah == null) {

                        System.out.println("Belum ada nasabah!");
                        break;
                    }

                    nasabah.tampilkanRekening();

                    System.out.print("Pilih index rekening : ");
                    int indexTarik = input.nextInt();

                    Rekening rekeningTarik = nasabah.getRekening(indexTarik);

                    if (rekeningTarik != null) {

                        System.out.print("Masukkan PIN : ");
                        int pinTarik = input.nextInt();

                        if (rekeningTarik.verifikasiPIN(pinTarik)) {

                            System.out.print("Jumlah tarik : ");
                            double jumlahTarik = input.nextDouble();

                            // Overriding method tarik()
                            // Setiap jenis rekening punya aturan berbeda
                            rekeningTarik.tarik(jumlahTarik);

                        } else {

                            System.out.println("PIN salah!");
                        }

                    } else {

                        System.out.println("Rekening tidak ditemukan!");
                    }

                    break;

                // Customer service
                case 6:

                    if (nasabah == null) {

                        System.out.println("Belum ada nasabah!");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Masukkan keluhan : ");
                    String keluhan = input.nextLine();

                    // Association
                    // Nasabah hanya berinteraksi dengan CS
                    cs.terimaKeluhan(nasabah, keluhan);

                    break;

                // Tutup profil nasabah
                case 7:

                    System.out.println("Profil nasabah dihapus dari sistem...");

                    // Object nasabah dibuat null
                    nasabah = null;

                    System.out.println("Profil nasabah sekarang bernilai null");

                    /*
                     ANALISIS OOP

                     1. AGREGASI
                     Object rekening tidak ikut hancur ketika object
                     Nasabah dihapus karena rekening merupakan object
                     mandiri dan hanya direferensikan oleh Nasabah.

                     2. KOMPOSISI
                     BukuMutasi dibuat langsung di constructor Rekening.
                     Jika object rekening dihancurkan maka BukuMutasi
                     juga ikut hilang karena hidupnya bergantung penuh
                     pada object Rekening.

                     3. ASOSIASI
                     Nasabah dan CustomerService hanya saling berinteraksi
                     melalui method tanpa saling memiliki object.
                    */

                    break;

                // Keluar program
                case 0:

                    System.out.println("Program selesai...");
                    break;

                default:

                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }
}