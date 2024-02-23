package com.champions.formula.leaders.race.app.ui.demonstration


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.champions.formula.leaders.race.app.databinding.ItemDriverBinding
import com.champions.formula.leaders.race.app.domain.DriverModel
import com.squareup.picasso.Picasso

class DriversAdapter(private var drivers: MutableList<DriverModel>, private val listener: OnDriverClickListener) :
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
        fun bind(driver: DriverModel) {
            binding.apply {
                tvTitleView.text = "${driver.firstName} ${driver.lastName}"
                driverImageView.setImageURI(driver.image?.toUri())
                teamTextView.text = "Team: ${driver.lastCurrentTeam}"
                countryTextView.text = "Country: ${driver.country_code}"



            //    podiumsTextView.text = "Podiums: ${driver.podiums}"
//                grandsTextView.text = "Grands prix entered: ${driver.grandsPrixEntered}"
//                championshipTextView.text = "World Championships: ${driver.worldChampionships}"
//                racesWonTextView.text = "Races Won: ${driver.racesWon}"
//                dateOfBirthTextView.text = "Races Won: ${driver.dateOfBirth}"
//                placeOfBirthTextView.text = "Races Won: ${driver.placeOfBirth}"
                Picasso
                    .get()
                    .load(driver.image)
                    .into(driverImageView)
            }
            binding.nextItem.setOnClickListener {
                listener.onDriverClick(driver, getAbsoluteAdapterPosition())
            }
        }
    }

    fun updateDrivers(newDrivers: List<DriverModel>?) {
        drivers.clear()
        drivers.addAll(newDrivers?: listOf())
        notifyItemRangeChanged(0, drivers.size)
    }
}

interface OnDriverClickListener {
    fun onDriverClick(driver: DriverModel, position: Int)
}