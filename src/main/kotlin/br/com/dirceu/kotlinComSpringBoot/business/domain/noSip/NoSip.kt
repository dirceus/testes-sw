package br.com.dirceu.kotlinComSpringBoot.business.domain.noSip

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio

data class NoSip(
    val codigo: Int?,
    val unidadeNegocio: UnidadeNegocio,
    val nome: String
)