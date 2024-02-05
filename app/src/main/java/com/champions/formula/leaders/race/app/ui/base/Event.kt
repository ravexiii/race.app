package com.champions.formula.leaders.race.app.ui.base

sealed class Event

sealed class SplashEvent : Event() {
    class GoToLogin : SplashEvent()
    class GoToMain : SplashEvent()
}