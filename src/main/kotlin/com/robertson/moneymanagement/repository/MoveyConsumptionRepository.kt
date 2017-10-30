package com.robertson.moneymanagement.repository

import com.robertson.moneymanagement.entity.MoneyConsumptionRecord
import org.springframework.data.repository.CrudRepository

interface MoneyConsumptionRecordRepository : CrudRepository<MoneyConsumptionRecord, Long>
