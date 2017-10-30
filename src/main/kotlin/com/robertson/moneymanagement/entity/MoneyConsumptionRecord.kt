package com.robertson.moneymanagement.entity

import com.robertson.moneymanagement.ConsumptionType
import java.time.LocalDate
import javax.persistence.*

@Entity
class MoneyConsumptionRecord(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
        var description: String,
        @Enumerated(EnumType.STRING) var consumptionType: ConsumptionType?,
        var sum: Int,
        var creationDate: LocalDate
        ){
    private constructor(): this(null, "", null, 0, LocalDate.now())
}
