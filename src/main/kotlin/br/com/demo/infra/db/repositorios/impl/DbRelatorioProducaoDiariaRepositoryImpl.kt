package br.com.demo.infra.db.repositorios.impl

import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiaria
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoDiariaRepository
import br.com.demo.business.domain.relatorioProducaoDiaria.RelatorioProducaoFiltroDTO
import br.com.demo.infra.db.entities.RelatorioProducaoDiariaEntity
import br.com.demo.infra.db.repositorios.RelatorioProducaoDiariaJpaRepository
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

    override fun consultar(relatorioProducaoDiaria: RelatorioProducaoFiltroDTO): ListaPaginada<RelatorioProducaoDiaria> {
        TODO("Not yet implemented")
    }

    override fun obter(codUn: Int, data: Date): RelatorioProducaoDiaria? {
        TODO("Not yet implemented")
    }

    override fun excluir(codUn: Int, data: Date) {
        TODO("Not yet implemented")
    }


}