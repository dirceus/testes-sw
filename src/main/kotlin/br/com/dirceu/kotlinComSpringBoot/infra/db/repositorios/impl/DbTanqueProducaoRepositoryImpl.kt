package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.ProducaoDia
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducao
import br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao.TanqueProducaoRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.ProducaoDiaEntity
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.ProducaoDiaJpaRepository
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.TanqueProducaoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class DbTanqueProducaoRepositoryImpl(
    private val tanqueProducaoJpaRepository: TanqueProducaoJpaRepository,
    private val producaoDiaJpaRepository: ProducaoDiaJpaRepository
) :
    TanqueProducaoRepository {

    override fun obterTanquesComProducaoInformadaNaData(unidadeNegocio: UnidadeNegocio, data: Date): List<ProducaoDia> {
        val entities = producaoDiaJpaRepository.findByCodigoUnAndData(unidadeNegocio.codigo!!, data)
        return entities.map { it.toProducaoDia() }
    }

    override fun salvarProducaoDiaPorTanque(producaoDia: ProducaoDia){
        val entity = ProducaoDiaEntity()
        entity.fromProducaoDia(producaoDia)
        producaoDiaJpaRepository.save(entity)
    }

    override fun obterTanqueProducao(codigoUn: Int, codigoAreaProducao: Int): TanqueProducao? {
        val entity =
            tanqueProducaoJpaRepository.findByCodigoUnAndCodigoNoSip(codigoUn,codigoAreaProducao)
                ?: return null
        return entity.toTanqueProducao()
    }


}