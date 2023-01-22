package br.com.demo.business.domain.relatorioProducaoDiaria

import br.com.demo.business.commons.ListaPaginada
import java.util.*

interface RelatorioProducaoDiariaRepository {
    abstract fun salvar(relatorioProducaoDiaria: RelatorioProducaoDiaria)
    abstract fun consultar(relatorioProducaoDiaria : RelatorioProducaoFiltroDTO) : ListaPaginada<RelatorioProducaoDiaria>
    abstract fun obter(codUn: Int, data: Date) : RelatorioProducaoDiaria?
    abstract fun excluir(codUn: Int, data: Date) : Unit
}