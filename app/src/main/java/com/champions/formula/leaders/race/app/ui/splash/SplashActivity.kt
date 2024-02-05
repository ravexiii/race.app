package com.champions.formula.leaders.race.app.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.champions.formula.leaders.race.app.databinding.ActivitySplashBinding
import com.champions.formula.leaders.race.app.ui.main.MainActivity

class SplashActivity: AppCompatActivity(){
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.postDelayed({ MainActivity.start(this) }, 3000)
    }
}

