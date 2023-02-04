package br.com.demo.infra.db

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["br.com.demo.infra.db.entities", "br.com.demo.infra.db.converters"])
@EnableJpaRepositories(basePackages = ["br.com.demo.infra.db.repositorios"])
class DBConfig
