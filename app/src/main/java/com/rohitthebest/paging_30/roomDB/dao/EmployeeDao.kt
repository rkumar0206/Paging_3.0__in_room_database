package com.rohitthebest.paging_30.roomDB.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.rohitthebest.paging_30.roomDB.entity.Employee

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(employee: Employee): Long

    @Delete
    suspend fun delete(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Query("SELECT * FROM employee_table ORDER BY id DESC")
    fun getAllEmployeeList(): PagingSource<Int, Employee>
}