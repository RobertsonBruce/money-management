package com.robertson.moneymanagement.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ConsumptionType(
        @Id
        var value: String)