package KorneaDonörveAlıcıYönetimUygulaması;
public class Donör {
    private int id;
    private String adSoyad;
    private int dogumYili;
    private int cinsiyet;
    private Integer endotelSayisi;
    private int pkUygunluk;
    private Integer lamellerTip;
  
    public Donör() {
        this("",0,0,0,0,0,"","");
    }

    public Donör(String adSoyad, int dogumYili, int cinsiyet, int endotelSayisi, int pkUygunluk, int lamellerTip, String uygunGoz, String alinmaTarihi) {
        this.adSoyad = adSoyad;
        this.dogumYili = dogumYili;
        this.cinsiyet = cinsiyet;
        this.endotelSayisi = endotelSayisi;
        this.pkUygunluk = pkUygunluk;
        this.lamellerTip = lamellerTip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getDogumYili() {
        return dogumYili;
    }

    public void setDogumYili(int dogumYili) {
        this.dogumYili = dogumYili;
    }

    public int getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Integer getEndotelSayisi() {
        return endotelSayisi;
    }

    public void setEndotelSayisi(Integer endotelSayisi) {
        this.endotelSayisi = endotelSayisi;
    }

    public Integer getPkUygunluk() {
        return pkUygunluk;
    }

    public void setPkUygunluk(Integer pkUygunluk) {
        this.pkUygunluk = pkUygunluk;
    }

    public Integer getLamellerTip() {
        return lamellerTip;
    }

    public void setLamellerTip(Integer lamellerTip) {
        this.lamellerTip = lamellerTip;
    }

    
    @Override
    public String toString() {
        return adSoyad +  " (ID: " + id + ")"; 
    }
}