package com.champions.formula.leaders.race.app.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.databinding.ActivitySplashBinding
import com.champions.formula.leaders.race.app.ui.base.BaseActivity
import com.champions.formula.leaders.race.app.ui.main.MainActivity
import com.champions.formula.leaders.race.app.ui.main.MainViewModel

class SplashActivity: BaseActivity<SplashViewModel>(R.layout.activity_main, SplashViewModel::class){
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    override fun setupViews() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.postDelayed({ MainActivity.start(this) }, 1000)
    }
}

