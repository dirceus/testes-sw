package br.com.dirceu.kotlinComSpringBoot.business.commons.dto.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio

data class UnidadeNegocioDTO(
    val id: Int? = null,
    val nome: String? = null,
    val descricao: String? = null,
    val ativo: Boolean? = null
){

    constructor(un : UnidadeNegocio) :
            this(un.codigo, un.nome, un.descricao, un.emVigencia())



}