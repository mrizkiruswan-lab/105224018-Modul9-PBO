public class Ban {

    private String merk;
    private int ukuranRing;

    // Constructor
    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    // Getter
    public String getMerk() {
        return merk;
    }

    public int getUkuranRing() {
        return ukuranRing;
    }

    // Menampilkan info ban
    public void infoBan() {
        System.out.println(
            "Ban : " + merk +
            " | Ring : " + ukuranRing
        );
    }
}