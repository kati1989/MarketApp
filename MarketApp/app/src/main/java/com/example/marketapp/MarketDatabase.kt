package com.example.marketapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Adatbazis inicializalo osztaly mely segitsegevel elerjuk a Profile Restaurant
 * illetve ProfileRestaurantRef(favorites) entitasokat
 */
@Database(entities = arrayOf(ProfileEntity::class), version = 1, exportSchema = false)
abstract class MarketDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDAO // a profileDao ban talalhatoak a profile tabla muveletei

    companion object {
        //singleton patternel csak egyszer hozzuk letre az adatbazis osztalyunkat
        @Volatile
        private var INSTANCE: MarketDatabase? = null

        open fun getInstance(context: Context): MarketDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MarketDatabase::class.java, "fooddaabase.db") //megadjuk a nevet
                        .createFromAsset("database/sqlite3.db") // megadjuk hogy melyik filebol epitse az adatbazist
                        .allowMainThreadQueries() // lehessen a main szallon adatbazis lekerdezeseket futtatni
                        .build()
            }
            return INSTANCE
        }
    }


}

