package com.robertson.moneymanagement.controller

import com.robertson.moneymanagement.entity.ConsumptionType
import com.robertson.moneymanagement.repository.ConsumptionTypeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/consumption-types")
class ConsumptionTypeController(val consumptionTypeRepository: ConsumptionTypeRepository) {
    @GetMapping
    fun getAll() = ResponseEntity.ok(consumptionTypeRepository.findAll().map { consumptionType -> consumptionType.value })

    @PostMapping
    fun add(@RequestBody name: String) = ResponseEntity.ok(consumptionTypeRepository.save(ConsumptionType(name)))

    @DeleteMapping("/{name}")
    fun delete(@PathVariable("name") name: String) = ResponseEntity.ok(consumptionTypeRepository.delete(name))

}