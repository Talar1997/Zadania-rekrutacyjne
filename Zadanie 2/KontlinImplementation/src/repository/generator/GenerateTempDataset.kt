package repository.generator

import entities.Temp
import java.sql.Timestamp
import java.util.*
import kotlin.random.Random

class GenerateTempDataset {
    companion object{
        fun generate(days: Int): List<Temp> {
            val minutesInDay = 1440
            val totalMeasurements = days * minutesInDay
            var currentTimestamp = Timestamp(System.currentTimeMillis())

            val tempList = mutableListOf<Temp>()
            for(i in 1..totalMeasurements){
                val measurement = generateMeasurementBasedOnTime(currentTimestamp)
                currentTimestamp = addValueToTimestamp(currentTimestamp, 60)
                tempList.add(Temp(i, currentTimestamp, measurement))
            }

            return tempList
        }

        private fun generateMeasurementBasedOnTime(time: Timestamp): Double?{
            val calendar = Calendar.getInstance()
            calendar.time = time
            val hours = calendar.get(Calendar.HOUR_OF_DAY)

            return if(hours !in 4..19) null
            else Random.nextDouble()
        }

        private fun addValueToTimestamp(timestamp: Timestamp, seconds: Int): Timestamp{
            return Timestamp(timestamp.time + (seconds * 1000L))
        }
    }
}