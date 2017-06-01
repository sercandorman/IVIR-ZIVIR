package isteklifsistemi;

import java.util.HashMap;

public class Musteri {

    private String id;
    private String ad;
    private String soyad;
    private String adres;
    private String telefon;

    public void Musteri(Musteri m, String id, String ad, String soyad, String adres, String telefon) {
        DBFacede.musteriIDListesi.put(m, id);

        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.telefon = telefon;
    }

    String getID() {
        return this.id;
    }

    void create() {

    }
}
