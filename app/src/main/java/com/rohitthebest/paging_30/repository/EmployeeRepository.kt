package com.rohitthebest.paging_30.repository

import com.rohitthebest.paging_30.roomDB.dao.EmployeeDao
import com.rohitthebest.paging_30.roomDB.entity.Employee
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    val dao: EmployeeDao
) {

    suspend fun insert(employee: Employee) = dao.insert(employee)

    suspend fun delete(employee: Employee) = dao.delete(employee)

    suspend fun update(employee: Employee) = dao.update(employee)

    fun getEmployeeList() = dao.getAllEmployeeList()

}