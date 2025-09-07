package org.multimodule.bank.domain.event

import org.multimodule.bank.domain.entity.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

interface DomainEvent {
    val occurredOn: LocalDateTime
    val eventId: String
}

data class AccountCreatedEvent(
    val accountId: Long,
    val accountNumber: String,
    val accountHolderName: String,
    val initialBalance: BigDecimal,
    override val occurredOn: LocalDateTime = LocalDateTime.now(),
    override val eventId: String = UUID.randomUUID().toString()
) : DomainEvent

data class TransactionCreatedEvent(
    val transactionId: Long,
    val accountId: Long,
    val type: TransactionType,
    val amount: BigDecimal,
    val description: String,
    val balanceAfter: BigDecimal,
    override val occurredOn: LocalDateTime = LocalDateTime.now(),
    override val eventId: String = UUID.randomUUID().toString()
) : DomainEvent