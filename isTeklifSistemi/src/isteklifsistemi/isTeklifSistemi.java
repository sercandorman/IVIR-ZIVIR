package isteklifsistemi;

import java.util.Scanner;

public class isTeklifSistemi {

    isTeklifSistemi its;

    public isTeklifSistemi() {
        its = new isTeklifSistemi();
    }

    public static void main(String[] args) {
        
        

        Register rg = new Register();
        Acik_Eksiltme ae = new Acik_Eksiltme();

        Musteri mstr = new Musteri();
        mstr.Musteri(mstr, "100", "sercan", "dorman", "diyarbakir", "2011");
        Musteri mstr2 = new Musteri();
        mstr2.Musteri(mstr2, "200", "ercan", "ergin", "erzurum", "7400");
        Musteri mstr3 = new Musteri();
        mstr3.Musteri(mstr3, "300", "ali", "ihsan", "izmir", "1254");
        Musteri mstr4 = new Musteri();
        mstr4.Musteri(mstr4, "400", "erkan", "yurken", "ankara", "9856");

//************************************************************************
// Acik Eksiltme Baslatma 
//************************************************************************
        KoltukDoseme kd = new KoltukDoseme();
        rg.hizmetSec(kd);
        KoltukDoseme kd2 = new KoltukDoseme();
        rg.hizmetSec(kd2);
        EvTemizligi et = new EvTemizligi();
        rg.hizmetSec(et);
        EvTemizligi et2 = new EvTemizligi();
        rg.hizmetSec(et2);

        
        rg.kriterGir(kd, "1001", "2tekliKoltuk", "3ikiliKoltuk", "1sandalye", "ev");
        rg.kriterleriOnayla(mstr, kd);
        ae.acikEksiltmeBaslat("9001", mstr);

        rg.kriterGir(kd2, "1002", "1tekliKoltuk", "6ikiliKoltuk", "3sandalye", "ofis");
        rg.kriterleriOnayla(mstr2, kd2);
        ae.acikEksiltmeBaslat("9002", mstr2);

        rg.kriterGir(et, "10", "3oda", "1banyo", "2saat");
        rg.kriterleriOnayla(mstr3, et);
        ae.acikEksiltmeBaslat("9003", mstr3);

        rg.kriterGir(et2, "11", "4oda", "2banyo", "4saat");
        rg.kriterleriOnayla(mstr4, et2);
        ae.acikEksiltmeBaslat("9004", mstr4);

        System.out.println("\nMusteriler tarafindan baslatilan tum acik eksiltmeler ;\n");
//************************************************************************
// Teklif Verme
//************************************************************************
        rg.acikEksiltmeGoruntule();

        Hizmetli hizmetli = new Hizmetli();
        hizmetli.Hizmetli(hizmetli , "1", "Mehmet", "Kaya");
        //hizmetli.hizmetliBilgileri(hizmetli, "1", "Mehmet", "Kaya");
        Hizmetli hizmetli2 = new Hizmetli();
        hizmetli2.Hizmetli(hizmetli2 , "2", "Ahmet", "Kaya");
       // hizmetli.hizmetliBilgileri(hizmetli2, "2", "Ahmet", "Kaya");
        
        Scanner scanner = new Scanner(System.in);
//************************************************************************
// 1. Teklif Verme
//************************************************************************       
        System.out.print("\nTeklif vermek istediginiz acik eksiltmenin ID'sini giriniz : ");
        String aeID = scanner.next();

        String secilenAcikEksiltmeID = rg.acikEksiltmeSec(aeID);

        System.out.print("\nTeklif vermek istediginiz fiyati giriniz : ");
        String fiyat = scanner.next();

        rg.teklifVer(secilenAcikEksiltmeID, hizmetli, fiyat, "1NOLUTEKLIF");
//************************************************************************
// 2. Teklif Verme
//************************************************************************    
        System.out.print("\nTeklif vermek istediginiz acik eksiltmenin ID'sini giriniz : ");
        String aeID2 = scanner.next();

        String secilenAcikEksiltmeID2 = rg.acikEksiltmeSec(aeID2);

        System.out.print("\nTeklif vermek istediginiz fiyati giriniz : ");
        String fiyat2 = scanner.next();

        rg.teklifVer(secilenAcikEksiltmeID2, hizmetli2, fiyat2, "2NOLUTEKLIF");
        
//************************************************************************
// HIZMETLI SECME
//************************************************************************

        rg.teklifleriGoruntule(mstr.getID(),"9001");
        System.out.print("\nSecmek istediginiz teklifin no'unu giriniz : ");
        String secilenTeklifID = scanner.next();
        rg.hizmetliSec(mstr,secilenTeklifID);
        

        
    }

}
