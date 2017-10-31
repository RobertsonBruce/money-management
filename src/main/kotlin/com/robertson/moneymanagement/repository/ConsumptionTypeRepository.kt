package com.robertson.moneymanagement.repository

import com.robertson.moneymanagement.entity.ConsumptionType
import org.springframework.data.repository.CrudRepository

interface ConsumptionTypeRepository : CrudRepository<ConsumptionType, String>