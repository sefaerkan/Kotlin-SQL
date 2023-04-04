package com.example.btk15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //try-catch

        try {
            //Veritabanı Oluşturma
            val veritabani =this.openOrCreateDatabase("Urunler", MODE_PRIVATE,null)
            //Tablo Oluşturma
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")
            //Veri Grişi
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Ayakabi',100)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Elbise',150)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Tshirt',50)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Atki',200)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Bere',20)")
            //Veri Silme
            //veritabani.execSQL("DELETE FROM urunler WHERE id=5")
            //Veri Güncelleme
            //veritabani.execSQL("UPDATE urunler SET fiyat = 250 WHERE isim = 'Elbise'")
            //veritabani.execSQL("UPDATE urunler SET isim='Ayakkab' WHERE id=1")

            //Veri Filtreleme
            val cursor = veritabani.rawQuery("SELECT * FROM urunler",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim = 'Bere'",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id= 3",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%e'",null) //A% = a ile başlayan

            //Kolonları Seçme
            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")
            //Yazdırma
            while(cursor.moveToNext()){
                println("ID: ${cursor.getInt(idColumnIndex)}")
                println("ISIM: ${cursor.getString(isimColumnIndex)}")
                println("FIYAT: ${cursor.getInt(fiyatColumnIndex)}")
            }
            cursor.close()

        } catch(e : Exception) {
            e.printStackTrace()
        }
    }
}