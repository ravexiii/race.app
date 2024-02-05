package com.champions.formula.leaders.race.app.ui.demonstration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.champions.formula.leaders.race.app.data.DriverInfo
import com.champions.formula.leaders.race.app.databinding.ActivityViewDriversBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewDriversActivity : AppCompatActivity() {

    private lateinit var vm: ViewDriversViewModel by viewModel<ViewDriversViewModel>()

    private lateinit var binding: ActivityViewDriversBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDriversBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = vm.preferenceHelper.getDriverInfoList() ?: emptyList()
        //initRecyclerView(list)
    }

    private fun initRecyclerView(driverList: List<DriverInfo>) {
        // Инициализация RecyclerView
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // Создание адаптера для RecyclerView
        val adapter = DriversAdapter(driverList)
        binding.recyclerView.adapter = adapter
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ViewDriversActivity::class.java))
        }
    }
}