package org.multimodule.bank.exception

import org.multimodule.bank.common.ApiResponse
import org.multimodule.bank.core.exception.AccountNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(AccountNotFoundException::class)
    fun handleAccountNotFoundException(
        exception: AccountNotFoundException,
        request: WebRequest
    ): ResponseEntity<ApiResponse<Nothing>> {
        log.warn("Account not found: ${exception.message}", exception)
        val response = ApiResponse.exceptionError<Nothing>(
            message = exception.message ?: "Account not found",
            errorCode = "Account Not Found",
            path = getPath(request)
        )
        return ResponseEntity.status(404).body(response)
    }

    private fun getPath(request: WebRequest): String? {
        return request.getDescription(false).removePrefix("uri=").takeIf { it.isNotBlank() }
    }
}