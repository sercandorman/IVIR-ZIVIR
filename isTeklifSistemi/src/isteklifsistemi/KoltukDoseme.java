package isteklifsistemi;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;

public class KoltukDoseme implements Hizmet {

    public static String koltukDosemeID;
    public static String tekliKoltukSayisi;
    public static String ikiliKoltukSayisi;
    public static String sandalyeSayisi;
    public static String diger;

    

    public static void setKriter(KoltukDoseme kd, String koltukDosemeID, String tekliKoltukSayisi, String ikiliKoltukSayisi, String sandalyeSayisi, String diger) {
        DBFacede.koltukDosemeListesi.put(kd, koltukDosemeID);
        KoltukDoseme.koltukDosemeID = koltukDosemeID;
        KoltukDoseme.tekliKoltukSayisi = tekliKoltukSayisi;
        KoltukDoseme.ikiliKoltukSayisi = ikiliKoltukSayisi;
        KoltukDoseme.sandalyeSayisi = sandalyeSayisi;
        KoltukDoseme.diger = diger;

        DBFacede.koltukDosemekriterler.put(kd, koltukDosemeID);
        DBFacede.koltukDosemekriterler.put(kd, tekliKoltukSayisi);
        DBFacede.koltukDosemekriterler.put(kd, ikiliKoltukSayisi);
        DBFacede.koltukDosemekriterler.put(kd, sandalyeSayisi);
        DBFacede.koltukDosemekriterler.put(kd, diger);
    }

    static String getID() {
        return KoltukDoseme.koltukDosemeID;
    }

    @Override
    public void getKriter() {
    }

}
