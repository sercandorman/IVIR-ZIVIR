/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isteklifsistemi;

public class EvTemizligi implements Hizmet {

    public static String evTemizligiID;
    public static String odaSayisi;
    public static String banyoSayisi;
    public static String saat;

    

    public static void setKriter(EvTemizligi et, String evTemizligiID, String odaSayisi, String banyoSayisi, String saat) {
        DBFacede.evTemizligiListesi.put(et, evTemizligiID);

        DBFacede.evTemizligikriterler.put(et, evTemizligiID);
        DBFacede.evTemizligikriterler.put(et, odaSayisi);
        DBFacede.evTemizligikriterler.put(et, banyoSayisi);
        DBFacede.evTemizligikriterler.put(et, saat);
    }

    String getID() {
        return EvTemizligi.evTemizligiID;
    }

    @Override
    public void getKriter() {
    }

}
