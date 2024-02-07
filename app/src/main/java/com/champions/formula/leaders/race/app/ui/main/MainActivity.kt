package com.champions.formula.leaders.race.app.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.champions.formula.leaders.race.app.data.DriverInfo
import com.champions.formula.leaders.race.app.databinding.ActivityMainBinding
import com.champions.formula.leaders.race.app.ui.demonstration.DriversAdapter
import com.champions.formula.leaders.race.app.ui.demonstration.ViewDriversActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainViewTopList.setOnClickListener {
            ViewDriversActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
