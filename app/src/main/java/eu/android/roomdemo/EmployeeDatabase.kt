package eu.android.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EmployeeEntity::class],version = 1)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {

        fun getInstance(context: Context): EmployeeDatabase {
                return Room.databaseBuilder(
                    context,
                    EmployeeDatabase::class.java,
                    "employee_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            }
    }

}