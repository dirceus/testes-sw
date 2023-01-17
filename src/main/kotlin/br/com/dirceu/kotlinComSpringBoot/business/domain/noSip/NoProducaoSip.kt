package br.com.dirceu.kotlinComSpringBoot.business.domain.noSip

import java.util.*

data class NoProducaoSip(
    val codigo: Int?,
    val data: Date,
    val producao: Double,
    val noSip: NoSip
)