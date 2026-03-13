package KorneaDonörveAlıcıYönetimUygulaması;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Osman Furkan Erkan
 */
import KorneaDonörveAlıcıYönetimUygulaması.AnaSayfaForm;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.util.Locale;



public class HastaForm extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    public HastaForm() {
        initComponents();
        this.setTitle("Hasta Yönetim Paneli");
        Locale tr=new Locale("tr","TR");
        dateListeyeGiris.setLocale(tr);
        dateListeyeGiris.setDateFormatString("dd.MM.yyyy");
        dateNakilOlma.setLocale(tr);
        dateNakilOlma.setDateFormatString("dd.MM.yyyy");
        Locale.setDefault(tr);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        tabloyuYenile(); 

        try {
            txtAdSoyad.setText("");
            txtDogumYili.setText("");
            txtPrimerHastalik.setText("");
            txtEkBulgu.setText("");
            txtAdayEidgk.setText("");
            txtDigerEidgk.setText("");
            txtNakilSayisi.setText("");
            
            txtSistemikHastalik.setText("");

        } catch (Exception e) {

        }
    }
    public void tabloyuYenile() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        HastaYoneticisi yonetici = new HastaYoneticisi();
        List<Hasta> hastalar = yonetici.tumHastalariListele();
        for (Hasta h : hastalar) {
            
            String cinsiyet = (h.getCinsiyet() == 1) ? "Erkek" : "Kadın";
            String goz = (h.getPkpAdayiGoz() == 1) ? "Sağ" : "Sol";
            String bilateral = (h.getBilateralite() == 1) ? "Evet" : "Hayır";

            
            String progresyon = (h.getProgresyon() == 1) ? "Var" : "Yok";

            String lKorluk = (h.getLegalKorluk() == 1) ? "Evet" : "Hayır";
            String tekGoz = (h.getTekGozHasta() == 1) ? "Evet" : "Hayır";

  

            String greftReddi = "Hayır"; 
            if (h.getGreftReddi() == 1) {
                greftReddi = "Evet";
            } else if (h.getGreftReddi() == 3) {
                greftReddi = "Yok"; 
            }

       
            String uygunluk = h.getUygunluk();
            if (uygunluk == null || uygunluk.isEmpty()) uygunluk = "-";

       
            String oncekiNakilTipi = "Yok"; 
            int tip = h.getOncekiNakilTipi();
            if (tip == 1) oncekiNakilTipi = "Ön Lameller";
            else if (tip == 2) oncekiNakilTipi = "Arka Lameller";
            else if (tip == 3) oncekiNakilTipi = "Tam Kat";
   

        
            String vizuelPrognoz = "Düşük";
            if (h.getVizuelPrognoz() == 2) vizuelPrognoz = "Orta";
            else if (h.getVizuelPrognoz() == 3) vizuelPrognoz = "Yüksek";


            String agri = "Yok";
            if (h.getOkulerAgri() == 1) agri = "Var";
            else if (h.getOkulerAgri() == 3) agri = "İntermitan";

            
            String sosyo = "Düşük";
            if (h.getSosyokulturelDurum() == 2) sosyo = "Orta";
            else if (h.getSosyokulturelDurum() == 3) sosyo = "Yüksek";

   
            String secilenDonor = (h.getSecilenDonorId() == 0) ? "-" : String.valueOf(h.getSecilenDonorId());

       
            model.addRow(new Object[]{
                h.getId(),                    
                h.getAdSoyad(),               
                h.getYas(),                   
                cinsiyet,                     
                goz,                          
                h.getPrimerHastalik(),        
                bilateral,                    
                progresyon,                   
                h.getEslikEdenBulgu(),        
                h.getAdayEidgk(),             
                h.getDigerEidgk(),            
                lKorluk,                      
                tekGoz,            
                uygunluk,             
                h.getOncekiNakilSayisi(),     
                oncekiNakilTipi,             
                greftReddi,                   
                vizuelPrognoz,                
                h.getListeyeGirisTarihi(),    
                h.getNakilOlmaTarihi(),       
                h.getBeklemeSuresi(),         
                agri,                         
                h.getAgriSiddeti(),           
                h.getSistemikHastalik(),      
                sosyo,                       
                secilenDonor                
            });
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        button1 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDogumYili = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtAdSoyad = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        cbCinsiyet = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbSosyokulturel = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtDigerEidgk = new java.awt.TextField();
        cbBilateralite1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrimerHastalik = new java.awt.TextField();
        cbGoz = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbProgresyon = new javax.swing.JComboBox<>();
        txtEkBulgu = new java.awt.TextField();
        cbLegalKorluk = new javax.swing.JComboBox<>();
        cbTekGoz = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtAdayEidgk = new java.awt.TextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        dateNakilOlma = new com.toedter.calendar.JDateChooser();
        dateListeyeGiris = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        cbOncekiNakilTipi = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtNakilSayisi = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        checkboxPK = new java.awt.Checkbox();
        checkboxÖL = new java.awt.Checkbox();
        checkboxAL = new java.awt.Checkbox();
        jLabel16 = new javax.swing.JLabel();
        cbGreftReddi = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtSistemikHastalik = new java.awt.TextField();
        cbOkulerAgri = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbPrognoz = new javax.swing.JComboBox<>();
        cbAgriSiddeti = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 0, 0));
        label1.setText("Hasta Yönetim Sayfası");

        button1.setLabel("Hasta Ekle");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button3.setLabel("Güncelle");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setLabel("Hasta Sil");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "İsim", "Doğum Yılı", "Cinsiyet", "PKP Adayı Göz", "Primer Hastalık", "Bilateralite", "Progresyon", "Eşlik Eden Bulgular", "Aday Göz EİDGK", "Diğer EİDGK", "Legal Körlük", "Tek Göz Hasta", "Uygunluk Tipi", "Önceki Nakil Sayısı", "Önceki Nakil Tipi", "Greft Reddi", "Vizuel Prognoz", "Giriş Tarihi", "Nakil Tarihi", "Bekleme Süresi", "Oküler Ağrı", "Ağrı Şiddeti", "Sistemik Hast.", "Sosyokültürel Durum", "Seçilen Donör"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Anasayfaya Dön");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kimlik Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(238, 23, 23))); // NOI18N
        jPanel1.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Doğum Yılı:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ad Soyad:");

        txtAdSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdSoyadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Cinsiyet :");

        cbCinsiyet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "erkek", "kadın" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Sosyokültürel Durum:");

        cbSosyokulturel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "düşük", "orta", "yüksek" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDogumYili, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(txtAdSoyad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cbCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(cbSosyokulturel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAdSoyad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDogumYili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSosyokulturel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hastalık & Göz Durumu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(238, 23, 23))); // NOI18N

        cbBilateralite1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "evet", "hayır" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ameliyat Olacak Göz :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Legal Körlük :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tek Gözlü  Hasta:");

        cbGoz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sol", "sağ" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Diğer Göz EİDGK :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Bilateralite :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Hastalık İlerlemesi (Progresyon):");

        cbProgresyon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "var", "yok" }));

        cbLegalKorluk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "evet", "hayır" }));

        cbTekGoz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "evet", "hayır" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Eşlik Eden Bulgular :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Aday Göz EİDGK :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Primer Hastalık :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbTekGoz, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLegalKorluk, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProgresyon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBilateralite1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrimerHastalik, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbGoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEkBulgu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdayEidgk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDigerEidgk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbGoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtPrimerHastalik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbBilateralite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbProgresyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtEkBulgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdayEidgk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDigerEidgk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbLegalKorluk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTekGoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nakil Detayları", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(238, 23, 23))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Listeye Giriş Tarihi:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Nakil Olma Tarihi:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Önceki Nakil Tipi:");

        cbOncekiNakilTipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yok", "ön lameller", "arka lameller", "tam kat" }));
        cbOncekiNakilTipi.setMinimumSize(new java.awt.Dimension(72, 22));
        cbOncekiNakilTipi.setPreferredSize(new java.awt.Dimension(72, 22));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Önceki Nakil Sayısı:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nakil Uygunluk Tipi   :");

        checkboxPK.setLabel("PK");

        checkboxÖL.setLabel("ÖL");

        checkboxAL.setLabel("AL");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Greft Reddi Var mı?:");

        cbGreftReddi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "evet", "hayır", "yok" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGreftReddi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateListeyeGiris, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(dateNakilOlma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(checkboxPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkboxÖL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkboxAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbOncekiNakilTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)
                            .addComponent(txtNakilSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateListeyeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25))
                    .addComponent(dateNakilOlma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtNakilSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbOncekiNakilTipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(checkboxPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxÖL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbGreftReddi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Şikayet & Prognoz", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(238, 23, 23))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Sistemik Hastalık Varlığı:");

        cbOkulerAgri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "var", "yok", "intermitan" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Vizüel Prognoz (Beklenti):");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Oküler Ağrı:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Ağrı Şiddeti:");

        cbPrognoz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "düşük", "orta", "yüksek" }));

        cbAgriSiddeti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(txtSistemikHastalik, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAgriSiddeti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOkulerAgri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPrognoz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbPrognoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbOkulerAgri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAgriSiddeti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(txtSistemikHastalik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton2.setText("Tıklayınız.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Verileri sıfırlamak için -->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(429, 429, 429)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        
        String adSoyad = txtAdSoyad.getText().trim();
        String dogumYiliStr = txtDogumYili.getText().trim();
        String nakilSayisiStr = txtNakilSayisi.getText().trim();
        
        List<String> eksikAlanlar = new ArrayList<>();

        if (adSoyad.isEmpty()) {
            eksikAlanlar.add("Hasta Adı ve Soyadı");
        }
        if (dogumYiliStr.isEmpty()) {
            eksikAlanlar.add("Doğum Yılı");
        }
        if (dateListeyeGiris.getDate() == null) {
            eksikAlanlar.add("Listeye Giriş Tarihi");
        }
        if (nakilSayisiStr.isEmpty()) {
            eksikAlanlar.add("Önceki Nakil Sayısı");
        }

  
        if (!eksikAlanlar.isEmpty()) {
          
            String mesaj = "Lütfen aşağıdaki alanları doldurunuz:\n\n- " + String.join("\n- ", eksikAlanlar);
            JOptionPane.showMessageDialog(this, mesaj, "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
            return; 
        }

 
        int dogumYili = 0;
        try {
            dogumYili = Integer.parseInt(dogumYiliStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Doğum yılı geçersiz! Lütfen sadece sayı giriniz (Örn: 1990).", "Format Hatası", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int oncekiNakilSayisi = 0;
        try {
            oncekiNakilSayisi = Integer.parseInt(nakilSayisiStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Önceki nakil sayısı sadece rakam olmalıdır!", "Format Hatası", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try {
          
            String primerHastalik = txtPrimerHastalik.getText().trim();
            String eslikEden = txtEkBulgu.getText().trim();
            String adayEidgk = txtAdayEidgk.getText().trim();
            String digerEidgk = txtDigerEidgk.getText().trim();
            String sistemikHastalik = txtSistemikHastalik.getText().trim();

            
            LocalDate girisTarihiLD = null;
            LocalDate nakilTarihiLD = null;

            if (dateListeyeGiris.getDate() != null) {
                girisTarihiLD = dateListeyeGiris.getDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
            }

            if (dateNakilOlma.getDate() != null) {
                nakilTarihiLD = dateNakilOlma.getDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
            }

          
          
            if (!txtNakilSayisi.getText().trim().isEmpty()) {
                oncekiNakilSayisi = Integer.parseInt(txtNakilSayisi.getText().trim());
            }

            int cinsiyet;
            if (cbCinsiyet.getSelectedItem().toString().equalsIgnoreCase("Erkek")) {
                cinsiyet = 1;
            } else {
                cinsiyet = 2;
            }

            int adayGoz;
            if (cbGoz.getSelectedItem().toString().equalsIgnoreCase("Sağ")) {
                adayGoz = 1;
            } else {
                adayGoz = 2;
            }

            int bilateral;
            if (cbBilateralite1.getSelectedItem().toString().equalsIgnoreCase("Evet")) {
                bilateral = 1;
            } else {
                bilateral = 2;
            }

            int progresyon;
            if (cbProgresyon.getSelectedItem().toString().equalsIgnoreCase("Var")) {
                progresyon = 1;
            } else {
                progresyon = 2;
            }

            int lKorluk;
            if (cbLegalKorluk.getSelectedItem().toString().equalsIgnoreCase("Evet")) {
                lKorluk = 1;
            } else {
                lKorluk = 2;
            }

            int tekGoz;
            if (cbTekGoz.getSelectedItem().toString().equalsIgnoreCase("Evet")) {
                tekGoz = 1;
            } else {
                tekGoz = 2;
            }

            int greftReddi = 2; 
            String grStr = cbGreftReddi.getSelectedItem().toString().toLowerCase();
            if (grStr.equals("evet")) {
                greftReddi = 1;
            } else if (grStr.equals("yok")) {
                greftReddi = 3; 
            } else {
                greftReddi = 2;
            }

          
            
            List<String> secilenler = new ArrayList<>();
            if (checkboxPK.getState()) secilenler.add("PK");
            if (checkboxÖL.getState()) secilenler.add("ÖL");
            if (checkboxAL.getState()) secilenler.add("AL");

            String uygunluk = null;

            if (!secilenler.isEmpty()) {
                uygunluk = String.join(", ", secilenler);
            } 


   
            String nakilTipStr = cbOncekiNakilTipi.getSelectedItem().toString();
            int oncekiNakilTipi = 0;

            if (nakilTipStr.contains("ön lameller")) {
                oncekiNakilTipi = 1;
            } else if (nakilTipStr.contains("arka lameller")) {
                oncekiNakilTipi = 2;
            } else if (nakilTipStr.contains("tam kat")) {
                oncekiNakilTipi = 3;
            }


            String prognozStr = cbPrognoz.getSelectedItem().toString().toLowerCase();
            int vizuelPrognoz = 1;

            if (prognozStr.contains("orta")) {
                vizuelPrognoz = 2;
            } else if (prognozStr.contains("yüksek")) {
                vizuelPrognoz = 3;
            }

         
            String agriStr = cbOkulerAgri.getSelectedItem().toString().toLowerCase();
            int okulerAgri = 2;

            if (agriStr.equals("var")) {
                okulerAgri = 1;
            } else if (agriStr.contains("intermitan")) {
                okulerAgri = 3;
            }

            int agriSiddeti = Integer.parseInt(cbAgriSiddeti.getSelectedItem().toString());

            String sosyoStr = cbSosyokulturel.getSelectedItem().toString().toLowerCase();
            int sosyo = 1;
            if (sosyoStr.contains("orta")) {
                sosyo = 2;
            } else if (sosyoStr.contains("yüksek")) {
                sosyo = 3;
            }

          
            long beklemeGun = 0;
            if (girisTarihiLD != null) {
                LocalDate bitisTarihi;

                if (nakilTarihiLD != null) {
                    bitisTarihi = nakilTarihiLD; 
                } else {
                    bitisTarihi = LocalDate.now(); 
                }

                beklemeGun = ChronoUnit.DAYS.between(girisTarihiLD, bitisTarihi);

             
            }

           
            Hasta h = new Hasta();
            h.setAdSoyad(adSoyad);
            h.setYas(dogumYili); 
            h.setCinsiyet(cinsiyet);
            h.setPkpAdayiGoz(adayGoz);
            h.setPrimerHastalik(primerHastalik);
            h.setBilateralite(bilateral);
            h.setProgresyon(progresyon);
            h.setEslikEdenBulgu(eslikEden);
            h.setAdayEidgk(adayEidgk);
            h.setDigerEidgk(digerEidgk);
            h.setLegalKorluk(lKorluk);
            h.setTekGozHasta(tekGoz);
            h.setUygunluk(uygunluk);
            h.setOncekiNakilSayisi(oncekiNakilSayisi);
            h.setOncekiNakilTipi(oncekiNakilTipi);
            h.setGreftReddi(greftReddi);
            h.setVizuelPrognoz(vizuelPrognoz);
            h.setListeyeGirisTarihi(girisTarihiLD != null ? girisTarihiLD.toString() : null);
            h.setNakilOlmaTarihi(nakilTarihiLD != null ? nakilTarihiLD.toString() : null);
            h.setBeklemeSuresi((int) beklemeGun); 
            h.setOkulerAgri(okulerAgri);
            h.setAgriSiddeti(agriSiddeti);
            h.setSistemikHastalik(sistemikHastalik);
            h.setSosyokulturelDurum(sosyo);
            h.setSecilenDonorId(0); 

       
            HastaYoneticisi yonetici = new HastaYoneticisi();
            yonetici.yeniHastaEkle(h);

            JOptionPane.showMessageDialog(this, "Hasta başarıyla eklendi!");
            tabloyuYenile();

          
            txtAdSoyad.setText("");
            txtDogumYili.setText("");
            txtPrimerHastalik.setText("");
            txtEkBulgu.setText("");
            txtAdayEidgk.setText("");
            txtDigerEidgk.setText("");
            txtNakilSayisi.setText("");
            txtSistemikHastalik.setText("");
            dateListeyeGiris.setDate(null);
            dateNakilOlma.setDate(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + e.getMessage());
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void txtAdSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdSoyadActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
  
        int seciliSatir = jTable1.getSelectedRow(); 
        if (seciliSatir == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen silmek için listeden bir hasta seçin.");
            return;
        }
        int secim = JOptionPane.showConfirmDialog(this, 
                "Seçilen hasta kaydını silmek istediğinize emin misiniz?", 
                "Silme Onayı", 
                JOptionPane.YES_NO_OPTION);

        if (secim == JOptionPane.YES_OPTION) {

            try {
                int hastaId = Integer.parseInt(jTable1.getValueAt(seciliSatir, 0).toString());
                HastaYoneticisi yonetici = new HastaYoneticisi();

                yonetici.hastaSil(hastaId);
                JOptionPane.showMessageDialog(this, "Hasta başarıyla silindi.");
                tabloyuYenile(); 
            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Silme sırasında hata oluştu: " + e.getMessage());
            }
    }

    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        
        int seciliSatir = jTable1.getSelectedRow();
        if (seciliSatir == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz hastayı tablodan seçin.");
            return;
        }

        try {
      
            int id = Integer.parseInt(jTable1.getValueAt(seciliSatir, 0).toString());
            HastaYoneticisi yonetici = new HastaYoneticisi();
            Hasta eskiHasta = yonetici.hastaGetirById(id);
            String eskiAd = jTable1.getValueAt(seciliSatir, 1).toString();
            int eskiYas = Integer.parseInt(jTable1.getValueAt(seciliSatir, 2).toString());
            String eskiHastalik = jTable1.getValueAt(seciliSatir, 5).toString();

            String yeniAd = txtAdSoyad.getText().trim().isEmpty() ? eskiAd : txtAdSoyad.getText().trim();
            int yeniYas = txtDogumYili.getText().trim().isEmpty() ? eskiYas : Integer.parseInt(txtDogumYili.getText().trim());
            String yeniHastalik = txtPrimerHastalik.getText().trim().isEmpty() ? eskiHastalik : txtPrimerHastalik.getText().trim();

            String eslikEden = txtEkBulgu.getText().trim().isEmpty() ? eskiHasta.getEslikEdenBulgu() : txtEkBulgu.getText().trim();
            String adayEidgk = txtAdayEidgk.getText().trim().isEmpty() ? eskiHasta.getAdayEidgk() : txtAdayEidgk.getText().trim();
            String digerEidgk = txtDigerEidgk.getText().trim().isEmpty() ? eskiHasta.getDigerEidgk() : txtDigerEidgk.getText().trim();
            String sistemikHastalik = txtSistemikHastalik.getText().trim().isEmpty() ? eskiHasta.getSistemikHastalik() : txtSistemikHastalik.getText().trim();


            String girisTarihiStr = eskiHasta.getListeyeGirisTarihi();
            String nakilTarihiStr = eskiHasta.getNakilOlmaTarihi();

            if (dateListeyeGiris.getDate() != null) {
                girisTarihiStr = dateListeyeGiris.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
            }
            if (dateNakilOlma.getDate() != null) {
                nakilTarihiStr = dateNakilOlma.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
            }

     
            long hesaplananBekleme = eskiHasta.getBeklemeSuresi();
            if (girisTarihiStr != null && !girisTarihiStr.isEmpty()) {
                try {
                    LocalDate baslangic = LocalDate.parse(girisTarihiStr);
                    LocalDate bitis = (nakilTarihiStr != null && !nakilTarihiStr.isEmpty()) ? LocalDate.parse(nakilTarihiStr) : LocalDate.now();
                    hesaplananBekleme = ChronoUnit.DAYS.between(baslangic, bitis);
                } catch (Exception e) {}
            }

     
            int oncekiNakilSayisi = eskiHasta.getOncekiNakilSayisi();
            if (!txtNakilSayisi.getText().trim().isEmpty()) {
                oncekiNakilSayisi = Integer.parseInt(txtNakilSayisi.getText().trim());
            }

            int agriSiddeti = eskiHasta.getAgriSiddeti();
            if(cbAgriSiddeti.getSelectedItem() != null) {
                 agriSiddeti = Integer.parseInt(cbAgriSiddeti.getSelectedItem().toString());
            }

            int cinsiyet = cbCinsiyet.getSelectedItem().toString().equalsIgnoreCase("Erkek") ? 1 : 2;
            int adayGoz = cbGoz.getSelectedItem().toString().equalsIgnoreCase("Sağ") ? 1 : 2;
            int bilateral = cbBilateralite1.getSelectedItem().toString().equalsIgnoreCase("Evet") ? 1 : 2;

            int progresyon = 2;
            if (cbProgresyon.getSelectedItem().toString().equalsIgnoreCase("Var")) progresyon = 1;

            int lKorluk = cbLegalKorluk.getSelectedItem().toString().equalsIgnoreCase("Evet") ? 1 : 2;
            int tekGoz = cbTekGoz.getSelectedItem().toString().equalsIgnoreCase("Evet") ? 1 : 2;

     
            int greftReddi = 2; 
            if (cbGreftReddi.getSelectedItem() != null) {
                String secim = cbGreftReddi.getSelectedItem().toString().toLowerCase();
                if (secim.equals("evet")) greftReddi = 1;
                else if (secim.equals("yok")) greftReddi = 3; // ARTIK GÜNCELLER
                else greftReddi = 2;
            }

            List<String> secilenler = new ArrayList<>();
            if (checkboxPK.getState()) secilenler.add("PK");
            if (checkboxÖL.getState()) secilenler.add("ÖL");
            if (checkboxAL.getState()) secilenler.add("AL");

            String uygunluk = null;
            if (!secilenler.isEmpty()) {
                uygunluk = String.join(", ", secilenler);
            } 

            int oncekiNakilTipi = 0;
            if (cbOncekiNakilTipi.getSelectedItem() != null) {
                String nakilTipStr = cbOncekiNakilTipi.getSelectedItem().toString().toLowerCase();

                if (nakilTipStr.contains("ön")) oncekiNakilTipi = 1;
                else if (nakilTipStr.contains("arka")) oncekiNakilTipi = 2;
                else if (nakilTipStr.contains("tam")) oncekiNakilTipi = 3;
                else oncekiNakilTipi = 0; 
            }

            int vizuelPrognoz = 1;
            String prognozStr = cbPrognoz.getSelectedItem().toString().toLowerCase();
            if (prognozStr.contains("orta")) vizuelPrognoz = 2;
            else if (prognozStr.contains("yüksek")) vizuelPrognoz = 3;

            int okulerAgri = 2;
            String agriStr = cbOkulerAgri.getSelectedItem().toString().toLowerCase();
            if (agriStr.equals("var")) okulerAgri = 1;
            else if (agriStr.contains("intermitan")) okulerAgri = 3;

            int sosyo = 1;
            String sosyoStr = cbSosyokulturel.getSelectedItem().toString().toLowerCase();
            if (sosyoStr.contains("orta")) sosyo = 2;
            else if (sosyoStr.contains("yüksek")) sosyo = 3;


            Hasta h = new Hasta();
            h.setId(id);
            h.setAdSoyad(yeniAd);
            h.setYas(yeniYas);
            h.setPrimerHastalik(yeniHastalik);
            h.setCinsiyet(cinsiyet);
            h.setPkpAdayiGoz(adayGoz);
            h.setBilateralite(bilateral);
            h.setProgresyon(progresyon);
            h.setEslikEdenBulgu(eslikEden);
            h.setAdayEidgk(adayEidgk);
            h.setDigerEidgk(digerEidgk);
            h.setLegalKorluk(lKorluk);
            h.setTekGozHasta(tekGoz);
            h.setUygunluk(uygunluk);
            h.setOncekiNakilSayisi(oncekiNakilSayisi);
            h.setOncekiNakilTipi(oncekiNakilTipi);
            h.setGreftReddi(greftReddi);
            h.setVizuelPrognoz(vizuelPrognoz);
            h.setListeyeGirisTarihi(girisTarihiStr);
            h.setNakilOlmaTarihi(nakilTarihiStr);
            h.setBeklemeSuresi((int) hesaplananBekleme);
            h.setOkulerAgri(okulerAgri);
            h.setAgriSiddeti(agriSiddeti);
            h.setSistemikHastalik(sistemikHastalik);
            h.setSosyokulturelDurum(sosyo);


            String donenMesaj = yonetici.hastaDuzenle(h); 
            JOptionPane.showMessageDialog(this, donenMesaj);
            tabloyuYenile();

            txtAdSoyad.setText("");
            txtDogumYili.setText("");
            txtPrimerHastalik.setText("");
            txtEkBulgu.setText("");
            txtAdayEidgk.setText("");
            txtDigerEidgk.setText("");
            txtNakilSayisi.setText("");
            txtSistemikHastalik.setText("");
            dateListeyeGiris.setDate(null);
            dateNakilOlma.setDate(null);
            checkboxPK.setState(false);
            checkboxÖL.setState(false);
            checkboxAL.setState(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }
        
    }//GEN-LAST:event_button3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AnaSayfaForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int seciliSatir = jTable1.getSelectedRow();
        if (seciliSatir == -1) return;

        try {
            int id = Integer.parseInt(jTable1.getValueAt(seciliSatir, 0).toString());
            HastaYoneticisi yonetici = new HastaYoneticisi();
            Hasta h = yonetici.hastaGetirById(id);

            txtAdSoyad.setText(h.getAdSoyad());
            txtDogumYili.setText(String.valueOf(h.getYas()));
            txtPrimerHastalik.setText(h.getPrimerHastalik());
            txtEkBulgu.setText(h.getEslikEdenBulgu());
            txtAdayEidgk.setText(h.getAdayEidgk());
            txtDigerEidgk.setText(h.getDigerEidgk());
            txtSistemikHastalik.setText(h.getSistemikHastalik());
            txtNakilSayisi.setText(String.valueOf(h.getOncekiNakilSayisi()));

            if (h.getListeyeGirisTarihi() != null && !h.getListeyeGirisTarihi().isEmpty()) {
                dateListeyeGiris.setDate(java.sql.Date.valueOf(h.getListeyeGirisTarihi()));
            } else {
                dateListeyeGiris.setDate(null);
            }

            if (h.getNakilOlmaTarihi() != null && !h.getNakilOlmaTarihi().isEmpty()) {
                dateNakilOlma.setDate(java.sql.Date.valueOf(h.getNakilOlmaTarihi()));
            } else {
                dateNakilOlma.setDate(null);
            }

            if (h.getCinsiyet() == 1) cbCinsiyet.setSelectedItem("erkek");
            else cbCinsiyet.setSelectedItem("kadın");

            if (h.getPkpAdayiGoz() == 1) cbGoz.setSelectedItem("sağ");
            else cbGoz.setSelectedItem("sol");

            if (h.getBilateralite() == 1) cbBilateralite1.setSelectedItem("evet");
            else cbBilateralite1.setSelectedItem("hayır");

            if (h.getProgresyon() == 1) cbProgresyon.setSelectedItem("var");
            else cbProgresyon.setSelectedItem("yok");

            if (h.getLegalKorluk() == 1) cbLegalKorluk.setSelectedItem("evet");
            else cbLegalKorluk.setSelectedItem("hayır");

            if (h.getTekGozHasta() == 1) cbTekGoz.setSelectedItem("evet");
            else cbTekGoz.setSelectedItem("hayır");

          
            int greftDurum = h.getGreftReddi();

            if (greftDurum == 1) {
                cbGreftReddi.setSelectedItem("evet");
            } 
            else if (greftDurum == 3) { 
                cbGreftReddi.setSelectedItem("yok"); 
            } 
            else {
                cbGreftReddi.setSelectedItem("hayır");
            }

   
            if (h.getVizuelPrognoz() == 1) cbPrognoz.setSelectedItem("düşük");
            else if (h.getVizuelPrognoz() == 2) cbPrognoz.setSelectedItem("orta");
            else cbPrognoz.setSelectedItem("yüksek");

            if (h.getSosyokulturelDurum() == 1) cbSosyokulturel.setSelectedItem("düşük");
            else if (h.getSosyokulturelDurum() == 2) cbSosyokulturel.setSelectedItem("orta");
            else cbSosyokulturel.setSelectedItem("yüksek");

   
            if (h.getOkulerAgri() == 1) cbOkulerAgri.setSelectedItem("var");
            else if (h.getOkulerAgri() == 3) cbOkulerAgri.setSelectedItem("intermitan");
            else cbOkulerAgri.setSelectedItem("yok");

   
            cbAgriSiddeti.setSelectedItem(String.valueOf(h.getAgriSiddeti()));


            int tip = h.getOncekiNakilTipi();
            if (tip == 1) cbOncekiNakilTipi.setSelectedItem("ön lameller");
            else if (tip == 2) cbOncekiNakilTipi.setSelectedItem("arka lameller");
            else if (tip == 3) cbOncekiNakilTipi.setSelectedItem("tam kat");
            else cbOncekiNakilTipi.setSelectedItem("yok"); 


            checkboxPK.setState(false);
            checkboxÖL.setState(false);
            checkboxAL.setState(false);

            String uygunluk = h.getUygunluk(); 
            if (uygunluk != null) {
                if (uygunluk.contains("PK")) checkboxPK.setState(true);
                if (uygunluk.contains("ÖL")) checkboxÖL.setState(true);
                if (uygunluk.contains("AL")) checkboxAL.setState(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
     // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tabloyuYenile();

            txtAdSoyad.setText("");
            txtDogumYili.setText("");
            txtPrimerHastalik.setText("");
            txtEkBulgu.setText("");
            txtAdayEidgk.setText("");
            txtDigerEidgk.setText("");
            txtNakilSayisi.setText("");
            txtSistemikHastalik.setText("");
            dateListeyeGiris.setDate(null);
            dateNakilOlma.setDate(null);
            checkboxPK.setState(false);
            checkboxÖL.setState(false);
            checkboxAL.setState(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
    
        com.formdev.flatlaf.FlatLightLaf.setup(); 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HastaForm().setVisible(true);
            }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JComboBox<String> cbAgriSiddeti;
    private javax.swing.JComboBox<String> cbBilateralite1;
    private javax.swing.JComboBox<String> cbCinsiyet;
    private javax.swing.JComboBox<String> cbGoz;
    private javax.swing.JComboBox<String> cbGreftReddi;
    private javax.swing.JComboBox<String> cbLegalKorluk;
    private javax.swing.JComboBox<String> cbOkulerAgri;
    private javax.swing.JComboBox<String> cbOncekiNakilTipi;
    private javax.swing.JComboBox<String> cbPrognoz;
    private javax.swing.JComboBox<String> cbProgresyon;
    private javax.swing.JComboBox<String> cbSosyokulturel;
    private javax.swing.JComboBox<String> cbTekGoz;
    private java.awt.Checkbox checkboxAL;
    private java.awt.Checkbox checkboxPK;
    private java.awt.Checkbox checkboxÖL;
    private com.toedter.calendar.JDateChooser dateListeyeGiris;
    private com.toedter.calendar.JDateChooser dateNakilOlma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.TextField txtAdSoyad;
    private java.awt.TextField txtAdayEidgk;
    private java.awt.TextField txtDigerEidgk;
    private java.awt.TextField txtDogumYili;
    private java.awt.TextField txtEkBulgu;
    private java.awt.TextField txtNakilSayisi;
    private java.awt.TextField txtPrimerHastalik;
    private java.awt.TextField txtSistemikHastalik;
    // End of variables declaration//GEN-END:variables
}
