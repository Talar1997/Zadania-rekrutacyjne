package utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class TimestampFormatter {
    companion object{
        fun format(timestamp: Timestamp, pattern: String = "yyyy-MM-dd"): String {
            val date = Date(timestamp.time)
            return SimpleDateFormat(pattern).format(date)
        }
    }
}