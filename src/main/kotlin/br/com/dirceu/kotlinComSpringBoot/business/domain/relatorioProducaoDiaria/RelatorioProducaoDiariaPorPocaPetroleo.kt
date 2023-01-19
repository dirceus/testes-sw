package br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.PocaPetroleo.PocaPetroleo
import java.util.*

data class RelatorioProducaoDiariaPorPocaPetroleo(
    val codigo: Int?,
    val data: Date,
    val producao: Double,
    var uc: PocaPetroleo
)
{
}