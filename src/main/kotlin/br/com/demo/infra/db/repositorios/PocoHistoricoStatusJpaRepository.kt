package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.PocoHistorioStatusEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query

interface PocoHistoricoStatusJpaRepository : JpaRepository<PocoHistorioStatusEntity, Int>, JpaSpecificationExecutor<PocoHistorioStatusEntity> {


    @Query("from PocoHistorioStatusEntity hs where hs.poco.id = :codPoco")
    fun obterHistoricoPoco(codPoco : Int) : MutableList<PocoHistorioStatusEntity>

}