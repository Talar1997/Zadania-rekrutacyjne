package entities

import utils.TimestampFormatter
import java.sql.Timestamp

data class Temp(
    val id: Int,
    val time: Timestamp,
    val measurement: Double?
){
    fun getSimplifiedDate(): String {
        return TimestampFormatter.format(time)
    }
}