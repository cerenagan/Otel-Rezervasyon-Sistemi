package otel.rezervasyon.sistemi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dosyaİslemleri {

    public void rezervasyonKaydet(Rezervasyon rezervasyon) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("rezervasyonlar.txt", true)
            );

            bw.write("Rezervasyon No: "
                    + rezervasyon.getRezervasyonNo());
            bw.newLine();

            bw.write("Misafir: "
                    + rezervasyon.getMisafir().getAd() + " "
                    + rezervasyon.getMisafir().getSoyad());
            bw.newLine();

            bw.write("Telefon: "
                    + rezervasyon.getMisafir().getTelefon());
            bw.newLine();

            bw.write("Oda Türü: ");

            if (rezervasyon.getOda() instanceof StandartOda) {
                bw.write("Standart Oda");
            } else {
                bw.write("Suit Oda");
            }

            bw.newLine();

            bw.write("Günlük Fiyat: "
                    + rezervasyon.getOda().getFiyat()
                    + " TL");
            bw.newLine();

            bw.write("Gün Sayısı: "
                    + rezervasyon.getGunSayisi());
            bw.newLine();

            bw.write("Toplam Ücret: "
                    + rezervasyon.toplamUcret()
                    + " TL");
            bw.newLine();

            bw.write("--------------------------");
            bw.newLine();

            bw.close();

            System.out.println("Kayıt dosyaya yazıldı.");

        } catch (IOException e) {

            System.out.println("Dosyaya yazılırken hata oluştu.");
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RezervasyonYoneticisi yonetici =
                new RezervasyonYoneticisi();

        Dosyaİslemleri dosya =
                new Dosyaİslemleri();

        int secim = 0;
        int rezervasyonNo = 1;


        while (secim != 5) {

            System.out.println();
            System.out.println("===== OTEL REZERVASYON SİSTEMİ =====");
            System.out.println("1- Yeni Misafir ve Rezervasyon Ekle");
            System.out.println("2- Kayıtları Listele");
            System.out.println("3- Kayıt Ara");
            System.out.println("4- Kayıt Sil");
            System.out.println("5- Çıkış");

            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();


            // 1 - Yeni Misafir ve Rezervasyon Ekle
            if (secim == 1) {

                System.out.print("Misafir No: ");
                int misafirNo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ad: ");
                String ad = scanner.nextLine();

                System.out.print("Soyad: ");
                String soyad = scanner.nextLine();

                System.out.print("Telefon: ");
                String telefon = scanner.nextLine();


                if (yonetici.misafirAra(misafirNo) != null) {

                    System.out.println(
                            "Bu misafir numarası zaten kayıtlı!"
                    );

                } else {

                    Misafir misafir = new Misafir(
                            misafirNo,
                            ad,
                            soyad,
                            telefon
                    );


                    System.out.println();
                    System.out.println("Oda Türü");
                    System.out.println("1- Standart Oda");
                    System.out.println("2- Suit Oda");

                    System.out.print("Seçiminiz: ");
                    int odaTipi = scanner.nextInt();


                    KonaklamaBirimi oda = null;


                    if (odaTipi == 1) {

                        oda = new StandartOda();

                    } else if (odaTipi == 2) {

                        oda = new SuitOda();

                    } else {

                        System.out.println(
                                "Geçersiz oda türü!"
                        );
                    }


                    if (oda != null) {

                        System.out.print(
                                "Kaç gün kalacaksınız: "
                        );

                        int gun = scanner.nextInt();


                        if (gun > 0) {

                            Rezervasyon rezervasyon =
                                    new Rezervasyon(
                                            rezervasyonNo,
                                            misafir,
                                            oda,
                                            gun
                                    );


                            yonetici.misafirEkle(misafir);
                            yonetici.rezervasyonEkle(
                                    rezervasyon
                            );

                            dosya.rezervasyonKaydet(
                                    rezervasyon
                            );


                            System.out.println();
                            System.out.println(
                                    "Rezervasyon başarıyla oluşturuldu!"
                            );

                            // Kullanıcıya rezervasyon numarasını gösteriyoruz
                            System.out.println(
                                    "Rezervasyon Numaranız: "
                                    + rezervasyonNo
                            );

                            System.out.println(
                                    "Oda Türü: "
                                    + (odaTipi == 1
                                    ? "Standart Oda"
                                    : "Suit Oda")
                            );

                            System.out.println(
                                    "Günlük Fiyat: "
                                    + oda.getFiyat()
                                    + " TL"
                            );

                            System.out.println(
                                    "Toplam Ücret: "
                                    + rezervasyon.toplamUcret()
                                    + " TL"
                            );


                            rezervasyonNo++;


                        } else {

                            System.out.println(
                                    "Gün sayısı 0'dan büyük olmalıdır!"
                            );
                        }
                    }
                }
            }


            // 2 - Kayıtları Listele
            else if (secim == 2) {

                yonetici.kayitlariListele();
            }


            // 3 - Kayıt Ara
            else if (secim == 3) {

                System.out.print(
                        "Rezervasyon No: "
                );

                int no = scanner.nextInt();


                Rezervasyon rezervasyon =
                        yonetici.rezervasyonAra(no);


                if (rezervasyon != null) {

                    rezervasyon.bilgileriGoster();

                } else {

                    System.out.println(
                            "Rezervasyon bulunamadı."
                    );
                }
            }


            // 4 - Kayıt Sil
            else if (secim == 4) {

                System.out.print(
                        "Silinecek rezervasyon no: "
                );

                int no = scanner.nextInt();


                yonetici.rezervasyonSil(no);
            }


            // 5 - Çıkış
            else if (secim == 5) {

                System.out.println(
                        "Program sonlandırıldı."
                );

            } else {

                System.out.println(
                        "Geçersiz seçim yaptınız!"
                );
            }
        }


        
    }
}
