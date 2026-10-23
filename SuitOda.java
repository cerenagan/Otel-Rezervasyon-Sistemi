package otel.rezervasyon.sistemi;

public class SuitOda extends KonaklamaBirimi {

    public SuitOda() {
        super(1500);
    }

    @Override
    public double ucretHesapla(int gun) {
        return getFiyat() * gun;
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("Oda Türü: Suit Oda");
        System.out.println("Günlük Fiyat: " + getFiyat() + " TL");
    }
}
