package com.champions.formula.leaders.race.app.repo

import com.champions.formula.leaders.race.app.domain.DriverModel
import com.champions.formula.leaders.race.app.network.FormulaApi

class FormulaRepo(val formulaApi: FormulaApi) {
    suspend fun getListDrivers(): List<DriverModel>{
        return formulaApi.getDrivers()
    }
}