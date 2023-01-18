package br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao

import java.util.*

data class ProducaoDia(
    val codigo: Int?,
    val data: Date,
    val producao: Double,
    val tanqueProducao: TanqueProducao
)