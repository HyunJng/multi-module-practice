package org.multimodule.bank.common

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.ResponseEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null,
    val error: Error? = null
) {
    companion object {
        fun <T> success(
            data: T,
            message: String = "Success"
        ): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.ok(ApiResponse(true, message, data))
        }

        fun <T> error(
            message: String,
            errorCode: String? = null,
            details: Any? = null,
            path: String? = null
        ): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.badRequest().body(
                ApiResponse(false, message, error = Error(errorCode, details, path))
            )
        }

        fun <T> exceptionError(
            message: String,
            errorCode: String? = null,
            details: Any? = null,
            path: String? = null
        ): ApiResponse<T> {
            return ApiResponse(false, message, error = Error(errorCode, details, path))
        }
    }
}

data class Error(
    val code: String? = null,
    val details: Any? = null,
    val path: String? = null
)