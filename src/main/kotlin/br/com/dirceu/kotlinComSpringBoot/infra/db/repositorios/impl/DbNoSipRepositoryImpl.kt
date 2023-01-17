package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoProducaoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSip
import br.com.dirceu.kotlinComSpringBoot.business.domain.noSip.NoSipRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.NoProducaoSipEntity
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.NoProducaoSipJpaRepository
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.NoSipJpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class DbNoSipRepositoryImpl(
    private val noSipJpaRepository: NoSipJpaRepository,
    private val noProducaoSipJpaRepository: NoProducaoSipJpaRepository
) :
    NoSipRepository {

    override fun obterNosProducaoSipComProducaoNaData(unidadeNegocio: UnidadeNegocio, data: Date): List<NoProducaoSip> {
        val entities = noProducaoSipJpaRepository.findByCodigoUnAndData(unidadeNegocio.codigo!!, data)
        return entities.map { it.toNoProducaoSip() }
    }

    override fun salvarProducaoNoSip(noProducaoSip: NoProducaoSip){
        val entity = NoProducaoSipEntity()
        entity.fromNoProducaoSip(noProducaoSip)
        noProducaoSipJpaRepository.save(entity)
    }

    override fun obterNoSip(codigoUn: Int, codigoNo: Int): NoSip? {
        val entity =
            noSipJpaRepository.findByCodigoUnAndCodigoNoSip(codigoUn,codigoNo)
                ?: return null
        return entity.toNoSip()
    }


}