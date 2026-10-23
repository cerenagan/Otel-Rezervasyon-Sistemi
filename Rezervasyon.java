package otel.rezervasyon.sistemi;

public class Rezervasyon {

    private int rezervasyonNo;
    private Misafir misafir;
    private KonaklamaBirimi oda;
    private int gunSayisi;

    public Rezervasyon(int rezervasyonNo, Misafir misafir,
                       KonaklamaBirimi oda, int gunSayisi) {
        this.rezervasyonNo = rezervasyonNo;
        this.misafir = misafir;
        this.oda = oda;
        this.gunSayisi = gunSayisi;
    }

    public int getRezervasyonNo() {
        return rezervasyonNo;
    }

    public void setRezervasyonNo(int rezervasyonNo) {
        if (rezervasyonNo > 0) {
            this.rezervasyonNo = rezervasyonNo;
        } else {
            System.out.println("Geçersiz rezervasyon numarası!");
        }
    }

    public Misafir getMisafir() {
        return misafir;
    }

    public KonaklamaBirimi getOda() {
        return oda; 
    }

    public int getGunSayisi() {
        return gunSayisi;
    }

    public void setGunSayisi(int gunSayisi) {
        if (gunSayisi > 0) {
            this.gunSayisi = gunSayisi;
        } else {
            System.out.println("Gün sayısı 0'dan büyük olmalıdır!");
        }
    }

    public double toplamUcret() {
        return oda.ucretHesapla(gunSayisi);
    }

    public void bilgileriGoster() {

        System.out.println("--------------------------");
        System.out.println("Rezervasyon No: " + rezervasyonNo);

        misafir.bilgileriGoster();

        oda.bilgileriGoster();

        System.out.println("Kalınacak Gün: " + gunSayisi);
        System.out.println("Toplam Ücret: " + toplamUcret() + " TL");
        System.out.println("--------------------------");
    }
}
 
