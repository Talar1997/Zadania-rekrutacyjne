package logic.sunriseAndSunset

import entities.SunriseSunset
import entities.Temp

class SunriseAndSunsetFindEasiest : SunriseAndSunsetStrategy {
    override fun find(temps: List<Temp>): List<SunriseSunset> {
        return temps
            .filter { temp -> temp.measurement != null }
            .groupBy { temp -> temp.getSimplifiedDate() }
            .values
            .map(this::createSunriseSunsetFromTempList)
            .sortedBy { sunriseSunset -> sunriseSunset.day.time }
    }

    private fun createSunriseSunsetFromTempList(temps: List<Temp>): SunriseSunset {
        val sunrise = temps[0]
        val sunset = temps[temps.size - 1]
        return SunriseSunset(sunrise.time, sunrise, sunset)
    }
}