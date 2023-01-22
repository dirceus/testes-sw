package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.InstalacaoProducaoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*


interface InstalacaoProducaoJpaRepository: JpaRepository<InstalacaoProducaoEntity, Int> {




    @Query("from TanqueProducaoEntity n where n.unidadeNegocio.id = :codUn and n.id = :codTanque")
    fun findByCodigoUnAndCodigoNoSip(@Param("codUn") codUn: Int,@Param("codTanque") codTanque: Int)
            : InstalacaoProducaoEntity?

}

