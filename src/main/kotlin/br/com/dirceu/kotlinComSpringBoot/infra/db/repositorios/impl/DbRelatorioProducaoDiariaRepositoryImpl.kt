package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.impl

import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.relatorioProducaoDiaria.RelatorioProducaoFiltroDTO
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaRepository
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.RelatorioProducaoDiariaEntity
import br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios.RelatorioProducaoDiariaJpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class DbRelatorioProducaoDiariaRepositoryImpl(private val relatorioProducaoDiariaJpaRepository: RelatorioProducaoDiariaJpaRepository) :
    RelatorioProducaoDiariaRepository {

    override fun salvar(relatorioProducaoDiaria: RelatorioProducaoDiaria) {
        var entity = RelatorioProducaoDiariaEntity()
        entity.fromRelatorioProducaoDiaria(relatorioProducaoDiaria)
        relatorioProducaoDiariaJpaRepository.save(entity)
    }

    override fun consultar(alocacaoDiariaFiltroDTO: RelatorioProducaoFiltroDTO): List<RelatorioProducaoDiaria> {
        TODO("Not yet implemented")
    }

    override fun obter(un: UnidadeNegocio, data: Date): RelatorioProducaoDiaria? {
        TODO("Not yet implemented")
    }

    override fun excluir(un: UnidadeNegocio, data: Date) {
        TODO("Not yet implemented")
    }


}