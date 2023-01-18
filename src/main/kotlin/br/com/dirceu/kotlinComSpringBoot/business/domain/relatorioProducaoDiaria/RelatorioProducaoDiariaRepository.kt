package br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.commons.dto.relatorioProducaoDiaria.RelatorioProducaoFiltroDTO
import java.util.*

interface RelatorioProducaoDiariaRepository {
    abstract fun salvar(relatorioProducaoDiaria: RelatorioProducaoDiaria)
    abstract fun consultar(alocacaoDiariaFiltroDTO : RelatorioProducaoFiltroDTO) : List<RelatorioProducaoDiaria>
    abstract fun obter(un: UnidadeNegocio, data: Date) : RelatorioProducaoDiaria?
    abstract fun excluir(un:UnidadeNegocio, data: Date) : Unit
}