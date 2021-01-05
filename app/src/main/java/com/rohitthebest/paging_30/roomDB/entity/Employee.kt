package com.rohitthebest.paging_30.roomDB.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(

    val empName: String,
    val empAge: Int,
    val empDesignation: String,
    val empDepartment: String,
    val isEmpMarried: String? = "Not_Married",
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)