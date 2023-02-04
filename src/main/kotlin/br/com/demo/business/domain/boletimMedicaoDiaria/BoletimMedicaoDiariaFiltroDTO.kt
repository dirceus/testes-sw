package br.com.demo.business.domain.boletimMedicaoDiaria

import br.com.demo.business.commons.QueryPaginavel
import java.time.LocalDate

class BoletimMedicaoDiariaFiltroDTO(
    val codUnidadeNegocio: Int,
    val instalacoes: List<Int>?,
    val dataInicio: LocalDate,
    val dataFim: LocalDate?,
    override var pagina: Int = 0,
    override var tamanho: Int = 10,
    override var ordenacaoProp: String = "data",
    override var ordenacaoAsc: Boolean = true

) : QueryPaginavel(pagina, tamanho, ordenacaoProp, ordenacaoAsc)
