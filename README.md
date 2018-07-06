# Weather Forecast

Menurut wikpedia, Application Program Interface atau API adalah kumpulan dari suatu perintah, fungsi, serta protokol untuk membangun software. Secara singkat, API adalah komponen dari software yang menentukan bagaimana komunikasi terjadi antar dua atau lebih software. Umumnya API digunakan untuk mengambil data dari suatu website dengan format yang sudah bisa dibaca.

Pada tugas ini akan digunakan Open Weather API. Open Weather API adalah API dari openweathermap.org yang akan mengirimkan data cuaca. Banyak jenis API pada Open Weather API, seperti data cuaca saat ini, data cuaca yang selalu diupdate setiap jangka waktu tertentu, atau data perubahan cuaca pada daerah tertentu. Data yang dipakai adalah data berupa Current Weather data (Data cuaca saat ini) dan 5 Day / 3 hour Weather Forecast (Ramalan cuaca setiap 3 jam selama 5 hari). API ini akan mengembalikan data dalam format JSON, sehingga untuk memudahkan pembuatan program digunakan juga package org.json.

# Struktur Package Program

```

Weather-forecast
├─ Asset (Gambar yang dipakai)
├─ city.list.json
├─ src
|   ├─ Main.java
|   ├─ AppUI.java
|   ├─ json-20180130.jar (Untuk mengelola json)
|   └─ weatherpack
|       ├─ WeatherRetriever.java
|       ├─ ForecastRetriever.java
|       └─ CityFinder.java
└─ README.md

```

Struktur package final adalah sebagai berikut. Package weatherpack berisi class-class yang diperlukan untuk mengambil data dari OpenWeatherMap API, seperti data cuaca, data ramalan cuaca, dan mesin pencari kota. Selanjutnya untuk Graphic User Interface sudah tercakup pada WeatherUi.java sehingga tidak perlu dibuat package. Main.java berfungsi untuk memanggil WeatherUi. Adapun gambar yang dipakai program berada dalam folder Asset.

# Checklist:

### Hal yang perlu dilakukan:

Sudah dikerjakan:
- [x] Menentukan struktur package program
- [x] Mencari tahu bagaimana API bekerja
- [x] Membuat class untuk mengambil data cuaca dari hasil API
- [x] Mencari tahu bagaimana mencari kota dengan nama yang sama
- [x] Membuat algoritma pencarian kota berdasarkan kata kunci
- [x] Melakukan review terhadap class untuk mengambil data dari API
- [x] Membuat class untuk mengambil data ramalan cuaca dari hasil API
- [x] Belajar Swing
- [x] Membuat UI program
  - [x] UI bagian Main Menu
  - [x] UI bagian tampilan cuaca
  - [x] UI bagian tampilan ramalan cuaca
  - [x] UI bagian tampilan daftar kota bila hasil pencarian lebih dari satu
  - [x] UI untuk menampilkan pesan error
- [x] Membuat Algoritma Utama Program
  - [x] Algoritma untuk menampilkan cuaca
  - [x] Algoritma untuk menampilkan ramalan cuaca
  - [x] Algoritma untuk menghubungkan daftar nama kota yang sama dengan tampilan cuaca dan ramalan cuaca
- [x] Membuat dokumen sesuai dengan:
  - [x] GoogleStyle
  - [x] JavaDoc
  - [x] JUnit
  - [x] JDepend
- [x] Membuat how to compile
- [x] Membuat how to run
- [x] Membuat how to use

### File yang dikerjakan

Sudah:
- CityFinder.java
- WeatherRetriever.java
- ForecastRetriever.java
- weatherUi.java
- Main.java

# Requirement
- Java SE Development Kit 8
- Eclipse Integrated Development Environment

# How to compile

Terdapat dua tahap melakukan compiling, yaitu memasukkan file ke Eclipse IDE dan mengeluarkannya sebagai executable .jar
### Memasukkan file ke dalam Eclipse IDE

1. Pada Eclipse IDE, pilih 'File' -> 'Import'
2. Pada jendela Import pilih 'Existing Project Into Workspace' dibawah 'General'
![Select Import Type](/Screenshot/IMPORT_-_2SelectExistingProjectIntoWorkspace.png)

3. Pilih direktori yang menuju folder weather-forecast ini.
![Select Folder](/Screenshot/IMPORT_-_3searchweatehrforecastfile.png)
![Import Project](/Screenshot/IMPORT_-_4Imported.png)

4. Bila sudah dibuka, pada jendela Package Explorer terdapat struktur packade sebagai berikut
![Package Explorer](/Screenshot/IMPORT_-_5PackageExplorer.png)

### Export file

5. Setelah memasukkan file pada Eclipse IDE, pilih 'File' -> 'Export'
![Exporting...](/Screenshot/COMPILE_-_1Exportfile.png)

6. Pilih tipe export sebagai 'Runnable jar file' di bawah 'Java'
![Export Type](/Screenshot/COMPILE_-_2exporttype.png)

7. Pilih direktori tempat file jar
![Choose Directory](/Screenshot/COMPILE_-_ChooseDir.png)

# How to run

1. Buka Command Line Interface di direktori tempat file jar dihasilkan, dan jalankan command "java -jar <Nama file jar>.jar
![Choose Directory](/Screenshot/RUN-Run_jar_File_from_CLI.png)

# How to use

Pada saat program dibuka terdapat main menu pada bagian kiri. Terdapat kotak teks untuk pencarian kota, dan dua tombol 'Current Weather' untuk menampilkan keadaan cuaca saat ini di kota tersebut dan 'Weather Forecast' untuk menampilkan ramalan cuaca untuk lima hari kedepan setiap tiga jam.
![Main Menu](/Screenshot/USE_-_Main_Menu.png)

Bila terdapat banyak kota dengan nama yang sama pada saat pencarian, maka akan ditampilkan jendela berisi daftar nama kota yang sama. Pilih salah satu kota untuk menampilkan keadaan cuaca atau ramalan cuaca.
![Search Result](/Screenshot/USE_-_City_Option.png)

Keadaan cuaca akan ditampilkan sebagai berikut. Keadaan cuaca yang tersedia pada program ini adalah suhu, keadaan awan, kelembapan, tekanan udara, kecepatan angin dan arah angin. Gambar awan menunjukkan keadaan awan, sementara tanda panah menunjukkan arah angin.
![Current Weather](/Screenshot/USE_-_Show_Current_Weather.png)

Ramalan cuaca ditampilkan sebagai berikut. Terdapat kotak yang bisa di-scroll berisi ramalan cuaca untuk setiap tiga jam selama 5 hari. Ramalan cuaca pada satu waktu menunjukkan jam perkiraan cuaca, keadaaan awan, arah angin, suhu, tekanan, kelembapan, dan kecepatan angin.
![Current Weather](/Screenshot/USE_-_Show_Weather_Forecast.png)

# Author
Teresa - 13516133

### Short Notification

Dalam tugas ini terdapat pergantian struktur file karena penggunaan Eclipse IDE yang terjadi pada tanggal 6 Juli 2018. Sebelumnya pengerjaan tugas dilakukan dengan text editor sederhana dan debugging menggunakan Command Line Interface.