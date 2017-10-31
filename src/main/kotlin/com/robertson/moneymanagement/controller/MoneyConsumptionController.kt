package com.robertson.moneymanagement.controller

import com.robertson.moneymanagement.entity.MoneyConsumptionRecord
import com.robertson.moneymanagement.repository.MoneyConsumptionRecordRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

@RestController
@RequestMapping("/money")
class MoneyConsumptionController(val moneyConsumptionRecordRepository: MoneyConsumptionRecordRepository) {

    @GetMapping
    fun getAll() = ResponseEntity.ok(moneyConsumptionRecordRepository.findAll().toList())


    @PostMapping
    fun add(@RequestBody moneyConsumptionRecord: MoneyConsumptionRecord) =
            ResponseEntity.ok(moneyConsumptionRecordRepository.save(moneyConsumptionRecord))


    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): ResponseEntity<MoneyConsumptionRecord> {
        val record = moneyConsumptionRecordRepository.findOne(id)
        return if (record == null) ResponseEntity.noContent().build() else ResponseEntity.ok(record)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = ResponseEntity.ok(moneyConsumptionRecordRepository.delete(id))

    @GetMapping("/stats/monthly")
    fun statistics(): ResponseEntity<MutableList<Triple<String, Int, BigDecimal>>>? {
        val date = LocalDate.now()
        val recordsInCurrentMonth = moneyConsumptionRecordRepository.findByCreationDateIsBetween(date.withDayOfMonth(1), date.withDayOfMonth(date.lengthOfMonth()))
        val sum = recordsInCurrentMonth.sumBy { record -> record.sum!! }
        val statistics: MutableList<Triple<String, Int, BigDecimal>> = mutableListOf()

        val monthlyConsumptionForEachConsumptionType: MutableMap<String, Int> = mutableMapOf()
        recordsInCurrentMonth.forEach { record ->
            val consumptionType = record.consumptionType!!.value
            if (monthlyConsumptionForEachConsumptionType.containsKey(consumptionType))
                monthlyConsumptionForEachConsumptionType.put(consumptionType!!, monthlyConsumptionForEachConsumptionType.getValue(consumptionType) + record.sum!!)
            else {
                monthlyConsumptionForEachConsumptionType.put(consumptionType!!, record.sum!!)

            }
        }
        for (entry in monthlyConsumptionForEachConsumptionType) {
            statistics.add(Triple(entry.key, entry.value, BigDecimal(entry.value.toDouble() / sum * 100).setScale(2, RoundingMode.HALF_EVEN)))
        }

        return ResponseEntity.ok(statistics)
    }

}