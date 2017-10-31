package com.robertson.moneymanagement.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ConsumptionType() {
    @Id
    lateinit var value: String

    constructor(value: String) : this() {
        this.value = value
    }
}