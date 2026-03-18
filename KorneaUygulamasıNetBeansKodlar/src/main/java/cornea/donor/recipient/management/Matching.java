package cornea.donor.recipient.management;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Matching {
    private PatientManager hastaYoneticisi = new PatientManager();

    public List<Patient> sirala(Donor donor) {
        List<Patient> hastalar = hastaYoneticisi.tumHastalariListele();
        for (Patient h : hastalar) {
            int hesaplananPuan = puanHesapla(h, donor);
            h.setAciliyetPuani(hesaplananPuan);
        }
        Collections.sort(hastalar, new Comparator<Patient>() {
            @Override
            public int compare(Patient h1, Patient h2) {
                return h2.getAciliyetPuani() - h1.getAciliyetPuani();
            }
        });

        return hastalar;
    }


    private int puanHesapla(Patient h, Donor d) {
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