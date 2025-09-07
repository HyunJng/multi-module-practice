package org.multimodule.bank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["org.multimodule.bank"])
class BankApiApplication

fun main(args: Array<String>) {
    runApplication<BankApiApplication>(*args)
}
