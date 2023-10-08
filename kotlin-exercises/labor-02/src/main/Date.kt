package main
import java.util.Calendar


data class Date (val year: Int = Calendar.YEAR,
                 val month: Int = Calendar.MONTH + 1,
                 val day: Int = Calendar.DAY_OF_MONTH) : Comparable<Date> {
                     companion object : Comparator<Date> {
                         override fun compare(o1: Date, o2: Date): Int {
                             if(o1.year != o2.year) {
                                 return o1.year - o2.year
                             }
                             if(o1.month != o2.month) {
                                 return o1.month - o2.month
                             }
                             return o1.day - o2.day
                         }
                     }

                     override fun compareTo(other: Date): Int {
                        return compare(this, other)
                     }
                 }

fun Date.isLeapYear() : Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

fun Date.isValid() : Boolean {
    if(year < 1) {
        return false
    }
    if(month < 1 || month > 12) {
        return false
    }

    val daysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if(isLeapYear()) 29 else 28
        else -> return false
    }

    return day in 1..daysInMonth
}
