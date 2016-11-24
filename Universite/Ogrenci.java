package okul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Ogrenci {

    private String ad;
    private String soyad;
    private long no;
    Map<Ders, List<Ogrenci>> dersOgrenci;

    public Ogrenci() {
    }

    public Ogrenci(String ad, String soyad, int no) {
        this.ad = ad;
        this.soyad = soyad;
        this.no = no;
        dersOgrenci = new HashMap<>();
    }

    public void dersEkle(Ders d, Ogrenci ogr) {
        List<Ogrenci> ogrenci = new ArrayList<>();
        ogrenci.add(ogr);
        dersOgrenci.put(d, ogrenci);
    }

    public void dersYazdir() {
        for (Map.Entry<Ders, List<Ogrenci>> i : dersOgrenci.entrySet()) {
            Ders ders = i.getKey();
            List<Ogrenci> ogrenci = i.getValue();
            System.out.println("Ders Adı= " + ders.getAd());
            System.out.println("Ders Kodu= " + ders.getKod());
            System.out.println("Ogrenciler = " + ogrenci.size() + "\n");
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

    public long getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
