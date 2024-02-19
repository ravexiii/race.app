package com.champions.formula.leaders.race.app.ui.driver

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.champions.formula.leaders.race.app.R
import com.champions.formula.leaders.race.app.retrofit.DriverModel
import com.champions.formula.leaders.race.app.ui.demonstration.DriversAdapter
import com.squareup.picasso.Picasso


class DriverAdapter : ListAdapter<DriverModel, DriverAdapter.DriverViewHolder>(Comparator()) {

    class DriverViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var driverAvatar : ImageView = view.findViewById(R.id.avatar)
        var driverFirstName : TextView = view.findViewById(R.id.driverName)
        var driverLastName : TextView = view.findViewById(R.id.driverLastName)
        var driverNumber : TextView = view.findViewById(R.id.driverNumer)
        var driverTeamName : TextView = view.findViewById(R.id.driverTeamName)

        fun bind(driverModel: DriverModel){
            driverFirstName.text = driverModel.first_name
            driverLastName.text = driverModel.last_name
            driverNumber.text = driverModel.driver_number.toString()
            driverTeamName.text = driverModel.team_name
            Picasso.get().load(driverModel.headshot_url).into(driverAvatar)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DriverViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_driver2, parent, false)
        return DriverViewHolder(view)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    class Comparator : DiffUtil.ItemCallback<DriverModel>() {
        override fun areItemsTheSame(oldItem: DriverModel, newItem: DriverModel): Boolean {
            return oldItem.headshot_url == oldItem.headshot_url
        }

        override fun areContentsTheSame(oldItem: DriverModel, newItem: DriverModel): Boolean {
            return oldItem == newItem
        }
    }
}

