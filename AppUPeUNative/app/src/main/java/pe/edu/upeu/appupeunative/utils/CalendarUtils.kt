package pe.edu.upeu.appupeunative.utils

import java.util.*

object CalendarUtils{
    fun getCurrentDateTime():Date{
        return Calendar.getInstance().time
    }
    fun getCurrentDateInMillis(): Long{
        return Calendar.getInstance().timeInMillis
    }
}