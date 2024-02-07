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


class ViewDriversActivity : AppCompatActivity(), OnDriverClickListener {

    val vm: ViewDriversViewModel by viewModel<ViewDriversViewModel>()
    lateinit var binding: ActivityViewDriversBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDriversBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DriversAdapter(mutableListOf(), this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        vm.drivers.observe(this, { drivers ->
            adapter.updateDrivers(drivers)
            adapter.notifyDataSetChanged()
        })
    }
    override fun onDriverClick(driver: DriverInfo, position: Int) {
        binding.recyclerView.smoothScrollToPosition((position + 1) %
                (binding.recyclerView.adapter?.itemCount ?: 1))
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ViewDriversActivity::class.java))
        }
    }
}