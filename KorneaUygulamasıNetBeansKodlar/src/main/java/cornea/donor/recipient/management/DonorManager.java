package cornea.donor.recipient.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorManager {


    public void yeniDonörEkle(Donor donör) { 
        String sql = "INSERT INTO Donors (ad_soyad, dogum_yili, cinsiyet, endotel_sayisi, pk_uygunluk, lameller_tip) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database.connect();
             PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1, donör.getAdSoyad());
            state.setInt(2, donör.getDogumYili());
            state.setInt(3, donör.getCinsiyet());
            if (donör.getEndotelSayisi() == null) {
                state.setNull(4, java.sql.Types.INTEGER);
            } else {
                state.setInt(4, donör.getEndotelSayisi());
            }
            state.setInt(5, donör.getPkUygunluk());
            if (donör.getLamellerTip() == null) {
                state.setNull(6, java.sql.Types.INTEGER);
            } else {
                state.setInt(6, donör.getLamellerTip());
            }
            state.executeUpdate();
            System.out.println("Donör veritabanına kaydedildi");
        } catch (SQLException e) {
            System.err.println("Donörü SQL'e ekleme hatası: " + e.getMessage());
        }
    }
    
    
    public void donorSil(int donorId) {
        String sql = "DELETE FROM Donors WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, donorId);
            int silinen = stmt.executeUpdate();

            if (silinen > 0) {
                System.out.println("Donör başarıyla silindi!");
            } else {
                System.out.println("Donör bulunamadı!");
            }

        } catch (SQLException e) {
            System.err.println("Donörü SQL'den silme hatası: " + e.getMessage());
        }
    }   

    public List<Donor> tumDonorleriListele() {
        List<Donor> donör_listesi = new ArrayList<>();
        String sql = "SELECT * FROM Donors";

        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Donor donör1 = new Donor();
                donör1.setId(resultSet.getInt("id"));
                donör1.setAdSoyad(resultSet.getString("ad_soyad"));
                donör1.setDogumYili(resultSet.getInt("dogum_yili"));
                donör1.setCinsiyet(resultSet.getInt("cinsiyet"));
                int endotelDeger = resultSet.getInt("endotel_sayisi");
                if (resultSet.wasNull()) {
                    donör1.setEndotelSayisi(null);
                } else {
                    donör1.setEndotelSayisi(endotelDeger);
                }
                donör1.setPkUygunluk(resultSet.getInt("pk_uygunluk"));
                int lamelDeger = resultSet.getInt("lameller_tip");
                if (resultSet.wasNull()) {
                     donör1.setLamellerTip(null);
                } else {
                     donör1.setLamellerTip(lamelDeger);
                }
                donör_listesi.add(donör1);
            }
        } catch (SQLException e) {
            System.err.println("Donör listeleme hatası: " + e.getMessage());
        }
        return donör_listesi;
    }
}