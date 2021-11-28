package br.com.manageruser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ManagerUserApplication

fun main(args: Array<String>) {
	runApplication<ManagerUserApplication>(*args)
}
