package com.robertson.moneymanagement.controller

import com.robertson.moneymanagement.entity.MoneyConsumptionRecord
import com.robertson.moneymanagement.repository.MoneyConsumptionRecordRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/money")
class MoneyConsumptionController(val moneyConsumptionRecordRepository: MoneyConsumptionRecordRepository) {

    @GetMapping
    fun getAll(): ResponseEntity<List<MoneyConsumptionRecord>> = ResponseEntity.ok(moneyConsumptionRecordRepository.findAll().toList())


    @PostMapping
    fun add(@RequestBody moneyConsumptionRecord: MoneyConsumptionRecord): ResponseEntity<MoneyConsumptionRecord>
            = ResponseEntity.ok(moneyConsumptionRecordRepository.save(moneyConsumptionRecord))


    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): ResponseEntity<MoneyConsumptionRecord> {
        val record = moneyConsumptionRecordRepository.findOne(id)
        return if (record == null) ResponseEntity.noContent().build() else ResponseEntity.ok(record)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = ResponseEntity.ok(moneyConsumptionRecordRepository.delete(id))


}