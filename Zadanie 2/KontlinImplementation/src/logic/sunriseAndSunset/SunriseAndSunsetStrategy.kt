package logic.sunriseAndSunset

import entities.SunriseSunset
import entities.Temp

interface SunriseAndSunsetStrategy {
    fun find(temps: List<Temp>): List<SunriseSunset>
}