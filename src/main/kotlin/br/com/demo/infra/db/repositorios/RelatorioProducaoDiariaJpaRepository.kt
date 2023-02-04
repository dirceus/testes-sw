package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.RelatorioProducaoDiariaEntity
import org.springframework.data.jpa.repository.JpaRepository


interface RelatorioProducaoDiariaJpaRepository: JpaRepository<RelatorioProducaoDiariaEntity, Long>{



}

