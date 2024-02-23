package com.champions.formula.leaders.race.app.repo

import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.network.ApiClient
import com.champions.formula.leaders.race.app.network.FormulaApi
import com.champions.formula.leaders.race.app.utils.Constants
import javax.sql.DataSource

class FormulaRepo {

    private var api = ApiClient.create(FormulaApi::class.java)

    suspend fun getListDrivers(): List<DriverModel>{
        return api.getDrivers()
    }
}