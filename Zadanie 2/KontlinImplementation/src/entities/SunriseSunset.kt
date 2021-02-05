package entities

import java.sql.Timestamp

data class SunriseSunset(val day: Timestamp, val sunrise: Temp, val sunset: Temp)