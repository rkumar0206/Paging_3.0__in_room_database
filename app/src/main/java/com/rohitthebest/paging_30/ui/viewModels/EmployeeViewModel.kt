package com.rohitthebest.paging_30.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rohitthebest.paging_30.repository.EmployeeRepository
import com.rohitthebest.paging_30.roomDB.entity.Employee
import kotlinx.coroutines.launch

class EmployeeViewModel @ViewModelInject constructor(
    val repository: EmployeeRepository
) : ViewModel() {

    fun insertEmployee(employee: Employee) = viewModelScope.launch {

        repository.insert(employee)
    }

    fun deleteEmployee(employee: Employee) = viewModelScope.launch {

        repository.delete(employee)
    }

    fun updateEmployee(employee: Employee) = viewModelScope.launch {

        repository.update(employee)
    }

    val employeeList = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            initialLoadSize = 100            //should be multiple of pageSize
        )
    ) {
        repository.getEmployeeList()
    }.flow

}