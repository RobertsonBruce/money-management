package com.robertson.moneymanagement.entity

import com.robertson.moneymanagement.ConsumptionType
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class MoneyConsumptionRecord(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = 0,
        var description: String? = "",
        @Enumerated(EnumType.STRING)
        var consumptionType: ConsumptionType? = null,
        var sum: Int? = null,
        var creationDate: LocalDateTime? = LocalDateTime.now()
)
