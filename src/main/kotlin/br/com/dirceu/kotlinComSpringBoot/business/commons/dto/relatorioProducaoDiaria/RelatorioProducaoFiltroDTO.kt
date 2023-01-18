package br.com.dirceu.kotlinComSpringBoot.business.commons.dto.relatorioProducaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.commons.QueryPaginavel
import java.util.*

class RelatorioProducaoFiltroDTO (

    var codigoUnidadeNegocio: Int,
    var periodoInicio: Date?,
    var periodoFim: Date?,
    override var pagina: Int = 0,
    override var tamanho: Int = 100,
    override var ordenacaoProp: String = "data",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)