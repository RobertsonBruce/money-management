package com.robertson.moneymanagement.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
class MoneyConsumptionRecord {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var description: String = ""
    @OneToOne
    lateinit var consumptionType: ConsumptionType
    var sum: Int = 0
    var creationDate: LocalDate = LocalDate.now()
}
