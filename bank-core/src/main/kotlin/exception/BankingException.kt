package org.multimodule.bank.core.exception

abstract class BankingException (
    message: String?,
    cause: Throwable? = null
) : RuntimeException(message, cause)

class AccountNotFoundException(
    accountNumber: String
) : BankingException("Account ${accountNumber} not found")