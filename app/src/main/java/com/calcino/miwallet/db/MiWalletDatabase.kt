package com.calcino.miwallet.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.calcino.miwallet.Constants.DataBase.CURRENT_VERSION
import com.calcino.miwallet.Constants.DataBase.DB_NAME
import com.calcino.miwallet.db.dao.AccountDao
import com.calcino.miwallet.db.entity.Account

@Database(entities = [Account::class],version = CURRENT_VERSION,exportSchema = false)
abstract class MiWalletDatabase: RoomDatabase() {

    abstract fun accountDao(): AccountDao

    companion object{
        private var INSTANCE: MiWalletDatabase? = null

        private val lock = Any()

        fun getDatabase(context: Context): MiWalletDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, MiWalletDatabase::class.java, DB_NAME)
                        .addMigrations()
                        .enableMultiInstanceInvalidation()
                        .addCallback(CALLBACK)
                        .build()
                }
                return INSTANCE as MiWalletDatabase
            }
        }
        private val CALLBACK = object : RoomDatabase.Callback() {
        }
    }

}
