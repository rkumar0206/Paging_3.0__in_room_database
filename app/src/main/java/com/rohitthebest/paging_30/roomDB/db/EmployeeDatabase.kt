package com.rohitthebest.paging_30.roomDB.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rohitthebest.paging_30.roomDB.dao.EmployeeDao
import com.rohitthebest.paging_30.roomDB.entity.Employee

@Database(entities = [Employee::class], version = 3)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun getEmployeeDao(): EmployeeDao
}