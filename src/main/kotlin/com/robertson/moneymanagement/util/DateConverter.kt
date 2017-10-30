package com.robertson.moneymanagement.util

import org.jetbrains.annotations.Nullable
import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class DateConverter : AttributeConverter<LocalDateTime, Timestamp> {
    override fun convertToDatabaseColumn(@Nullable date: LocalDateTime?): Timestamp? {
        return if (date == null) null else Timestamp.valueOf(date)
    }

    override fun convertToEntityAttribute(timestamp: Timestamp?): LocalDateTime? {
        return if (timestamp == null) null else timestamp.toLocalDateTime()
    }
}