package com.champions.formula.leaders.race.app.ui.demonstration


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.champions.formula.leaders.race.app.domain.DriverInfo
import com.champions.formula.leaders.race.app.databinding.ItemDriverBinding

class DriversAdapter(private var drivers: MutableList<DriverInfo>, private val listener: OnDriverClickListener) :
    RecyclerView.Adapter<DriversAdapter.DriverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding = ItemDriverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.bind(drivers[position])
    }

    override fun getItemCount(): Int = drivers.size

    inner class DriverViewHolder(private val binding: ItemDriverBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(driver: DriverInfo) {
            binding.apply {
                tvTitleView.text = "${driver.name}"
                driverImageView.setImageResource(driver.image)
                teamTextView.text = "Team: ${driver.lastCurrentTeam}"
                countryTextView.text = "Country: ${driver.country}"
                podiumsTextView.text = "Podiums: ${driver.podiums}"
                grandsTextView.text = "Grands prix entered: ${driver.grandsPrixEntered}"
                championshipTextView.text = "World Championships: ${driver.worldChampionships}"
                racesWonTextView.text = "Races Won: ${driver.racesWon}"
                dateOfBirthTextView.text = "Races Won: ${driver.dateOfBirth}"
                placeOfBirthTextView.text = "Races Won: ${driver.placeOfBirth}"
            }
            binding.nextItem.setOnClickListener {
                listener.onDriverClick(driver, getAbsoluteAdapterPosition())
            }
        }
    }

    fun updateDrivers(newDrivers: List<DriverInfo>) {
        drivers.clear()
        drivers.addAll(newDrivers)
        notifyDataSetChanged()
    }

}

interface OnDriverClickListener {
    fun onDriverClick(driver: DriverInfo, position: Int)
}