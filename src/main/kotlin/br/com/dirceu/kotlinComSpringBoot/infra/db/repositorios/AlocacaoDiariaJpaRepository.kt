package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.AlocacaoDiariaEntity
import org.springframework.data.jpa.repository.JpaRepository


interface AlocacaoDiariaJpaRepository: JpaRepository<AlocacaoDiariaEntity, Long>{



}

