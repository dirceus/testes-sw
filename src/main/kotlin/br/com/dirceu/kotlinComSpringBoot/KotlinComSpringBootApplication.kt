package br.com.dirceu.kotlinComSpringBoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinComSpringBootApplication

fun main(args: Array<String>) {
	runApplication<KotlinComSpringBootApplication>(*args)
}
