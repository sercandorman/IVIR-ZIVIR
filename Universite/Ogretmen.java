package okul;

import java.util.ArrayList;

public class Ogretmen extends Ogrenci {

    private String ad;
    private String soyad;

    ArrayList<Ders> dersOgrt;

    public Ogretmen(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
        dersOgrt = new ArrayList<>();
    }
    public void dersEkle(Ders d) {
        dersOgrt.add(d);
    }

    public void dersYazdir() {
        for (int i = 0; i < dersOgrt.size(); i++) {
            System.out.print("Ders Adi : " + dersOgrt.get(i).getAd() + " ,");
            System.out.println("Kodu : " + dersOgrt.get(i).getKod() + " ");
        }
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

}
