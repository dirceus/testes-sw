package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.RelatorioProducaoDiariaEntity
import org.springframework.data.jpa.repository.JpaRepository


interface RelatorioProducaoDiariaJpaRepository: JpaRepository<RelatorioProducaoDiariaEntity, Long>{



}

