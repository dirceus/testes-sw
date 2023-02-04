package br.com.demo.business.domain.relatorioProducaoDiaria

import br.com.demo.business.domain.poco.Poco
import java.time.LocalDate

data class ProducaoDiariaPorPoco(
    val poco: Poco,
    val data: LocalDate,
    val producao: Double,
    )
{
    var codigo: Int? = null
}