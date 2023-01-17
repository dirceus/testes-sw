package br.com.dirceu.kotlinComSpringBoot.commons.dto.alocacaoDiaria

import br.com.dirceu.kotlinComSpringBoot.commons.QueryPaginavel
import java.util.*

class AlocacaoDiariaFiltroDTO (

    var codigoUnidadeNegocio: Int,
    var periodoInicio: Date?,
    var periodoFim: Date?,
    override var pagina: Int = 0,
    override var tamanho: Int = 100,
    override var ordenacaoProp: String = "data",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)