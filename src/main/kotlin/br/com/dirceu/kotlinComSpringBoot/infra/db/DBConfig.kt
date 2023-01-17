package br.com.dirceu.kotlinComSpringBoot.infra.db

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["br.com.dirceu.kotlinComSpringBoot.infra.db.entities", "br.com.dirceu.kotlinComSpringBoot.infra.db.converters"])
@EnableJpaRepositories(basePackages = ["br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios"])
class DBConfig
