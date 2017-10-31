package com.robertson.moneymanagement.util

import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class DateConverter : AttributeConverter<LocalDate, Date> {
    override fun convertToDatabaseColumn(date: LocalDate?) = date?.let { Date.valueOf(it) }

    override fun convertToEntityAttribute(date: Date?) = date?.toLocalDate()
}