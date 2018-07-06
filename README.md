# Weather Forecast

Menurut wikpedia, Application Program Interface atau API adalah kumpulan dari suatu perintah, fungsi, serta protokol untuk membangun software. Secara singkat, API adalah komponen dari software yang menentukan bagaimana komunikasi terjadi antar dua atau lebih software. Umumnya API digunakan untuk mengambil data dari suatu website dengan format yang sudah bisa dibaca.

Pada tugas ini akan digunakan Open Weather API. Open Weather API adalah API dari openweathermap.org yang akan mengirimkan data cuaca. Banyak jenis API pada Open Weather API, seperti data cuaca saat ini, data cuaca yang selalu diupdate setiap jangka waktu tertentu, atau data perubahan cuaca pada daerah tertentu. Data yang dipakai adalah data berupa Current Weather data (Data cuaca saat ini) dan 5 Day / 3 hour Weather Forecast (Ramalan cuaca setiap 3 jam selama 5 hari). API ini akan mengembalikan data dalam format JSON, sehingga untuk memudahkan pembuatan program digunakan juga package org.json.

# Struktur Package Program

```

Weather-forecast
├─ src
|   ├─ Main.java
|   ├─ AppUI.java
|   ├─ json-20180130.jar (Untuk mengelola json)
|   └─ weatherpack
|       ├─ WeatherRetriever.java
|       ├─ ForecastRetriever.java
|       ├─ city.list.json
|       └─ CityFinder.java
└─ README.md

```

Struktur package final adalah sebagai berikut. Package weatherpack berisi class-class yang diperlukan untuk mengambil data dari OpenWeatherMap API, seperti data cuaca, data ramalan cuaca, dan mesin pencari kota. Selanjutnya untuk Graphic User Interface sudah tercakup pada AppUI.java sehingga tidak perlu dibuat package. Main.java berfungsi untuk memanggil AppUI.

# Checklist:

### Hal yang perlu dilakukan:

Akan dikerjakan:
- [ ] Membuat dokumen sesuai dengan:
  - [x] GoogleStyle
  - [x] JavaDoc
  - [ ] JUnit
  - [x] JDepend

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

### File yang dikerjakan

Sudah:
- CityFinder.java
- WeatherRetriever.java
- ForecastRetriever.java
- weatherUi.java

Belum:
- Main.java

Sedang dikerjakan:

# How to compile

TBD

# How to run

TBD

# How to use

TBD
