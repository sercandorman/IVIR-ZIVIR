package isteklifsistemi;


public class Hizmetli {

    public String id;
    public String ad;
    public String soyad;
    public String adres;
    public String telefon;

    hizmetliMapper hm = new hizmetliMapper();

    public void Hizmetli(Hizmetli h, String id, String ad, String soyad) {
        hm.put(h, id);

        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }

    //public void hizmetliBilgileri(Hizmetli h, String id, String ad, String soyad) {
    //hizmetliler_ve_IDleri.put(h, id);
    //this.ad = ad;
    //this.soyad = soyad;
    //}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    void create() {
    }

    void getHizmetli(String hizmetliID) {
    }
}
