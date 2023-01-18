package br.com.dirceu.kotlinComSpringBoot.business.domain.tanqueProducao

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio

data class TanqueProducao(
    val codigo: Int?,
    val unidadeNegocio: UnidadeNegocio,
    val nome: String
)