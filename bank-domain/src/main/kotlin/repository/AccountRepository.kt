package org.multimodule.bank.domain.repository

import org.multimodule.bank.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByAccountNumber(accountNumber: String): Account?
}