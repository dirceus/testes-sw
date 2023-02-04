package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.VinculoInstalacaoPocoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VinculoInstalacaoPocoJpaRepository : JpaRepository<VinculoInstalacaoPocoEntity, Int> {
}