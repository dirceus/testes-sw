package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.NoSipEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*


interface NoSipJpaRepository: JpaRepository<NoSipEntity, Long> {




    @Query("from NoSipEntity n where n.unidadeNegocio.id = :codUn and n.id = :codNoSip")
    fun findByCodigoUnAndCodigoNoSip(@Param("codUn") codUn: Int,@Param("codNoSip") codNoSip: Int)
            : NoSipEntity?

}

