package isteklifsistemi;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFacede {
    
    static String[][] tekliflerDizisi = new String[5][5];

    static Multimap<EvTemizligi, String> evTemizligikriterler = ArrayListMultimap.create();

    static HashMap<EvTemizligi, String> evTemizligiListesi = new HashMap<EvTemizligi, String>();

    static Map<Musteri, Object> musteriler_ve_kriterleri = new HashMap<Musteri, Object>();

    static Map<Musteri, String> musteriler_ve_sectigiHizmetliler = new HashMap<Musteri, String>();

    static Multimap<KoltukDoseme, String> koltukDosemekriterler = ArrayListMultimap.create();

    static HashMap<KoltukDoseme, String> koltukDosemeListesi = new HashMap<KoltukDoseme, String>();

    static HashMap<Musteri, String> musteriIDListesi = new HashMap<Musteri, String>();

    static ArrayList<String> acikEksiltmeIDListesi = new ArrayList<>();

    static HashMap<String, Musteri> musteriler_ve_acikEksiltmeleri = new HashMap<String, Musteri>();

}
