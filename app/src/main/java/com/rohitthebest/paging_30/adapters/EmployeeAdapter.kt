package com.rohitthebest.paging_30.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rohitthebest.paging_30.R
import com.rohitthebest.paging_30.databinding.EmployeeRvLayoutBinding
import com.rohitthebest.paging_30.roomDB.entity.Employee

class EmployeeAdapter :
    PagingDataAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(DiffUtilCallback()) {

    inner class EmployeeViewHolder(val binding: EmployeeRvLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Employee>() {


        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =

        EmployeeViewHolder(
            EmployeeRvLayoutBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.employee_rv_layout, parent, false
                )
            )
        )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

        holder.binding.apply {

            getItem(position)?.let {

                empNameTV.text = it.empName
                empAgeTV.text = "Age : ${it.empAge}"
                empDeptTV.text = it.empDepartment
                empDesignationTV.text = it.empDesignation
                empIDTV.text = "ID : ${it.id}"
            }
        }
    }

}