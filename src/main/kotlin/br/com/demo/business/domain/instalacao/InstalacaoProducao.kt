package br.com.demo.business.domain.instalacao

import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio

data class InstalacaoProducao(
    val codigo: Int?,
    val unidadeNegocio: UnidadeNegocio,
    val nome: String,
    val ativo: Boolean
)