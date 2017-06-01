package isteklifsistemi;

import java.util.Collection;
import java.util.Map;

public class Register {

    //DBFacede db = new DBFacede();
   
    static int satir = 0, sutun = 0;

//************************************************************************
// 1. SSD METODU
//************************************************************************
    void hizmetSec(Object o) {
        if (o.getClass() == KoltukDoseme.class) {
            o = new KoltukDoseme();
        }
        if (o.getClass() == EvTemizligi.class) {
            o = new EvTemizligi();
        }
    }
//************************************************************************
// 2. SSD METODU
//************************************************************************

    public void kriterGir(KoltukDoseme kd, String koltukDosemeID, String tekliKoltukSayisi, String ikiliKoltukSayisi, String sandalyeSayisi, String diger) {
        KoltukDoseme.setKriter(kd, koltukDosemeID, tekliKoltukSayisi, ikiliKoltukSayisi, sandalyeSayisi, diger);
    }

    public void kriterGir(EvTemizligi et, String evTemizligiID, String odaSayisi, String banyoSayisi, String saat) {
        EvTemizligi.setKriter(et, evTemizligiID, odaSayisi, banyoSayisi, saat);
    }
//************************************************************************
// 3. SSD METODU
//************************************************************************

    void kriterleriOnayla(Musteri m, Object o) {
        DBFacede.musteriler_ve_kriterleri.put(m, o);
    }

    void acikEksiltmeGoruntule() {
        //Acik_Eksiltme.musteriler_ve_acikEksiltmeleri.forEach((k, v) -> System.out.println("AcikEksiltmeID : " + k + " MusteriID : " + v.getID()));
        for (Map.Entry<String, Musteri> entry : DBFacede.musteriler_ve_acikEksiltmeleri.entrySet()) {
            Musteri ma = entry.getValue();
            String aeID = entry.getKey();

            for (Map.Entry<Musteri, Object> entry2 : DBFacede.musteriler_ve_kriterleri.entrySet()) {
                Object o = entry2.getValue();
                Musteri mk = entry2.getKey();

                if (mk.getID().equals(ma.getID())) {
                    if (o instanceof KoltukDoseme) {
                        Collection<String> degerler = DBFacede.koltukDosemekriterler.get((KoltukDoseme) o);
                        System.out.println("Acik Eksiltme ID : " + aeID + " Musteri ID : " + mk.getID() + " Koltuk Doseme Kriterleri : " + degerler);

                    }
                    if (o instanceof EvTemizligi) {
                        Collection<String> degerler2 = DBFacede.evTemizligikriterler.get((EvTemizligi) o);
                        System.out.println("Acik Eksiltme ID : " + aeID + " Musteri ID : " + mk.getID() + " Ev Temizligi Kriterleri : " + degerler2);

                    }

                }

            }

        }
    }

    String acikEksiltmeSec(String acikEksiltmeID) {

        for (Map.Entry<String, Musteri> entry : DBFacede.musteriler_ve_acikEksiltmeleri.entrySet()) {
            Musteri ma = entry.getValue();
            String aeID = entry.getKey();

            for (Map.Entry<Musteri, Object> entry2 : DBFacede.musteriler_ve_kriterleri.entrySet()) {
                Object o = entry2.getValue();
                Musteri mk = entry2.getKey();

                if (mk.getID().equals(ma.getID()) && acikEksiltmeID.equals(aeID)) {
                    if (o instanceof KoltukDoseme) {
                        Collection<String> degerler = DBFacede.koltukDosemekriterler.get((KoltukDoseme) o);
                        System.out.println("Acik Eksiltme ID : " + aeID + " Musteri ID : " + mk.getID() + " Koltuk Doseme Kriterleri : " + degerler);

                    }
                    if (o instanceof EvTemizligi) {
                        Collection<String> degerler2 = DBFacede.evTemizligikriterler.get((EvTemizligi) o);
                        System.out.println("Acik Eksiltme ID : " + aeID + " Musteri ID : " + mk.getID() + " Ev Temizligi Kriterleri : " + degerler2);

                    }

                }

            }

        }

        return acikEksiltmeID;

    }

    void teklifVer(String acikEksiltmeID, Hizmetli hizmetli, String fiyat, String teklifID) {
        for (Map.Entry<String, Musteri> entry : DBFacede.musteriler_ve_acikEksiltmeleri.entrySet()) {
            Musteri ma = entry.getValue();
            String aeID = entry.getKey();
            if (aeID.equals(acikEksiltmeID)) {
                DBFacede.tekliflerDizisi[Register.satir][0] = ma.getID();
                DBFacede.tekliflerDizisi[Register.satir][1] = acikEksiltmeID;
                DBFacede.tekliflerDizisi[Register.satir][2] = hizmetli.getId();
                DBFacede.tekliflerDizisi[Register.satir][3] = fiyat;
                DBFacede.tekliflerDizisi[Register.satir][4] = teklifID;
                Register.satir++;
            }
        }

    }

    void teklifleriGoruntule(String mID, String aeID) {
        int satir2 = 0, sutun2 = 0;
        int enKucukTeklif = Integer.parseInt(DBFacede.tekliflerDizisi[satir2][3]);
        int enKucukTeklifSatirSayisi = 0;
        for (int i = 0; i < 5; i++) {
            if (mID.equals(DBFacede.tekliflerDizisi[satir2][0]) && aeID.equals(DBFacede.tekliflerDizisi[satir2][1])) {
                System.out.println("Hizmetli ID : " + DBFacede.tekliflerDizisi[satir2][2] + " Teklif ettigi fiyat : " + DBFacede.tekliflerDizisi[satir2][3] + " Teklif ID : " + DBFacede.tekliflerDizisi[satir2][4]);
                if (Integer.parseInt(DBFacede.tekliflerDizisi[satir2][3]) <= enKucukTeklif) {
                    enKucukTeklif = Integer.parseInt(DBFacede.tekliflerDizisi[satir2][3]);
                    enKucukTeklifSatirSayisi = satir2;
                }
            }
            satir2++;
        }
        System.out.println("En dusuk teklif : " + enKucukTeklif + " ve " + DBFacede.tekliflerDizisi[enKucukTeklifSatirSayisi][4]);
    }

    void hizmetliSec(Musteri musteri, String teklifID) {
        String secilenHizmetliID = null;
        Hizmetli h = null;
        for (int i = 0; i < 5; i++) {
            if (teklifID.equals(DBFacede.tekliflerDizisi[i][4])) {
                secilenHizmetliID = DBFacede.tekliflerDizisi[i][2];
            }
        }
        System.out.println(secilenHizmetliID + " Nolu Hizmetliyi Sectiniz.");
        
        DBFacede.musteriler_ve_sectigiHizmetliler.put(musteri, secilenHizmetliID);
        
        for (Map.Entry<Musteri, String> entry : DBFacede.musteriler_ve_sectigiHizmetliler.entrySet()) {
            Musteri ma = entry.getKey();
            String ha = entry.getValue();
            System.out.println(ma.getID() + " NOLU MUSTERI, " + ha + " NOLU HIZMETLIYI SECTI.");
        }
    }

    void bilgiGir(String musteriID, String bilgiler) {

    }

}
