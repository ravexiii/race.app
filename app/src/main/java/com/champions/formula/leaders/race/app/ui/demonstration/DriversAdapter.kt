package com.champions.formula.leaders.race.app.ui.demonstration


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.data.DriverInfo
import com.champions.formula.leaders.race.app.databinding.ItemDriverBinding

class DriversAdapter(private val drivers: List<DriverInfo>) :
    RecyclerView.Adapter<DriversAdapter.DriverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding = ItemDriverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.bind(drivers[position])
    }

    override fun getItemCount(): Int = drivers.size

    class DriverViewHolder(private val binding: ItemDriverBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(driver: DriverInfo) {
            binding.apply {
                // Привязываем данные к элементам интерфейса
                teamTextView.text = "Team: ${driver.lastCurrentTeam}"
                countryTextView.text = "Country: ${driver.country}"
                podiumsTextView.text = "Podiums: ${driver.podiums}"

                // Добавьте другие элементы и изображения по вашему усмотрению
            }
        }
    }
}
