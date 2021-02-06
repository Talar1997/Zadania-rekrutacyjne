package view

import entities.SunriseSunset
import utils.TimestampFormatter

class ConsoleSunriseSunsetView(private val dataset: List<SunriseSunset>) : View {

    override fun display() {
        println("Dzień \t | Wschód \t | Zachód")

        for (sunriseSunset in dataset) {
            val simplifiedDate = TimestampFormatter.format(sunriseSunset.day)
            println("$simplifiedDate | ${sunriseSunset.sunrise.time} | ${sunriseSunset.sunset.time}")
        }
    }
}