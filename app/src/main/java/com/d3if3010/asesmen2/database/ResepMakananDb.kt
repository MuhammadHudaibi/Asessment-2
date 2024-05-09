package com.d3if3010.asesmen2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.d3if3010.asesmen2.model.ResepMakanan

@Database(entities = [ResepMakanan::class], version = 1, exportSchema = false)
abstract class ResepMakananDb : RoomDatabase() {

    abstract val dao: ResepMakananDao

    companion object{

        @Volatile
        private var INSTACE: ResepMakananDb? = null

        fun getInstance(context: Context): ResepMakananDb {
            synchronized(this){
                var instance = INSTACE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ResepMakananDb::class.java,
                        "resepMakanan.db"
                    ).build()
                    INSTACE = instance
                }
                return instance
            }
        }
    }
}