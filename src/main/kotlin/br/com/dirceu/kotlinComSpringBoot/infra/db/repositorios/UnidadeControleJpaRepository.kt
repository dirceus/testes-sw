package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.UnidadeControleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UnidadeControleJpaRepository : JpaRepository<UnidadeControleEntity, Int>{

    @Query("SELECT * FROM ucs_vinculadas_no_sip vinc " +
            "JOIN unidade_controle uc ON vinc.unidade_controle_id = uc.id " +
            "WHERE vinc.no_sip_id = :codNo",
        nativeQuery = true)
    fun findByVinculoComNo(@Param("codNo") codNo: Int) : List<UnidadeControleEntity>


}