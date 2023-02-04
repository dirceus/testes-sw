package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import org.springframework.data.jpa.repository.JpaRepository


interface InstalacaoProducaoJpaRepository: JpaRepository<InstalacaoProducaoEntity, Int> {



}

