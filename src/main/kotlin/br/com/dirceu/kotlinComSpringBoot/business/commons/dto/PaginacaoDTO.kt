package br.com.dirceu.kotlinComSpringBoot.business.commons.dto

open class PaginacaoDto(
    open val numero: Int? = null,
    open val tamanho: Int? = null,
    open val prop: String? = null,
    open val ascendente: Boolean? = null
)


