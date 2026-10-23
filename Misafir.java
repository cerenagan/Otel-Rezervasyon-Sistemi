package otel.rezervasyon.sistemi;

public class Misafir {

    private int misafirNo;
    private String ad;
    private String soyad;
    private String telefon;

    public Misafir(int misafirNo, String ad, String soyad, String telefon) {
        this.misafirNo = misafirNo;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
    }

    public Misafir(int misafirNo, String ad, String soyad) {
        this.misafirNo = misafirNo;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = "";
    }

    public int getMisafirNo() {
        return misafirNo;
    }

    public void setMisafirNo(int misafirNo) {
        if (misafirNo > 0) {
            this.misafirNo = misafirNo;
        } else {
            System.out.println("Geçersiz misafir numarası!");
        }
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        if (!ad.isEmpty()) {
            this.ad = ad;
        } else {
            System.out.println("Ad boş bırakılamaz!");
        }
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        if (!soyad.isEmpty()) {
            this.soyad = soyad;
        } else {
            System.out.println("Soyad boş bırakılamaz!");
        }
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        if (!telefon.isEmpty() &&telefon.length() == 11) {
            this.telefon = telefon;
        } else {
            System.out.println("Telefon 11 haneli olmalıdır!");
        }
    }

    public void bilgileriGoster() {
        System.out.println("Misafir No: " + misafirNo);
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("Telefon: " + telefon);
    }
}
