package com.champions.formula.leaders.race.app.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.databinding.ActivityMainBinding
import com.champions.formula.leaders.race.app.ui.base.BaseActivity
import com.champions.formula.leaders.race.app.ui.demonstration.ViewDriversActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main, MainViewModel::class){

    lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    override fun setupViews() {
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
