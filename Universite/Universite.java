package okul;

public class Universite {

    public static void main(String[] args) {

        Ogrenci ogr1 = new Ogrenci("Sercan", "Dorman", 120401054);
        Ogrenci ogr2 = new Ogrenci("Ertugrul", "Kucukali", 120401001);

        Ogretmen ogrt1 = new Ogretmen("Mustafa", "Sahin");

        Ders d1 = new Ders("Gorsel", 101) {
        };
        Ders d2 = new Ders("Mikro", 102) {
        };

        ogr1.dersEkle(d1,ogr1);
        ogr1.dersEkle(d2,ogr1);
        
        ogr2.dersEkle(d1,ogr2);
        
        ogrt1.dersEkle(d1);

        System.out.println("Ogrenci : \n" + ogr1.getAd() + " " + ogr1.getSoyad() + "\n" + ogr1.getNo());
        System.out.println("Aldigi Dersler : ");
        ogr1.dersYazdir();
        System.out.println("Ogrenci : \n" + ogr2.getAd() + " " + ogr2.getSoyad() + "\n" + ogr2.getNo());
        System.out.println("Aldigi Dersler : ");
        ogr2.dersYazdir();
        System.out.println("\nOgretmen : \n" + ogrt1.getAd() + " " + ogrt1.getSoyad());
        System.out.println("Verdigi Dersler : ");
        ogrt1.dersYazdir();
    }
}
