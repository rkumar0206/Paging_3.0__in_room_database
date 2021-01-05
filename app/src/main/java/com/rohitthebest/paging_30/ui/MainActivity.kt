package com.rohitthebest.paging_30.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.filter
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohitthebest.paging_30.adapters.EmployeeAdapter
import com.rohitthebest.paging_30.databinding.ActivityMainBinding
import com.rohitthebest.paging_30.roomDB.entity.Employee
import com.rohitthebest.paging_30.ui.viewModels.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.random.Random

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: EmployeeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapter = EmployeeAdapter()

        setUpRecyclerView()
        observeEmployeeList()

        //insertToDatabase()

        binding.insertFAB.setOnClickListener {

            val random = Random.nextInt(10, 50000)

            val employee = Employee(

                "FirstName $random",
                random + 1,
                "Designation $random",
                "Department $random",
                "Not_Married"
            )

            viewModel.insertEmployee(employee)

            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show()
        }

    }

    private fun insertToDatabase() {

        for (i in 1..100) {

            val employee = Employee(
                "FirstName $i",
                i + 1,
                "Designation $i",
                "Department $i",
                "Not_Married"
            )

            viewModel.insertEmployee(employee)
        }

        Log.i(TAG, "insertToDatabase: Inserted")
    }

    private fun observeEmployeeList() {

        Log.i(TAG, "observeEmployeeList: ")

        lifecycleScope.launch {

            viewModel.employeeList.collect {

                val list = it.filter { emp ->

                    emp.empAge == 12
                }

                mAdapter.submitData(it)

/*
                mAdapter.loadStateFlow.collectLatest {

                }
*/
            }
        }
    }

    private fun setUpRecyclerView() {

        Log.i(TAG, "setUpRecyclerView: ")

        try {

            binding.employeeRV.apply {

                setHasFixedSize(true)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(applicationContext)
            }

        } catch (e: Exception) {

            e.printStackTrace()
        }

    }

}