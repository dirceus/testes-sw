package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.PocoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PocoJpaRepository : JpaRepository<PocoEntity, Int>{

    @Query("select * from POCAS_VINCULADAS_TANQUE vinc " +
            "JOIN POCA_PETROLEO p ON vinc.poca_id = p.id " +
            "WHERE vinc.tanque_id = :codTanque",
        nativeQuery = true)
    fun findByVinculoComTanque(@Param("codTanque") codTanque: Int) : List<PocoEntity>


}