package me.dio.creditapplicationsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address (
   @Column(nullable = false) var zipcode: String = "vazio",
   @Column(nullable = false) var street: String = "vazio"
)
