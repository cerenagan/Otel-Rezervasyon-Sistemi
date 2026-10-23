
package otel.rezervasyon.sistemi;

public class KonaklamaBirimi {

    private double fiyat;

    public KonaklamaBirimi(double fiyat) {
        this.fiyat = fiyat;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        if (fiyat > 0) {
            this.fiyat = fiyat;
        } else {
            System.out.println("Fiyat 0'dan büyük olmalıdır!");
        }
    }

    public double ucretHesapla(int gun) {
        return fiyat * gun;
    }

    public void bilgileriGoster() {
        System.out.println("Günlük Fiyat: " + fiyat + " TL");
    }
}
