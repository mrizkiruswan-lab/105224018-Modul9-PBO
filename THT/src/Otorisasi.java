//interface Otorisasi
//digunakan sebagai kontrak agar semua rekening wajib punya metode verifikasi PIN
public interface Otorisasi {
    boolean verifikasiPIN(int pin);
}