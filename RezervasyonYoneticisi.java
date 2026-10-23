package otel.rezervasyon.sistemi;

import java.util.ArrayList;

public class RezervasyonYoneticisi {

    private ArrayList<Misafir> misafirListesi = new ArrayList<>();
    private ArrayList<Rezervasyon> rezervasyonListesi = new ArrayList<>();

    public void misafirEkle(Misafir misafir) {

        if (misafirAra(misafir.getMisafirNo()) == null) {
            misafirListesi.add(misafir);
            System.out.println("Misafir başarıyla eklendi.");
        } else {
            System.out.println("Bu misafir numarası zaten kullanılıyor!");
        }
    }

    public void rezervasyonEkle(Rezervasyon rezervasyon) {
        rezervasyonListesi.add(rezervasyon);
    }

    public Misafir misafirAra(int misafirNo) {

        for (Misafir misafir : misafirListesi) {

            if (misafir.getMisafirNo() == misafirNo) {
                return misafir;
            }
        }

        return null;
    }

    public Rezervasyon rezervasyonAra(int rezervasyonNo) {

        for (Rezervasyon rezervasyon : rezervasyonListesi) {

            if (rezervasyon.getRezervasyonNo() == rezervasyonNo) {
                return rezervasyon;
            }
        }

        return null;
    }

    public void kayitlariListele() {

        if (rezervasyonListesi.isEmpty()) {
            System.out.println("Kayıtlı rezervasyon bulunmamaktadır.");
            return;
        }

        for (Rezervasyon rezervasyon : rezervasyonListesi) {
            rezervasyon.bilgileriGoster();
        }
    }

    public void rezervasyonSil(int rezervasyonNo) {

        Rezervasyon rezervasyon = rezervasyonAra(rezervasyonNo);

        if (rezervasyon != null) {
            rezervasyonListesi.remove(rezervasyon);
            System.out.println("Rezervasyon silindi.");
        } else {
            System.out.println("Rezervasyon bulunamadı.");
        }
    }

    public ArrayList<Rezervasyon> getRezervasyonListesi() {
        return rezervasyonListesi;
    }
}