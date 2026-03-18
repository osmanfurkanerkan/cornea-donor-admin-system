package cornea.donor.recipient.management;

public class Patient {
    private int id;
    private String adSoyad;
    private int yas;                
    private int cinsiyet;           
    private int pkpAdayiGoz;        
    private String primerHastalik;
    private int bilateralite;       
    private int progresyon;        
    private String eslikEdenBulgu;   
    private String adayEidgk;       
    private String digerEidgk;         
    private int legalKorluk;        
    private int tekGozHasta;        
    private String uygunluk;              
    private int oncekiNakilSayisi;
    private int oncekiNakilTipi;    
    private int greftReddi;            
    private int vizuelPrognoz;      
    private String listeyeGirisTarihi; 
    private String nakilOlmaTarihi;    
    private int beklemeSuresi;         
    private int okulerAgri;         
    private int agriSiddeti;        
    private String sistemikHastalik; 
    private int sosyokulturelDurum; 
    private int aciliyetPuani;      
    private int secilenDonorId;     
    
    //boş constructor
    public Patient() {
        
        this(0, "", 0, 0, 0, "", 0, 0, "", "", "", 0, 0, "", 0, 0, 0, 0, "", "", 0, 0, 0, "", 0, 0, 0);
    }
    //dolu constructor
    public Patient(int id, String adSoyad, int yas, int cinsiyet, int pkpAdayiGoz, String primerHastalik, int bilateralite, int progresyon, String eslikEdenBulgu, String adayEidgk, String digerEidgk, int legalKorluk, int tekGozHasta, String uygunluk, int oncekiNakilSayisi, int oncekiNakilTipi, int greftReddi, int vizuelPrognoz, String listeyeGirisTarihi, String nakilOlmaTarihi, int beklemeSuresi, int okulerAgri, int agriSiddeti, String sistemikHastalik, int sosyokulturelDurum, int aciliyetPuani, int secilenDonorId) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.pkpAdayiGoz = pkpAdayiGoz;
        this.primerHastalik = primerHastalik;
        this.bilateralite = bilateralite;
        this.progresyon = progresyon;
        this.eslikEdenBulgu = eslikEdenBulgu;
        this.adayEidgk = adayEidgk;
        this.digerEidgk = digerEidgk;
        this.legalKorluk = legalKorluk;
        this.tekGozHasta = tekGozHasta;
        this.uygunluk = uygunluk;
        this.oncekiNakilSayisi = oncekiNakilSayisi;
        this.oncekiNakilTipi = oncekiNakilTipi;
        this.greftReddi = greftReddi;
        this.vizuelPrognoz = vizuelPrognoz;
        this.listeyeGirisTarihi = listeyeGirisTarihi;
        this.nakilOlmaTarihi = nakilOlmaTarihi;
        this.beklemeSuresi = beklemeSuresi;
        this.okulerAgri = okulerAgri;
        this.agriSiddeti = agriSiddeti;
        this.sistemikHastalik = sistemikHastalik;
        this.sosyokulturelDurum = sosyokulturelDurum;
        this.aciliyetPuani = aciliyetPuani;
        this.secilenDonorId = secilenDonorId;
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

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getPkpAdayiGoz() {
        return pkpAdayiGoz;
    }

    public void setPkpAdayiGoz(int pkpAdayiGoz) {
        this.pkpAdayiGoz = pkpAdayiGoz;
    }

    public String getPrimerHastalik() {
        return primerHastalik;
    }

    public void setPrimerHastalik(String primerHastalik) {
        this.primerHastalik = primerHastalik;
    }

    public int getBilateralite() {
        return bilateralite;
    }

    public void setBilateralite(int bilateralite) {
        this.bilateralite = bilateralite;
    }

    public int getProgresyon() {
        return progresyon;
    }

    public void setProgresyon(int progresyon) {
        this.progresyon = progresyon;
    }

    public String getEslikEdenBulgu() {
        return eslikEdenBulgu;
    }

    public void setEslikEdenBulgu(String eslikEdenBulgu) {
        this.eslikEdenBulgu = eslikEdenBulgu;
    }

    public String getAdayEidgk() {
        return adayEidgk;
    }

    public void setAdayEidgk(String adayEidgk) {
        this.adayEidgk = adayEidgk;
    }

    public String getDigerEidgk() {
        return digerEidgk;
    }

    public void setDigerEidgk(String digerEidgk) {
        this.digerEidgk = digerEidgk;
    }

    public int getLegalKorluk() {
        return legalKorluk;
    }

    public void setLegalKorluk(int legalKorluk) {
        this.legalKorluk = legalKorluk;
    }

    public int getTekGozHasta() {
        return tekGozHasta;
    }

    public void setTekGozHasta(int tekGozHasta) {
        this.tekGozHasta = tekGozHasta;
    }

    public String getUygunluk() {
        return uygunluk;
    }

    public void setUygunluk(String uygunluk) {
        this.uygunluk = uygunluk;
    }

    public int getOncekiNakilSayisi() {
        return oncekiNakilSayisi;
    }

    public void setOncekiNakilSayisi(int oncekiNakilSayisi) {
        this.oncekiNakilSayisi = oncekiNakilSayisi;
    }

    public int getOncekiNakilTipi() {
        return oncekiNakilTipi;
    }

    public void setOncekiNakilTipi(int oncekiNakilTipi) {
        this.oncekiNakilTipi = oncekiNakilTipi;
    }

    public int getGreftReddi() {
        return greftReddi;
    }

    public void setGreftReddi(int greftReddi) {
        this.greftReddi = greftReddi;
    }

    public int getVizuelPrognoz() {
        return vizuelPrognoz;
    }

    public void setVizuelPrognoz(int vizuelPrognoz) {
        this.vizuelPrognoz = vizuelPrognoz;
    }

    public String getListeyeGirisTarihi() {
        return listeyeGirisTarihi;
    }

    public void setListeyeGirisTarihi(String listeyeGirisTarihi) {
        this.listeyeGirisTarihi = listeyeGirisTarihi;
    }

    public String getNakilOlmaTarihi() {
        return nakilOlmaTarihi;
    }

    public void setNakilOlmaTarihi(String nakilOlmaTarihi) {
        this.nakilOlmaTarihi = nakilOlmaTarihi;
    }

    public int getBeklemeSuresi() {
        return beklemeSuresi;
    }

    public void setBeklemeSuresi(int beklemeSuresi) {
        this.beklemeSuresi = beklemeSuresi;
    }

    public int getOkulerAgri() {
        return okulerAgri;
    }

    public void setOkulerAgri(int okulerAgri) {
        this.okulerAgri = okulerAgri;
    }

    public int getAgriSiddeti() {
        return agriSiddeti;
    }

    public void setAgriSiddeti(int agriSiddeti) {
        this.agriSiddeti = agriSiddeti;
    }

    public String getSistemikHastalik() {
        return sistemikHastalik;
    }

    public void setSistemikHastalik(String sistemikHastalik) {
        this.sistemikHastalik = sistemikHastalik;
    }

    public int getSosyokulturelDurum() {
        return sosyokulturelDurum;
    }

    public void setSosyokulturelDurum(int sosyokulturelDurum) {
        this.sosyokulturelDurum = sosyokulturelDurum;
    }

    public int getAciliyetPuani() {
        return aciliyetPuani;
    }

    public void setAciliyetPuani(int aciliyetPuani) {
        this.aciliyetPuani = aciliyetPuani;
    }

    public int getSecilenDonorId() {
        return secilenDonorId;
    }

    public void setSecilenDonorId(int secilenDonorId) {
        this.secilenDonorId = secilenDonorId;
    }
}