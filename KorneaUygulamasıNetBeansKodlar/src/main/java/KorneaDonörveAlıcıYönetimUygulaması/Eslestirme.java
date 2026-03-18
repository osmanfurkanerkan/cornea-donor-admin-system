package KorneaDonörveAlıcıYönetimUygulaması;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Eslestirme {
    private HastaYoneticisi hastaYoneticisi = new HastaYoneticisi();

    public List<Hasta> sirala(Donör donor) {
        List<Hasta> hastalar = hastaYoneticisi.tumHastalariListele();
        for (Hasta h : hastalar) {
            int hesaplananPuan = puanHesapla(h, donor);
            h.setAciliyetPuani(hesaplananPuan);
        }
        Collections.sort(hastalar, new Comparator<Hasta>() {
            @Override
            public int compare(Hasta h1, Hasta h2) {
                return h2.getAciliyetPuani() - h1.getAciliyetPuani();
            }
        });

        return hastalar;
    }


    private int puanHesapla(Hasta h, Donör d) {
        int korneaPuan = 0;
        if (d.getEndotelSayisi() >= 2500) {
            korneaPuan = 5;      
        } else if (d.getEndotelSayisi() >= 2000) {
            korneaPuan = 2;     
        } else {
            korneaPuan = 0;     
        }
        int aciliyet;
        if (h.getLegalKorluk() == 1) {
            aciliyet = 10; 
        } else {
            aciliyet = 5;  
        }
        return (aciliyet * 2) + korneaPuan;
    }
}