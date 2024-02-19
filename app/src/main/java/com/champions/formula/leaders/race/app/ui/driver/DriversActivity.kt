package com.champions.formula.leaders.race.app.ui.driver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.databinding.ActivityDriversBinding
import com.champions.formula.leaders.race.app.retrofit.ApiService
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.android.get
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DriversActivity : AppCompatActivity() {
    lateinit var binding: ActivityDriversBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DriverAdapter
    lateinit var apiService : ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriversBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()//ресайклер
        createRetrofit()//Создание инстанции Ретрофита + okhttpClient

        getAllDrivers()
//        binding.btRep.setOnClickListener {
//            getAllDrivers()
//        }

    }

    fun setRecycler(){
        adapter = DriverAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun createRetrofit(){

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openf1.org/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getDriver(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val drivers = apiService.getDriver()
                runOnUiThread {
                    // Проверяем, что список водителей не пустой, прежде чем отображать информацию
                    if (drivers.isNotEmpty()) {
                        val driver = drivers[0] // Берем первого водителя из списка

//                        Picasso.get().load(driver.headshot_url).into(binding.avatar)
//                        binding.driverNameTV.text = driver.first_name
                    }
                }
            } catch (e: Exception) {
                // В случае возникновения исключения, выводим сообщение об ошибке
                runOnUiThread {
                    Toast.makeText(
                        this@DriversActivity,
                        "Ошибочка: ${e.message}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    fun getAllDrivers(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val driversList = apiService.getDrivers()
                runOnUiThread {
                    binding.apply {
                        adapter.submitList(driversList)
                    }

                }
            } catch (e: Exception) {
                // В случае возникновения исключения, выводим сообщение об ошибке
                runOnUiThread {
                    Toast.makeText(
                        this@DriversActivity,
                        "Ошибочка: ${e.message}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }



}
