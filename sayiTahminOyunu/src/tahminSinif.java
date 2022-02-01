
import java.util.Random;
import java.util.Scanner;

/**
 * 0-20 ARASINDA RANDOM BELIRLENEN SAYIYI 5 HAK KULLANARAK BULMAYA CALISMA
 * OYUNU.
 */
public class tahminSinif implements ITahmin {

    Random r = new Random();
    int tahminEdilecekSayi = r.nextInt(20);
    int tahminHakki = 5;
    int tahminEdilen;
    boolean sonuc;

    int[] butunTahminler = new int[5];

    Scanner tahmin = new Scanner(System.in);

    @Override
    public boolean tahminEt() {
        System.out.println(tahminHakki + " tahmin hakkiniz var.");

        System.out.println("\n0-20 arasinda bir sayi giriniz:\n ");

        for (int i = 0; i < 5;) {
            System.out.print("Tahmininiz: ");
            tahminEdilen = tahmin.nextInt();
            butunTahminler[i++] = tahminEdilen;

            if (tahminEdilen == tahminEdilecekSayi) {
                System.out.println("dogru tahmin!! ");
                switch (tahminHakki) {
                    case (5):
                        System.out.println("ilk tahminde bildiniz.");
                        break;
                    case (4):
                        System.out.println("ikinci tahminde bildiniz.");
                        break;
                    case (3):
                        System.out.println("üçüncü tahminde bildiniz.");
                        break;
                    case (2):
                        System.out.println("dördüncü tahminde bildiniz.");
                        break;
                    case (1):
                        System.out.println("beşinci tahminde bildiniz.");
                        break;

                }
                System.out.println("Bulunan sayi: " + tahminEdilen);
                sonuc = true;
                break;

            } else {

                if (tahminEdilen > 20 || tahminEdilen < 0) {
                    System.out.println("aralik disinda deger girdiniz. Lutfen 0-20 arasinda sayi giriniz.");
                }

                System.out.println("tahmininiz dogru degil");

                if (tahminEdilen < tahminEdilecekSayi) {
                    System.out.println("daha buyuk bir sayi giriniz...");
                }
                if (tahminEdilen > tahminEdilecekSayi) {
                    System.out.println("daha kucuk bir sayi giriniz...");
                }
                sonuc = false;
                tahminHakki--;
                System.out.println("kalan tahmin hakki: " + tahminHakki + "\n");

            }

        }
        System.out.print("butun tahminler : [ ");
        for (int value : butunTahminler) {
            System.out.print(value + ", ");
        }
        System.out.println(" ]");

        if (sonuc == false) {
            System.out.println("tahmin edilemeyen sayi: " + tahminEdilecekSayi);
        }
        return sonuc;

    }

    @Override
    public String toString() {
        return "tahmin: " + tahminEt();
    }

}
