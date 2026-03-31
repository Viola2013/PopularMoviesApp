package com.viola2013.popularmoviesapp

import android.content.Context
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeHelper {

    @Throws(ParseException::class)
    private fun getFormattedDate(date: String, format: String): Date? {
        val simpleDateFormat = SimpleDateFormat(format, Locale.US)
        return simpleDateFormat.parse(date)
    }

    @JvmStatic
    @Throws(ParseException::class)
    fun getLocalizedDate(context: Context, date: String, format: String): String {
        val dateFormat = android.text.format.DateFormat.getDateFormat(context)
        val formattedDate = getFormattedDate(date, format)
        return if (formattedDate != null) {
            dateFormat.format(formattedDate)
        } else {
            date
        }
    }
}
