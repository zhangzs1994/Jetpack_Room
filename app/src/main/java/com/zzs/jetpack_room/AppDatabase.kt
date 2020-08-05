package com.zzs.jetpack_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * @author:      ZhangZhiSheng
 * @date:        2020/7/15 0015 下午 4:08
 * @description:
 */
@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "data.db"
                ).allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return instance as AppDatabase
        }

        //给User表添加一个mobile字段
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE User " + " ADD COLUMN mobile TEXT")
            }
        }
    }
}