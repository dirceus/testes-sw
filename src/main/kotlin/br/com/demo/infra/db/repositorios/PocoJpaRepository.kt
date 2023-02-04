package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.PocoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PocoJpaRepository : JpaRepository<PocoEntity, Int>, JpaSpecificationExecutor<PocoEntity> {


}