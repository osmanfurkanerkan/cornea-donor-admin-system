import pandas as pd

print("CSV dosyası okunuyor, lütfen bekleyin...")

# Dosyayı okuyoruz
df = pd.read_csv("Pairwise_1000_Patients_Synthetic.csv")

# 1. Hastanın verilerini ayırıyoruz (Donör verilerinden sonraki 22 kolon)
hasta1_df = df.iloc[:, 4:26].copy()
# Pandas aynı isimli kolonlara .1 ekler, onları temizliyoruz
hasta1_df.columns = [str(col).split('.')[0] for col in hasta1_df.columns] 

# 2. Hastanın verilerini ayırıyoruz
hasta2_df = df.iloc[:, 26:48].copy()
hasta2_df.columns = hasta1_df.columns # İsimleri eşitle ki alt alta eklenebilsin

# Hastaları alt alta birleştiriyoruz
tum_hastalar = pd.concat([hasta1_df, hasta2_df], ignore_index=True)

# Çift kayıtları (aynı hastanın diğer eşleşmelerini) temizliyoruz
isim_sutunu = tum_hastalar.columns[0] # İlk kolon Patient_Name olmalı
benzersiz_hastalar = tum_hastalar.drop_duplicates(subset=[isim_sutunu])

# Tertemiz listeyi yeni bir CSV olarak kaydediyoruz
benzersiz_hastalar.to_csv("Sade_1000_Hasta.csv", index=False, encoding="utf-8-sig")

print(f"İşlem bitti! Toplam {len(benzersiz_hastalar)} hasta çıkarıldı.")
print("Dosya 'Sade_1000_Hasta.csv' adıyla klasöre kaydedildi.")