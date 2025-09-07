package org.multimodule.bank.event.listener

import org.multimodule.bank.domain.event.AccountCreatedEvent
import org.multimodule.bank.domain.event.TransactionCreatedEvent
import org.multimodule.bank.domain.repository.AccountReadViewRepository
import org.multimodule.bank.domain.repository.AccountRepository
import org.multimodule.bank.domain.repository.TransactionReadViewRepository
import org.multimodule.bank.domain.repository.TransactionRepository
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class EventConsumer (
    private val accountReadRepository: AccountReadViewRepository,
    private val transactionReadViewRepository: TransactionReadViewRepository,
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository
) {
    private val log = LoggerFactory.getLogger(EventConsumer::class.java)

    @EventListener
    @Async("taskExecutor")
    fun handleAccountCreated(event: AccountCreatedEvent) {

    }

    @EventListener
    @Async("taskExecutor")
    fun handleTransactionCreated(event: TransactionCreatedEvent) {

    }
}