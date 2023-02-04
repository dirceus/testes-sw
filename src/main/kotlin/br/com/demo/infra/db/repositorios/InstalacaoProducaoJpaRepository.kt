package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface InstalacaoProducaoJpaRepository: JpaRepository<InstalacaoProducaoEntity, Int>,
    JpaSpecificationExecutor<InstalacaoProducaoEntity> {
}

