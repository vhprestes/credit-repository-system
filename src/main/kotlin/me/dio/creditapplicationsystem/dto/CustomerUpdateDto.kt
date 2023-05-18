package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
//    val cpf: String,
    val income: BigDecimal,
//    val email: String,
//    val password: String,
    val zipcode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipcode = this.zipcode
        customer.address.street = this.street

        return customer

    }

}
