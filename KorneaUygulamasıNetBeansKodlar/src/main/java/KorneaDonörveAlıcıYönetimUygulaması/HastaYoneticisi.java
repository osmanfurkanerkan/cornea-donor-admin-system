package KorneaDonörveAlıcıYönetimUygulaması;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HastaYoneticisi {

    public void yeniHastaEkle(Hasta hasta) {
        String sql = "INSERT INTO Patients (ad_soyad, yas, cinsiyet, pkp_adayi_goz, primer_hastalik, primer_hastalik_bilateralite, primer_hastalik_progresyonu, eslik_eden_goz_bulgusu, aday_eidgk, diger_eidgk, legal_korluk, tek_goz_hasta, uygunluk, onceki_nakil_sayisi, onceki_nakil_tipi, greft_reddi_nedenli, vizuel_prognoz, listeye_giris_tarihi, nakil_olma_tarihi, bekleme_suresi, okuler_agri, agri_siddeti, sistemik_hastalik, sosyokulturel_durum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connect();
             PreparedStatement state = conn.prepareStatement(sql)) {

            state.setString(1, hasta.getAdSoyad());
            state.setInt(2, hasta.getYas());
            state.setInt(3, hasta.getCinsiyet());
            state.setInt(4, hasta.getPkpAdayiGoz());
            state.setString(5, hasta.getPrimerHastalik());
            state.setInt(6, hasta.getBilateralite());
            state.setInt(7, hasta.getProgresyon());
            state.setString(8, hasta.getEslikEdenBulgu());
            state.setString(9, hasta.getAdayEidgk());
            state.setString(10, hasta.getDigerEidgk());
            state.setInt(11, hasta.getLegalKorluk());
            state.setInt(12, hasta.getTekGozHasta());
            state.setString(13, hasta.getUygunluk());
            state.setInt(14, hasta.getOncekiNakilSayisi());
            state.setInt(15, hasta.getOncekiNakilTipi());
            state.setInt(16, hasta.getGreftReddi());
            state.setInt(17, hasta.getVizuelPrognoz());
            state.setString(18, hasta.getListeyeGirisTarihi());
            state.setString(19, hasta.getNakilOlmaTarihi());
            state.setInt(20, hasta.getBeklemeSuresi());
            state.setInt(21, hasta.getOkulerAgri());
            state.setInt(22, hasta.getAgriSiddeti());
            state.setString(23, hasta.getSistemikHastalik());
            state.setInt(24, hasta.getSosyokulturelDurum());

            state.executeUpdate();
            System.out.println("Hasta başarıyla kaydedildi!");

        } catch (SQLException e) {
            System.err.println("Hastayı SQL'e ekleme hatası: " + e.getMessage());
        }
    }

    public List<Hasta> tumHastalariListele() {
        List<Hasta> hastalar = new ArrayList<>();
        String sql = "SELECT * FROM Patients";

        try (Connection conn = DataBase.connect();
             PreparedStatement state = conn.prepareStatement(sql);
             ResultSet resultSet = state.executeQuery()) {

            while (resultSet.next()) {
                Hasta h = new Hasta();
                h.setId(resultSet.getInt("id"));
                h.setAdSoyad(resultSet.getString("ad_soyad"));
                h.setYas(resultSet.getInt("yas"));
                h.setCinsiyet(resultSet.getInt("cinsiyet"));
                h.setPkpAdayiGoz(resultSet.getInt("pkp_adayi_goz"));
                h.setPrimerHastalik(resultSet.getString("primer_hastalik"));
                h.setBilateralite(resultSet.getInt("primer_hastalik_bilateralite"));
                h.setProgresyon(resultSet.getInt("primer_hastalik_progresyonu"));
                h.setEslikEdenBulgu(resultSet.getString("eslik_eden_goz_bulgusu"));
                h.setAdayEidgk(resultSet.getString("aday_eidgk"));
                h.setDigerEidgk(resultSet.getString("diger_eidgk"));
                h.setLegalKorluk(resultSet.getInt("legal_korluk"));
                h.setTekGozHasta(resultSet.getInt("tek_goz_hasta"));
                h.setUygunluk(resultSet.getString("uygunluk"));
                h.setOncekiNakilSayisi(resultSet.getInt("onceki_nakil_sayisi"));
                h.setOncekiNakilTipi(resultSet.getInt("onceki_nakil_tipi"));
                h.setGreftReddi(resultSet.getInt("greft_reddi_nedenli"));
                h.setVizuelPrognoz(resultSet.getInt("vizuel_prognoz"));
                h.setListeyeGirisTarihi(resultSet.getString("listeye_giris_tarihi"));
                h.setNakilOlmaTarihi(resultSet.getString("nakil_olma_tarihi"));
                h.setBeklemeSuresi(resultSet.getInt("bekleme_suresi"));
                h.setOkulerAgri(resultSet.getInt("okuler_agri"));
                h.setAgriSiddeti(resultSet.getInt("agri_siddeti"));
                h.setSistemikHastalik(resultSet.getString("sistemik_hastalik"));
                h.setSosyokulturelDurum(resultSet.getInt("sosyokulturel_durum"));
                h.setSecilenDonorId(resultSet.getInt("secilen_donor_id"));
                hastalar.add(h);
                
            }
        } catch (SQLException e) {
            System.err.println("Hastaları Listeleme Hatası: " + e.getMessage());
        }
        return hastalar;
    }
    public Hasta hastaGetirById(int id) {
        String sql = "SELECT * FROM Patients WHERE id = ?";
        Hasta h = null;

        try (Connection conn = DataBase.connect();
             PreparedStatement state = conn.prepareStatement(sql)) {

            state.setInt(1, id);
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                h = new Hasta();
                h.setId(rs.getInt("id"));
                h.setAdSoyad(rs.getString("ad_soyad"));
                h.setYas(rs.getInt("yas"));
                h.setCinsiyet(rs.getInt("cinsiyet"));
                h.setPkpAdayiGoz(rs.getInt("pkp_adayi_goz"));
                h.setPrimerHastalik(rs.getString("primer_hastalik"));
                h.setBilateralite(rs.getInt("primer_hastalik_bilateralite"));
                h.setProgresyon(rs.getInt("primer_hastalik_progresyonu"));
                h.setEslikEdenBulgu(rs.getString("eslik_eden_goz_bulgusu"));
                h.setAdayEidgk(rs.getString("aday_eidgk"));
                h.setDigerEidgk(rs.getString("diger_eidgk"));
                h.setLegalKorluk(rs.getInt("legal_korluk"));
                h.setTekGozHasta(rs.getInt("tek_goz_hasta"));
                h.setUygunluk(rs.getString("uygunluk"));
                h.setOncekiNakilSayisi(rs.getInt("onceki_nakil_sayisi"));
                h.setOncekiNakilTipi(rs.getInt("onceki_nakil_tipi"));
                h.setGreftReddi(rs.getInt("greft_reddi_nedenli"));
                h.setVizuelPrognoz(rs.getInt("vizuel_prognoz"));
                h.setListeyeGirisTarihi(rs.getString("listeye_giris_tarihi"));
                h.setNakilOlmaTarihi(rs.getString("nakil_olma_tarihi"));
                h.setBeklemeSuresi(rs.getInt("bekleme_suresi"));
                h.setOkulerAgri(rs.getInt("okuler_agri"));
                h.setAgriSiddeti(rs.getInt("agri_siddeti"));
                h.setSistemikHastalik(rs.getString("sistemik_hastalik"));
                h.setSosyokulturelDurum(rs.getInt("sosyokulturel_durum"));
                h.setSecilenDonorId(rs.getInt("secilen_donor_id"));
            }

        } catch (SQLException e) {
            System.err.println("Hasta getirme hatası: " + e.getMessage());
        }
        return h;
    }
    
    private List<String> degisenAlanlariBul(Hasta eski, Hasta yeni) {
      List<String> degisenler = new ArrayList<>();

      if (!java.util.Objects.equals(eski.getAdSoyad(), yeni.getAdSoyad()))
          degisenler.add("Ad Soyad");

      if (eski.getYas() != yeni.getYas())
          degisenler.add("Yaş");

      if (eski.getCinsiyet() != yeni.getCinsiyet())
          degisenler.add("Cinsiyet");

      if (eski.getPkpAdayiGoz() != yeni.getPkpAdayiGoz())
          degisenler.add("PKP Adayı Göz");

      if (!java.util.Objects.equals(eski.getPrimerHastalik(), yeni.getPrimerHastalik()))
          degisenler.add("Primer Hastalık");

      if (eski.getBilateralite() != yeni.getBilateralite())
          degisenler.add("Primer Hastalık Bilateralite");

      if (eski.getProgresyon() != yeni.getProgresyon())
          degisenler.add("Primer Hastalık Progresyonu");

      if (!java.util.Objects.equals(eski.getEslikEdenBulgu(), yeni.getEslikEdenBulgu()))
          degisenler.add("Eşlik Eden Göz Bulgusu");

      if (!java.util.Objects.equals(eski.getAdayEidgk(), yeni.getAdayEidgk()))
          degisenler.add("Aday EİDGK");

      if (!java.util.Objects.equals(eski.getDigerEidgk(), yeni.getDigerEidgk()))
          degisenler.add("Diğer EİDGK");

      if (eski.getLegalKorluk() != yeni.getLegalKorluk())
          degisenler.add("Legal Körlük");

      if (eski.getTekGozHasta() != yeni.getTekGozHasta())
          degisenler.add("Tek Göz Hasta");

      if (!java.util.Objects.equals(eski.getUygunluk(), yeni.getUygunluk()))
          degisenler.add("Uygunluk");

      if (eski.getOncekiNakilSayisi() != yeni.getOncekiNakilSayisi())
          degisenler.add("Önceki Nakil Sayısı");

      if (eski.getOncekiNakilTipi() != yeni.getOncekiNakilTipi())
          degisenler.add("Önceki Nakil Tipi");

      if (eski.getGreftReddi() != yeni.getGreftReddi())
          degisenler.add("Greft Reddi Nedenli");

      if (eski.getVizuelPrognoz() != yeni.getVizuelPrognoz())
          degisenler.add("Vizüel Prognoz");

      if (!java.util.Objects.equals(eski.getListeyeGirisTarihi(), yeni.getListeyeGirisTarihi()))
          degisenler.add("Listeye Giriş Tarihi");

      if (!java.util.Objects.equals(eski.getNakilOlmaTarihi(), yeni.getNakilOlmaTarihi()))
          degisenler.add("Nakil Olma Tarihi");

      if (eski.getBeklemeSuresi() != yeni.getBeklemeSuresi())
          degisenler.add("Bekleme Süresi");

      if (eski.getOkulerAgri() != yeni.getOkulerAgri())
          degisenler.add("Oküler Ağrı");

      if (eski.getAgriSiddeti() != yeni.getAgriSiddeti())
          degisenler.add("Ağrı Şiddeti");

      if (!java.util.Objects.equals(eski.getSistemikHastalik(), yeni.getSistemikHastalik()))
          degisenler.add("Sistemik Hastalık");

      if (eski.getSosyokulturelDurum() != yeni.getSosyokulturelDurum())
          degisenler.add("Sosyokültürel Durum");

      if (eski.getSecilenDonorId() != yeni.getSecilenDonorId())
          degisenler.add("Seçilen Donör");

      return degisenler;
  }



    public String hastaDuzenle(Hasta hasta) {
        Hasta eskiHasta = hastaGetirById(hasta.getId());
        if (hasta.getListeyeGirisTarihi() == null) {
            hasta.setListeyeGirisTarihi(eskiHasta.getListeyeGirisTarihi());
        }

        if (hasta.getNakilOlmaTarihi() == null) {
            hasta.setNakilOlmaTarihi(eskiHasta.getNakilOlmaTarihi());
        }


        String sql = "UPDATE Patients SET ad_soyad = ?, yas = ?, cinsiyet = ?, pkp_adayi_goz = ?, primer_hastalik = ?, primer_hastalik_bilateralite = ?, primer_hastalik_progresyonu = ?, eslik_eden_goz_bulgusu = ?, aday_eidgk = ?, diger_eidgk = ?, legal_korluk = ?, tek_goz_hasta = ?, uygunluk = ?, onceki_nakil_sayisi = ?, onceki_nakil_tipi = ?, greft_reddi_nedenli = ?, vizuel_prognoz = ?, listeye_giris_tarihi = ?, nakil_olma_tarihi = ?, bekleme_suresi = ?, okuler_agri = ?, agri_siddeti = ?, sistemik_hastalik = ?, sosyokulturel_durum = ?, secilen_donor_id = ? WHERE id = ?";
        
        List<String> degisenAlanlar = degisenAlanlariBul(eskiHasta, hasta);

        try (Connection conn = DataBase.connect();
             PreparedStatement state = conn.prepareStatement(sql)) {

            state.setString(1, hasta.getAdSoyad());
            state.setInt(2, hasta.getYas());
            state.setInt(3, hasta.getCinsiyet());
            state.setInt(4, hasta.getPkpAdayiGoz());
            state.setString(5, hasta.getPrimerHastalik());
            state.setInt(6, hasta.getBilateralite());
            state.setInt(7, hasta.getProgresyon());
            state.setString(8, hasta.getEslikEdenBulgu());
            state.setString(9, hasta.getAdayEidgk());
            state.setString(10, hasta.getDigerEidgk());
            state.setInt(11, hasta.getLegalKorluk());
            state.setInt(12, hasta.getTekGozHasta());
            state.setString(13, hasta.getUygunluk());
            state.setInt(14, hasta.getOncekiNakilSayisi());
            state.setInt(15, hasta.getOncekiNakilTipi());
            state.setInt(16, hasta.getGreftReddi());
            state.setInt(17, hasta.getVizuelPrognoz());
            state.setString(18, hasta.getListeyeGirisTarihi());
            state.setString(19, hasta.getNakilOlmaTarihi());
            state.setInt(20, hasta.getBeklemeSuresi());
            state.setInt(21, hasta.getOkulerAgri());
            state.setInt(22, hasta.getAgriSiddeti());
            state.setString(23, hasta.getSistemikHastalik());
            state.setInt(24, hasta.getSosyokulturelDurum());
            state.setInt(25, hasta.getSecilenDonorId());
            state.setInt(26, hasta.getId());

            state.executeUpdate();
            if (degisenAlanlar.isEmpty()) {
                return "Herhangi bir değişiklik yapılmadı.";
            } else {
                 return String.join(", ", degisenAlanlar) + " alanları güncellendi.";
            }

        } catch (SQLException e) {
            return "Düzenleme Hatası: " + e.getMessage();
        }
    }

    public void hastaSil(int hastaId) {
        String sql = "DELETE FROM Patients WHERE id = ?";

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, hastaId);
            pstmt.executeUpdate();
            System.out.println("Hasta silindi.");

        } catch (SQLException e) {
            System.err.println("Hastayı SQL'den Silme hatası: " + e.getMessage());
        }
    }
}