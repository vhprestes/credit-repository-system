package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
//    para ter acesso ao BD precisa injetar aqui o repository
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
        }


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit : Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Você não tem essa permissão. Contate o admin")
    }
}