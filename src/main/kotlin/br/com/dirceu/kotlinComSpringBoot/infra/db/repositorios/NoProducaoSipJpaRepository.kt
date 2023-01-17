package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.NoProducaoSipEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*


interface NoProducaoSipJpaRepository: JpaRepository<NoProducaoSipEntity, Long> {

    @Query("from NoProducaoSipEntity np join NoSipEntity n where n.unidadeNegocio.id = :codUn and np.data = :data and np.producao > 0")
    fun findByCodigoUnAndData(@Param("codUn") codUn: Int, @Param("data") data: Date)
            : List<NoProducaoSipEntity>

}