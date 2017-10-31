package com.robertson.moneymanagement.repository

import com.robertson.moneymanagement.entity.MoneyConsumptionRecord
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface MoneyConsumptionRecordRepository : CrudRepository<MoneyConsumptionRecord, Long> {
    fun findByCreationDateIsBetween(@Param("from") from: LocalDate, @Param("to") to: LocalDate): Array<MoneyConsumptionRecord>
}

