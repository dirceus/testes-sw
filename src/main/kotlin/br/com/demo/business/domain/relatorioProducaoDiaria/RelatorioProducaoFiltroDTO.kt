package br.com.demo.business.domain.relatorioProducaoDiaria

import br.com.demo.business.commons.QueryPaginavel
import java.util.*

class RelatorioProducaoFiltroDTO (

    var codigoUnidadeNegocio: Int,
    var periodoInicio: Date?,
    var periodoFim: Date?,
    override var pagina: Int = 0,
    override var tamanho: Int = 10,
    override var ordenacaoProp: String = "periodoInicio",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)