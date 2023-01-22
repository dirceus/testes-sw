package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.BoletimMedicaoDiariaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*


interface BoletimMedicaoDiariaJpaRepository: JpaRepository<BoletimMedicaoDiariaEntity, Long> {

    @Query("from ProducaoDiaEntity np join TanqueProducaoEntity n where n.unidadeNegocio.id = :codUn and np.data = :data and np.producao > 0")
    fun findByCodigoUnAndData(@Param("codUn") codUn: Int, @Param("data") data: Date)
            : List<BoletimMedicaoDiariaEntity>

}