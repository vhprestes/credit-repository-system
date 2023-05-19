package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.enummeration.Status
import java.math.BigDecimal
import java.util.*

data class Creditview(
//    o que vamos retornar pra view
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal?
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income
    )
}
