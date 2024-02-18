package com.champions.formula.leaders.race.app.ui.demonstration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.domain.DriverInfo
import com.champions.formula.leaders.race.app.databinding.ActivityViewDriversBinding
import com.champions.formula.leaders.race.app.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewDriversActivity : BaseActivity<ViewDriversViewModel>(R.layout.activity_view_drivers, ViewDriversViewModel::class), OnDriverClickListener {

    val vm: ViewDriversViewModel by viewModel<ViewDriversViewModel>()
    lateinit var binding: ActivityViewDriversBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    override fun setupViews() {
        binding = ActivityViewDriversBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DriversAdapter(mutableListOf(), this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        vm.drivers.observe(this) { drivers ->
            adapter.updateDrivers(drivers)
        }
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