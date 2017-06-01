package isteklifsistemi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ercan
 */
public class Acik_Eksiltme {

    private boolean isCompleted;

    

    void acikEksiltmeBaslat(String aeID, Musteri m) {
        Acik_Eksiltme.setAcikEksiltmeID(aeID);
        DBFacede.musteriler_ve_acikEksiltmeleri.put(aeID, m);
    }

    static void setAcikEksiltmeID(String acikEksiltmeID) {
        DBFacede.acikEksiltmeIDListesi.add(acikEksiltmeID);
    }

    void initialize() {
    }

    void becomeCompleted() {
        this.isCompleted = true;
    }

    void getAcikEksiltme(String acikEksiltmeID) {
    }

}
