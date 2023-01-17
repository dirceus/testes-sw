package br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeControle.UnidadeControle
import java.util.*

data class AlocacaoDiariaPorUC(
    val codigo: Int?,
    val data: Date,
    val producao: Double,
    var uc: UnidadeControle
)
{
}