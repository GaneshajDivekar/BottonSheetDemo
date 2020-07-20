package com.app.bubbledemoapp.data.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.bubbledemoapp.data.room.InterfaceDao
import com.app.bubbledemoapp.model.db.LoginDetailsEntity
import com.app.bubbledemoapp.data.room.dbHelper.DBUtils

@Database(
    entities = arrayOf(LoginDetailsEntity::class),
    version = DBUtils.DB_VERSION, exportSchema = false
)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun interfaceDao(): InterfaceDao

    companion object {


        private var INSTANCE: DatabaseHelper? = null

        fun getDatabase(context: Context): DatabaseHelper {
            if (INSTANCE == null) {
                synchronized(DatabaseHelper::class.java) {
                    if (INSTANCE == null) {
                        //Log.i(TAG, "getDatabase: ");
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseHelper::class.java, DBUtils.DATABASE_NAME
                        )
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this codelab.
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            //                            .addCallback(callback)
                            .build()
                    }
                }
            }
            return this.INSTANCE!!
        }
    }


}
