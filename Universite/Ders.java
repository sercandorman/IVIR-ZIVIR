package okul;

public class Ders {

    private String ad;
    private int kod;

    public Ders(String ad, int kod) {
        this.ad = ad;
        this.kod = kod;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }
}
