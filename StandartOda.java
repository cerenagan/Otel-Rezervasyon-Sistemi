package otel.rezervasyon.sistemi;

public class StandartOda extends KonaklamaBirimi {

    public StandartOda() {
        super(1000);
    }

    @Override
    public double ucretHesapla(int gun) {
        return getFiyat() * gun;
    }

    @Override
    public void bilgileriGoster() {
        System.out.println("Oda Türü: Standart Oda");
        System.out.println("Günlük Fiyat: " + getFiyat() + " TL");
    }
}
