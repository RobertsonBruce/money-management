package com.robertson.moneymanagement.util

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class DateConverter : AttributeConverter<LocalDateTime, Timestamp> {
    override fun convertToDatabaseColumn(date: LocalDateTime?) = date?.let { Timestamp.valueOf(it) }

    override fun convertToEntityAttribute(timestamp: Timestamp?) = timestamp?.toLocalDateTime()
}